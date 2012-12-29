package com.sshipsey.holdem.views;

import java.util.Observable;

public class ConsoleGameView extends BaseConsoleView implements GameView {

	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getNumPlayers() {
		return promptIntRange("Enter number of players (2-10): ", 2, 10);
	}

	@Override
	public int getStartBank() {
		return promptInt("Enter the starting bank for players: ");
	}

	@Override
	public int getSmallBlind() {
		return promptInt("Enter the starting small blind: ");
	}

	@Override
	public String getPlayerName(int i) {
		return prompt("Enter player " + (i + 1) + "'s name: ");
	}
}
