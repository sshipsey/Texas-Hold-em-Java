import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
public class Main {

	@SuppressWarnings("unused")
	public static void main(String args[]) {
	    
	    /* Initialize Game with
	     * number of players, starting small blind,
	     * dealer button position, and a shuffled deck    
	     */
        int numPlayers = 0;
        int smallBlind = 100;
        int dealerButton = 0;
        String name = "";
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
        
        
        for(int i=1;i<=numPlayers;i++)
        {
        	System.out.print("Enter player " + i + "'s name:");
        	name = in.nextLine();
        	players.add(new Player(name));
        }
        
        Deck deck = new Deck();
        deck.shuffle();   
        
		Game game = new Game(players, deck, smallBlind, dealerButton);
        game.start();
        
	}
}
