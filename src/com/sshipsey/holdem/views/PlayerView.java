package com.sshipsey.holdem.views;

public interface PlayerView extends BaseView {
	
	public char getChoice(int currentBet, String validChoices);
	
	public int getPlayerBet();
	
	public int getPlayerRaise();
}
