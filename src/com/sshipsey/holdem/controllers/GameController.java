package com.sshipsey.holdem.controllers;

import java.util.ArrayList;

import com.sshipsey.holdem.models.Game;
import com.sshipsey.holdem.models.Player;
import com.sshipsey.holdem.views.GameView;

public class GameController {
	private Game m_game;
	private GameView m_view;
	
	public GameController(GameView view) {
		m_view = view;
	}
	
	public void start() {
		createModel();
		
		m_game.start();
	}
	
	private void createModel() {
		ArrayList<Player> players = new ArrayList<Player>();
		
		int numPlayers = m_view.getNumPlayers();
		int startBank = m_view.getStartBank();
		int smallBlind = m_view.getSmallBlind();
		
		for(int i = 0; i < numPlayers; ++i) {
			String name = m_view.getPlayerName(i);
			players.add(new Player(name, startBank));
		}
		
		m_game = new Game(players, smallBlind, m_view);
	}
}
