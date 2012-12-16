import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		
		int numPlayers = 4;
		
		Deck deck = new Deck();
        deck.shuffle();
        
        
        // This should be an array of players not 5 variables!!!
		Card[] p1hand = new Card[2];
		Card[] p2hand = new Card[2];
		Card[] p3hand = new Card[2];
		Card[] p4hand = new Card[2];
		Card[] p5hand = new Card[2];

		for (int i = 0; i < 2; i++)
		{
			p1hand[i] = deck.getNext();
			p2hand[i] = deck.getNext();
			p3hand[i] = deck.getNext();
			p4hand[i] = deck.getNext();
			p5hand[i] = deck.getNext();
		}

		System.out.println("Hands:" + "\n" + "-----------");
		System.out.println("Player 1 has " + p1hand[0] + " and " + p1hand[1]);
		System.out.println("Player 2 has " + p2hand[0] + " and " + p2hand[1]);
		System.out.println("Player 3 has " + p3hand[0] + " and " + p3hand[1]);
		System.out.println("Player 4 has " + p4hand[0] + " and " + p4hand[1]);
		System.out.println("Player 5 has " + p5hand[0] + " and " + p5hand[1]);

		System.out.println("\n"+"\n");
		sleep();
		System.out.println("\n" + "Round of betting.." + "\n");
		sleep();
		System.out.println("Here Comes the Flop!");
		//FLOP*********************************************************************
		sleep();
		
		
		Card[] tableCards = new Card[5];
		tableCards = deck.flop(deck);

		System.out.print("" + tableCards[0]);
		sleep();
		System.out.print("   " + tableCards[1]);
		sleep();
		System.out.println("   " + tableCards[2]);
		sleep();
		System.out.println("\n" + "Round of betting.." + "\n");
		sleep();
		
		//TURN*********************************************************************
		tableCards[3] = deck.turn(deck);
		
		System.out.println("The Turn");
		sleep();
		System.out.print("" + tableCards[0]);
		System.out.print("   " + tableCards[1]);
		System.out.print("   " + tableCards[2]);
		sleep();
		System.out.println("   " + tableCards[3]);
		sleep();
		System.out.println("\n" + "Round of betting.." + "\n");
		sleep();	
		
		//RIVER*********************************************************************

		System.out.println("The River");
		sleep();
		System.out.print("" + tableCards[0]);
		System.out.print("   " + tableCards[1]);
		System.out.print("   " + tableCards[2]);
		System.out.print("   " + tableCards[3]);
		sleep();

		tableCards[4] = deck.river(deck);
		System.out.println("   " + tableCards[4]);
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
