package com.sshipsey.holdem.views;

import java.util.HashMap;
import java.util.Map;
import com.sshipsey.holdem.views.console.ConsoleGameView;
import com.sshipsey.holdem.views.console.ConsoleMainView;
import com.sshipsey.holdem.views.console.ConsolePlayerView;

public class ViewFactory {
	
	public enum View {
		MAIN,
		GAME,
		PLAYER
	}
	
	private static final Map<View, Class<?>> m_viewHash;
	static {
		m_viewHash = new HashMap<View, Class<?>>();
		m_viewHash.put(View.MAIN, ConsoleMainView.class);
		m_viewHash.put(View.GAME, ConsoleGameView.class);
		m_viewHash.put(View.PLAYER, ConsolePlayerView.class);
	}
	
	public static Object createView(View view) {
		Object value = null;
		try {
			value = m_viewHash.get(view).newInstance();
		}
		catch(Exception ex) {
			System.err.println("Fatal Error: Failed to create view of type " + view);
		}
		return value;
	}
}