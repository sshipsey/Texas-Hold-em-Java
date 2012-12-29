package com.sshipsey.holdem.views;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

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
			// Eat the exception (we need to do more here)
		}
		return value;
	}
	
	public static Object createView(View view, Observable model) {
		Object value = null;
		try {
			Constructor<?> constructor = m_viewHash.get(view).getConstructor(Observable.class);
			value = constructor.newInstance(model);
		}
		catch(Exception ex) {
			// Eat the exception (we need to do more here)
		}
		return value;
	}
}