package com.sshipsey.holdem;
import com.sshipsey.holdem.controllers.ApplicationController;
import com.sshipsey.holdem.views.MainView;
import com.sshipsey.holdem.views.ViewFactory;

public class Main {

	public static void main(String args[]) {
		// Wire up the Application Controller and start the game loop
		MainView view = (MainView) ViewFactory.createView(ViewFactory.View.MAIN);
		ApplicationController controller = new ApplicationController(view);
		controller.start();
	}
}
