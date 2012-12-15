import java.util.*;
import java.awt.*;
import javax.swing.*;


public class main {
	@SuppressWarnings("unused")
	public static void main(String args[])
	{

		int i = 0;
		int j = 0;
		deck deckObj = new deck();
		card[] deck = deckObj.makeDeck();

		
		card[] p1hand = new card[2];
		card[] p2hand = new card[2];
		card[] p3hand = new card[2];
		card[] p4hand = new card[2];
		card[] p5hand = new card[2];
		//deal
		
		int numPlayers = 5;
		j=0;
		for(i=0;i<2;i++)
		{
			
			p1hand[i] = deck[j];
			j++;
			p2hand[i] = deck[j];
			j++;
			p3hand[i] = deck[j];
			j++;
			p4hand[i] = deck[j];
			j++;
			p5hand[i] = deck[j];
			j++;
		}
		
		System.out.println("Hands:" + "\n" + "-----------");
		System.out.println("Player 1 has " + p1hand[0].value + p1hand[0].suit + " and " + p1hand[1].value + p1hand[1].suit);
		System.out.println("Player 2 has " + p2hand[0].value + p2hand[0].suit + " and " + p2hand[1].value + p2hand[1].suit);
		System.out.println("Player 3 has " + p3hand[0].value + p3hand[0].suit + " and " + p3hand[1].value + p3hand[1].suit);
		System.out.println("Player 4 has " + p4hand[0].value + p4hand[0].suit + " and " + p4hand[1].value + p4hand[1].suit);
		System.out.println("Player 5 has " + p5hand[0].value + p5hand[0].suit + " and " + p5hand[1].value + p5hand[1].suit);
	
		System.out.println("\n"+"\n");
		
		sleep(2000);
		
		System.out.println("\n" + "Round of betting.." + "\n");
		
		sleep(2000);
		System.out.println("Here Comes the Flop!");
		
		
		
		//flop
		sleep(2000);
		card[] tableCards = new card[5];
		
		tableCards[0] = deck[j];
		System.out.print("" + tableCards[0].value + tableCards[0].suit);
		j++;
		sleep(2000);
		tableCards[1] = deck[j];
		System.out.print("   " + tableCards[1].value + tableCards[1].suit);
		j++;
		sleep(2000);
		tableCards[2] = deck[j];
		System.out.println("   " + tableCards[2].value + tableCards[2].suit);
		j++;
		
		sleep(2000);
		
		System.out.println("\n" + "Round of betting.." + "\n");
		
		sleep(2000);
		
		System.out.println("The Turn");
		sleep(2000);
		System.out.print("" + tableCards[0].value + tableCards[0].suit);
		System.out.print("   " + tableCards[1].value + tableCards[1].suit);
		System.out.print("   " + tableCards[2].value + tableCards[2].suit);
		sleep(2000);
		
		tableCards[3] = deck[j];
		System.out.println("   " + tableCards[3].value + tableCards[3].suit);
		j++;
		
		sleep(2000);
		System.out.println("\n" + "Round of betting.." + "\n");
		
		sleep(2000);
		
		System.out.println("The River");
		sleep(2000);
		System.out.print("" + tableCards[0].value + tableCards[0].suit);
		System.out.print("   " + tableCards[1].value + tableCards[1].suit);
		System.out.print("   " + tableCards[2].value + tableCards[2].suit);
		System.out.print("   " + tableCards[3].value + tableCards[3].suit);
		sleep(2000);
		
		tableCards[4] = deck[j];
		System.out.println("   " + tableCards[4].value + tableCards[4].suit);
		j++;
		sleep(2000);
		
		System.out.println("\n" + "Round of betting.." + "\n");
		sleep(2000);
		System.out.println("Results:" + "\n" + "blah blah blah");
		
	//GRAPHICS
	//window frame = new window();

	}
	
	public static void sleep(long n)
	{
		try{
		Thread.currentThread().sleep(n);
		} catch(Exception e){}
	}

	
	
	
	
	


}