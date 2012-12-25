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
        int numPlayers = 4;
        int smallBlind = 100;
        int dealerButton = 1;
        Scanner in = new Scanner(System.in);   
        ArrayList<Player> players = new ArrayList<Player>();
        
        for(int i=0;i<numPlayers;i++)
            players.add(new Player(null));
        
        Deck deck = new Deck();
        deck.shuffle();   
        
		Game game = new Game(players, deck, smallBlind, dealerButton);
        game.start();
        
	}
}
