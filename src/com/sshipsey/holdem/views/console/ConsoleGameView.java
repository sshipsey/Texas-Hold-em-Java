package com.sshipsey.holdem.views.console;

import java.util.Observable;

import com.sshipsey.holdem.models.Game;
import com.sshipsey.holdem.views.GameView;

public class ConsoleGameView extends BaseConsoleView implements GameView {
	
	private Game m_game;

	public ConsoleGameView(Observable model) {
		m_game = (Game) model;
		m_game.addObserver(this);
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
	}
}
