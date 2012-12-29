package com.sshipsey.holdem.controllers;

import java.util.ArrayList;

import com.sshipsey.holdem.Card;
import com.sshipsey.holdem.Deck;
import com.sshipsey.holdem.HandEvaluator;
import com.sshipsey.holdem.models.Game;
import com.sshipsey.holdem.models.Player;
import com.sshipsey.holdem.views.GameView;
import com.sshipsey.holdem.views.PlayerView;
import com.sshipsey.holdem.views.ViewFactory;

public class GameController {
	
	private Game m_game;
	private GameView m_view;
	private Deck m_deck = new Deck();
	
	public GameController(Game game, GameView view) {
		m_game = game;
		m_view = view;
	}
	
	public void start() {
		playHand();
	}
	
	private void playHand() {
		m_deck.shuffle();
		anteUp();
		dealHoleCards();
		bettingRound();
		
		burnAndTurn(3);
		bettingRound();
		
		burnAndTurn(1);
		bettingRound();
		
		burnAndTurn(1);
		bettingRound();
		
		assignWinner();
		
		m_game.moveDealerButton();
		m_game.resetAll();
	}

	private void bettingRound() {
		while(true) {
			Player currentPlayer = m_game.getCurrentPlayer();
			
			// Skip folded players
			if(currentPlayer.isFolded()) {
				m_game.nextTurn();
				continue;
			}
			
			// Let player make a choice
			char choice = getPlayerChoice(currentPlayer);
			switch(choice) {
			case 'b':	// Player bets/raises
				m_game.setBet(currentPlayer.getBet());
				// There is purposely no break here. (Read: Switch Statement Fall-Through)
			case 'c':	// Player calls
				m_game.addPot(m_game.getBet());
				break;
			case 'f':	// Player folds
				currentPlayer.fold();
				break;
			}
			
			// Move to next player			
			m_game.nextTurn();
			
			// Determine if we can proceed
			boolean bettingOver = true;
			for(Player p : m_game.getPlayers()) {
				if(p.isFolded()) continue;
				if(p.getBet() != m_game.getBet()) {
					bettingOver = false;
					break;
				}
			}
			if(bettingOver) break;
		}
		m_game.resetBet();
	}

	private char getPlayerChoice(Player currentPlayer) {
		PlayerView view = (PlayerView) ViewFactory.createView(ViewFactory.View.PLAYER, currentPlayer);
		PlayerController controller = new PlayerController(currentPlayer, view);
		return controller.getChoice(m_game);
	}

	private void assignWinner() {
		int maxRank = 0;
		ArrayList<Player> winners = new ArrayList<Player>();
		for(Player p : m_game.getPlayers()) {
			if(p.isFolded()) continue;
			int rank = evaluateHand(p.getHand());
			if(rank > maxRank) {
				maxRank = rank;
				winners.clear();
				winners.add(p);
			}
			else if (rank == maxRank) {
				winners.add(p);
			}
		}
		
		// TODO: Can't have half a chip so integer math works well but
		// we can actually lose a chip doing this. Needs work.
		int splitPot = m_game.getPot() / winners.size(); 
		for(Player p : winners) p.addBank(splitPot);
	}
	
	private int evaluateHand(ArrayList<Card> holeCards) {
		ArrayList<Card> fullHand = new ArrayList<Card>();
		fullHand.addAll(holeCards);
		fullHand.addAll(m_game.getTableCards());
		return HandEvaluator.eval(fullHand);
	}

	private void burnAndTurn(int cards) {
		m_deck.getNext(); // Burn
		for(int i = 0; i < cards; ++i)
			m_game.addTableCard(m_deck.getNext());
	}
	
	private void anteUp() {
		int numPlayers = m_game.getNumPlayers();
		int dealerButton = m_game.getDealerButton();
		int smallBlind = m_game.getSmallBlind();
		m_game.getPlayer((dealerButton + 1) % numPlayers).bet(smallBlind);
		m_game.getPlayer((dealerButton + 2) % numPlayers).bet(2 * smallBlind);
		m_game.addPot(3 * smallBlind);
		m_game.setBet(2 * smallBlind);
	}

	private void dealHoleCards() {
		int numPlayers = m_game.getNumPlayers();
		int offset = m_game.getDealerButton() + 1;
		for(int i = 0; i < 2 * numPlayers; ++i)
			m_game.getPlayer((offset + i) % numPlayers).deal(m_deck.getNext());
	}
}