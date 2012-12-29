package com.sshipsey.holdem.views.console;

import java.util.Scanner;

public class BaseConsoleView {
	
	private final Scanner sc = new Scanner(System.in);
	
	public void display(String message, Object... params) {
		System.out.println(String.format(message, params));
	}
	
	public String prompt() {
		return prompt("");
	}
	
	public String prompt(String prompt) {
		System.out.print(prompt);
		return sc.nextLine();
	}
	
	public int promptInt() {
		return promptInt("");
	}
	
	public int promptInt(String prompt) {
		int value;
		while(true) {
			try {
				System.out.print(prompt);
				value = Integer.parseInt(sc.nextLine());
				break;
			}
			catch(NumberFormatException ex) {
				display("Invalid input!");
			}
		}
		return value;
	}
	
	public int promptIntRange(int min, int max) {
		return promptIntRange("", min, max);
	}
	
	public int promptIntRange(String prompt, int min, int max) {
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
}
