package com.sshipsey.holdem.views.console;

import java.util.Observable;

import com.sshipsey.holdem.models.Player;
import com.sshipsey.holdem.views.PlayerView;

public class ConsolePlayerView extends BaseConsoleView implements PlayerView {
	
	private Player m_player;

	@Override
	public void setModel(Observable model) {
		m_player = (Player) model;
		m_player.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg) {
		display("Player '%s' state updated: ", m_player.getName());
		displayPlayer();
	}

	@Override
	public char getChoice(int currentBet, String validChoices) {
		display("It is %s's turn. Here are the facts:", m_player.getName());
		displayPlayer();
		display("  Current Table Bet: %d", currentBet);
		display("These are your choices:");
		for(char ch : validChoices.toCharArray()) {
			switch(ch) {
			case 'r':
				display("  [r]: Raise the current table bet.");
				break;
			case 'b':
				display("  [b]: Set the current table bet.");
				break;
			case 'c':
				display("  [c]: Call the current table bet.");
				break;
			case 'h':
				display("  [h]: Check and do nothing.");
				break;
			case 'f':
				display("  [f]: Fold and discard your hand.");
				break;
			}
		}
		return promptCharRange("> ", validChoices);
	}

	@Override
	public int getPlayerBet() {
		return promptIntRange("Enter Bet: ", 1, m_player.getBank());
	}

	@Override
	public int getPlayerRaise() {
		return promptIntRange("Enter Raise: ", 1, m_player.getBank());
	}
	
	private void displayPlayer() {
		display("  Bank: %d", m_player.getBank());
		display("  Hole Cards: %s", m_player.displayHoleCards());
		if(m_player.isFolded())
			display("  Currently Folded");
		else
			display("  Current Bet: %d", m_player.getBet());
		if (m_player.isAllIn())
		    display("  Currently All in");
	}
}
