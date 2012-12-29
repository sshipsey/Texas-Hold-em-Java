package com.sshipsey.holdem.views.console;

import java.util.Observable;

import com.sshipsey.holdem.models.Player;
import com.sshipsey.holdem.views.PlayerView;

public class ConsolePlayerView extends BaseConsoleView implements PlayerView {
	
	private Player m_player;
	
	public ConsolePlayerView(Observable model) {
		m_player = (Player) model;
		m_player.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
	}
}
