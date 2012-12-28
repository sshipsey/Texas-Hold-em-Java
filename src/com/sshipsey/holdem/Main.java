package com.sshipsey.holdem;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

import java.util.ArrayList;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String args[]) {
	    //  Initialize Game with
	    //  number of players, starting small blind,
	    //  dealer button position, and a shuffled deck
        int numPlayers;
        int startBank = 1000;
        int smallBlind = 100;
        int dealerButton = 0;
        Scanner in = new Scanner(System.in);

        while(true)
        {
        	System.out.print("Enter number of players(2-10):");
        	try
        	{
        		numPlayers = Integer.parseInt(in.nextLine());
        	}
        	catch(NumberFormatException e)
        	{
        		numPlayers = 0;
        		System.out.println("Invalid Entry");
        	}

        	if (numPlayers >= 2 && numPlayers <=10)
        		break;
        }

        ArrayList<Player> players = new ArrayList<Player>();

        String name;
        for(int i = 1; i <= numPlayers; i++)
        {
        	System.out.print("Enter player " + i + "'s name:");
        	name = in.nextLine();
        	players.add(new Player(name, startBank));
        }

		Game game = new Game(players, smallBlind, dealerButton);
        game.start();

	}
}
