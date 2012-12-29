package com.sshipsey.holdem.views.console;

import com.sshipsey.holdem.views.MainView;

public class ConsoleMainView extends BaseConsoleView implements MainView {

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
