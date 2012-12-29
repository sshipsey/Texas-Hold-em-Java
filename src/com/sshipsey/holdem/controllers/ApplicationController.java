package com.sshipsey.holdem.controllers;

import java.util.ArrayList;

import com.sshipsey.holdem.models.*;
import com.sshipsey.holdem.views.*;

public class ApplicationController {
	
	private MainView m_view;
	
	public ApplicationController(MainView view) {
		m_view = view;
	}
	
	public void start() {
		ArrayList<Player> players = new ArrayList<Player>();
		
		int numPlayers = m_view.getNumPlayers();
		int startBank = m_view.getStartBank();
		int smallBlind = m_view.getSmallBlind();
		
		for(int i = 0; i < numPlayers; ++i) {
			String name = m_view.getPlayerName(i);
			players.add(new Player(name, startBank));
		}
		
		Game model = new Game(players, smallBlind);
		GameView view = (GameView) ViewFactory.createView(ViewFactory.View.GAME, model);
		GameController controller = new GameController(model, view);
		controller.start();
	}
}
