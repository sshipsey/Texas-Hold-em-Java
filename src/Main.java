import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		int i;
		int numPlayers = 4;
		int smallBlind = 100;
		int blindPosition = 1;
		
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for(i=0;i<numPlayers;i++)
			players.add(new Player(null));
		
		
		ArrayList<Card> tableCards = new ArrayList<Card>();
		
		Table table = new Table(players,smallBlind,blindPosition);
		Deck deck = new Deck();
        deck.shuffle();
        
        
        //deal
        for (i=0;i<2;i++)
        	for(Player player : players)
        		player.deal(deck.getNext());
        	

		System.out.println("Hands:" + "\n" + "-----------");
		
		for(i=0; i < players.size(); ++i)
		System.out.println("Player " + i + " has " + players.get(i).getCard(0) + " " + players.get(i).getCard(1));


		System.out.println("\n"+"\n");
		sleep();
		System.out.println("\n" + "Round of betting.." + "\n");
		sleep();
		System.out.println("Here Comes the Flop!");
		
		//FLOP*********************************************************************
		sleep();
		sleep();
		
		tableCards = table.flop(deck);
		
		System.out.println(tableCards.toString());
		
		sleep();
		sleep();
		
		System.out.println("\n" + "Round of betting.." + "\n");
		sleep();
		
		//TURN*********************************************************************
		tableCards.add(table.turn(deck));
		
		System.out.println("The Turn");
		sleep();
		sleep();
		System.out.println(tableCards.toString());
		
		sleep();
		System.out.println("\n" + "Round of betting.." + "\n");
		sleep();	
		
		//RIVER*********************************************************************
		tableCards.add(table.river(deck));
		
		System.out.println("The River");
		sleep();
		sleep();
		System.out.println(tableCards.toString());

		sleep();
		System.out.println("\n" + "Round of betting.." + "\n");
		sleep();
		System.out.println("Results:" + "\n" + "blah blah blah");
	}

	public static void sleep()
	{
		try {
            Thread.currentThread().sleep(1000);
		} catch(Exception e){}
	}
	
}
