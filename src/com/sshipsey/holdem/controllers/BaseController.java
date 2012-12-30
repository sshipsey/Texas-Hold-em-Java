package com.sshipsey.holdem.controllers;

import java.util.Observable;

import com.sshipsey.holdem.views.BaseView;

public class BaseController {
	
	public BaseController() {}

	public BaseController(Observable model, BaseView view) {
		view.setModel(model);
	}
}
