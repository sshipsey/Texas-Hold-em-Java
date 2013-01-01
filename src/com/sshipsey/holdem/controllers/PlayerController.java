package com.sshipsey.holdem.controllers;

import com.sshipsey.holdem.models.Game;
import com.sshipsey.holdem.models.Player;
import com.sshipsey.holdem.views.PlayerView;

public class PlayerController extends BaseController {
	
	private Player m_player;
	private PlayerView m_view;

	public PlayerController(Player player, PlayerView view) {
		super(player, view);
		m_player = player;
		m_view = view;
	}
	
	public void makeChoice(Game game) {
		String validChoices = "f";
		if(game.getBet() == 0)
			validChoices += "bh";
		else if(game.getBet() > m_player.getBet())
			validChoices += "rc";
		else
		    validChoices += "rh";
		
		int bet = 0;
		char choice = m_view.getChoice(game.getBet(), validChoices);
		switch(choice) {
		case 'r':
			bet = game.getBet() - m_player.getBet();
			bet += m_view.getPlayerRaise();
			game.setBet(bet);
			game.resetLeftToAct();
			break;
		case 'b':
			bet = m_view.getPlayerBet();
			game.setBet(bet);
			game.resetLeftToAct();
			break;
		case 'c':
			bet = game.getBet() - m_player.getBet();
			game.playerAct();
			break;
		case 'h':
		    game.playerAct();
		    break;
		case 'f':
			m_player.fold();
			game.playerAct();
			game.foldPlayer(m_player);
			break;
		}
		m_player.bet(bet);
		game.addPot(bet);
	}
}
