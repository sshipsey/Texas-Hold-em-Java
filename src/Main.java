import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
public class Main {

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		int i;
		int turn;
		int bet = 0;
		int raise = 0;
		int numPlayers = 4;
		int smallBlind = 100;
		int dealerButton = 1;
		String choice = null;
		Scanner in = new Scanner(System.in);
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for(i=0;i<numPlayers;i++)
			players.add(new Player(null));
	
		ArrayList<Card> tableCards = new ArrayList<Card>();
		
	    Deck deck = new Deck();
		
		Game game = new Game(players, deck, smallBlind, dealerButton);
        game.start();
        
        //deal
        for (i=0;i < 2*players.size();i++)
        	players.get((dealerButton+ 1 + i) % numPlayers).deal(deck.getNext());
        	

		System.out.println("Hands:" + "\n" + "-----------");
		
		for(i=0; i < players.size(); ++i)
		System.out.println("Player " + i + " has " + players.get(i).getCard(0) + " " + players.get(i).getCard(1));
		turn = dealerButton + 1;

		System.out.println("\n"+"\n");
		sleep();
		System.out.println("\n" + "Round of betting.." + "\n");
		

		
		
		while (true)
		{
		System.out.print("Choose and press Enter -- B:Bet C:Check R:Raise F:Fold -- ");
		choice = in.nextLine();
		
		if(choice.equals("B") || choice.equals("b"))
		{
		    System.out.print("\nEnter bet amount: ");
		    bet = Integer.parseInt(in.nextLine());
		    players.get(turn).bet(game, bet);
		    System.out.println("Pot: " + game.getPot());
		    break;
		}
		else if(choice.equals("C") || choice.equals("c"))
		{
		    players.get(turn).check();
		    break;
		}
		else if(choice.equals("R") || choice.equals("r"))
		{
		    System.out.print("\nEnter raise amount: ");
		    raise = Integer.parseInt(in.nextLine());
		    players.get(turn).raise(game, raise);
		}
		
		break;
		}
		
		sleep();
		System.out.println("Here Comes the Flop!");
		
		

		
		//FLOP*********************************************************************
		sleep();
		sleep();
		
		tableCards = game.flop();
		
		System.out.println(tableCards.toString());
		
		sleep();
		sleep();
		
		System.out.println("\n" + "Round of betting.." + "\n");
		sleep();
		
		//TURN*********************************************************************
		tableCards.add(game.turn());
		
		System.out.println("The Turn");
		sleep();
		sleep();
		System.out.println(tableCards.toString());
		
		sleep();
		System.out.println("\n" + "Round of betting.." + "\n");
		sleep();	
		
		//RIVER*********************************************************************
		tableCards.add(game.river());
		
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
