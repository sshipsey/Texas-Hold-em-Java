package com.sshipsey.holdem.views;

import java.util.Observer;

public interface GameView extends Observer {

	public int getNumPlayers();

	public int getStartBank();

	public int getSmallBlind();

	public String getPlayerName(int i);
}
