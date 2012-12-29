package com.sshipsey.holdem;

import com.sshipsey.holdem.controllers.GameController;
import com.sshipsey.holdem.views.ConsoleGameView;
import com.sshipsey.holdem.views.GameView;

public class Main {

	public static void main(String args[]) {
		// Wire up the Game Controller and start the game loop
		GameView view = new ConsoleGameView();
		GameController controller = new GameController(view);
		controller.start();
	}
}
