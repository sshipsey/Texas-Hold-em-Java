package com.sshipsey.holdem.views.console;

import java.util.Scanner;

public abstract class BaseConsoleView {
	
	private static final Scanner SC = new Scanner(System.in);
	
	protected void display(String message, Object... params) {
		System.out.println(String.format(message, params));
	}
	
	protected String prompt() {
		return prompt("");
	}
	
	protected String prompt(String prompt) {
		System.out.print(prompt);
		return SC.nextLine();
	}
	
	protected int promptInt() {
		return promptInt("");
	}
	
	protected int promptInt(String prompt) {
		int value;
		while(true) {
			try {
				System.out.print(prompt);
				value = Integer.parseInt(SC.nextLine());
				break;
			}
			catch(NumberFormatException ex) {
				display("Invalid input!");
			}
		}
		return value;
	}
	
	protected int promptIntRange(int min, int max) {
		return promptIntRange("", min, max);
	}
	
	protected int promptIntRange(String prompt, int min, int max) {
		int value;
		while(true) {
			value = promptInt(prompt);
			if(value < min || value > max)
				display("Value must be between %d and %d", min, max);
			else
				break;
		}
		return value;
	}
	
	protected char promptChar() {
		return promptChar("");
	}
	
	protected char promptChar(String prompt) {
		String value;
		while(true) {
			System.out.print(prompt);
			value = SC.nextLine().toLowerCase();
			if(value.length() == 1)
				break;
			else
				display("Value must be a single character");
		}
		return value.charAt(0);
	}
	
	protected char promptCharRange(String validChars) {
		return promptCharRange("", validChars);
	}
	
	protected char promptCharRange(String prompt, String validChars) {
		char value;
		while(true) {
			value = promptChar(prompt);
			if(validChars.indexOf(value) == -1)
				display("Value must be on of the following single characters [%s]", validChars);
			else
				break;
		}
		return value;
	}
}
