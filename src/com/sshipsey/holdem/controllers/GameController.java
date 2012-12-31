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

public class GameController extends BaseController {
	
	private Game m_game;
	private Deck m_deck = new Deck();
	private ArrayList<PlayerController> m_playerControllers = new ArrayList<PlayerController>();
	
	public GameController(Game game, GameView view) {
		super(game, view);
		m_game = game;
		createPlayerControllers();
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
		removeLosers();
		
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
			makeCurrentPlayerChoice();
			
			// Move to next player			
			m_game.nextTurn();
			
			// TODO: This malfunctions pre-flop. How to fix?
			// TODO: This malfunctions post-flop if the player in first position checks
			//        because after he checks, everyone's bet is 0 and the table
			//        bet is 0.
			// TODO: This whole logic is perhaps wrong. We need to do better.
			// Determine if we can proceed
			
			boolean bettingOver = m_game.getNewDeal();
			
			/*
			for(Player p : m_game.getPlayers()) {
				if(p.isFolded()) continue;
				if(p.getBet() != m_game.getBet()) {
					bettingOver = false;
					break;
				}
			}
			*/
			if(bettingOver) break;
			
		}
		
		m_game.resetBet();
		m_game.resetTurn();
		for(Player p : m_game.getPlayers()) p.resetBet();
	}

	private void makeCurrentPlayerChoice() {
		m_playerControllers.get(m_game.getTurn()).makeChoice(m_game);
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
		
		// I changed this even more, should still work
	    int splitPot = m_game.getPot() / winners.size();
	    int nextPot = m_game.getPot() % winners.size();
		for(Player p : winners) p.addBank(splitPot);
		m_game.setPot(nextPot);
	}
	
	private void removeLosers() {
	    for (Player p : m_game.getPlayers()) {
	        if (p.getBank() == 0) {
	            m_game.removePlayer(p);
	            m_game.hasChanged();
	        }
	    }
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
		m_game.notifyObservers();
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
		for(Player p : m_game.getPlayers()) p.notifyObservers();
	}
	
	private void createPlayerControllers() {
		for(Player p : m_game.getPlayers()) {
			PlayerView view = (PlayerView) ViewFactory.createView(ViewFactory.View.PLAYER);
			PlayerController controller = new PlayerController(p, view);
			m_playerControllers.add(controller);
		}
	}
}