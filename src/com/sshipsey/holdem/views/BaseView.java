package com.sshipsey.holdem.views;

import java.util.Observable;
import java.util.Observer;

public interface BaseView extends Observer {
	
	public void setModel(Observable model);
}