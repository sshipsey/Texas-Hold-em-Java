import java.util.*;

enum finalHand{

	HIGH_CARD,
	PAIR,
	TWO_PAIR,
	THREE_OF_A_KIND,
	STRAIGHT,
	FLUSH,
	FULL_HOUSE,
	FOUR_OF_A_KIND,
	STRAIGHT_FLUSH,
	ROYAL_FLUSH;
}

public class Game {
	

	
    private Deck deck = new Deck();
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Card> tableCards = new ArrayList<Card>();
    private int smallBlind;
    private int dealerButton;
    private int pot;
    private int i;
    private int playerTurn;
    private int bet = 0;
    private int raise = 0;
    private Scanner in = new Scanner(System.in);

    private int numPlayers;

    public Game(ArrayList<Player> p, int sB, int bP) {
        players = p;
        smallBlind = sB;
        dealerButton = bP;
        numPlayers = players.size();
        deck.shuffle();
    }

    public ArrayList<Card> flop() {
        tableCards.add(deck.getNext());
        tableCards.add(deck.getNext());
        tableCards.add(deck.getNext());

        return tableCards;
    }

    public Card turn() {
        deck.getNext(); //burn
        return deck.getNext();
    }

    public Card river() {
        deck.getNext(); //burn
        return deck.getNext();
    }

    public String toString() {
        String retVal = "";
        for(Card card:tableCards)
            retVal += card.toString();
        return retVal;
    }

    public int getPot() {
        return pot;
    }

    public void addToPot(int a) {
        pot += a;
    }

    public void resetPot() {
        pot = 0;
    }

    public void anteUp(int t) {
    	players.get((t+1) % numPlayers).bet(smallBlind);
    	addToPot(smallBlind);
    	players.get((t+2) % numPlayers).bet(smallBlind*2);
    	addToPot(smallBlind*2);
    	bet = smallBlind*2;
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        String choice = null;

        ArrayList<Card> tableCards = new ArrayList<Card>();

        for (i=0;i < 2*players.size();i++)
            players.get((playerTurn + 1 + i) % numPlayers).deal(deck.getNext());

        System.out.println("\nHands:" + "\n" + "-----------");

        for(i=0; i < players.size(); ++i)
        System.out.println(players.get(i).getName() + " has " + players.get(i).getCard(0) + " " + players.get(i).getCard(1));

        System.out.println("\n" + players.get(dealerButton).getName() + " Deals");

        anteUp(dealerButton);
        playerTurn = dealerButton + 3;
        System.out.println("\n\n\nPot: " + pot);
        //sleep();
        System.out.println("\n" + "Round of betting.." + "\n");
        
        boolean bettingOver;
     /*
        while (true)
        { //modified version of betRound() for pre-flop scenario

        	playerTurn = playerTurn % numPlayers;
        	askChoice();
        	bettingOver = true;
        	for(Player p : players)
        	{
        		if (p.isFolded())
        			continue;
        		if (p.getBet() != bet)
        			bettingOver = false;		
        	}
        	if (bettingOver == true)
        		break;
        	}
      */




        //deal
        //sleep();
        System.out.println("Here Comes the Flop!");




        //FLOP*********************************************************************
        //sleep();

        tableCards = flop();

        displayCards(tableCards);

        //sleep();
        //sleep();

        System.out.println("\n" + "Round of betting.." + "\n");
        //sleep();

      //  betRound();

        //TURN*********************************************************************
        tableCards.add(turn());

        System.out.println("The Turn");
        //sleep();
        displayCards(tableCards);

        //sleep();
        System.out.println("\n" + "Round of betting.." + "\n");
        //sleep();
      //  betRound();

        //RIVER*********************************************************************
        tableCards.add(river());

        System.out.println("The River");
        //sleep();
        displayCards(tableCards);

        //sleep();
        System.out.println("\n" + "Round of betting.." + "\n");
        //sleep();
      //  betRound();
        System.out.println("Results:\n-----------");
        
        
        ArrayList<Integer> handRankings = new ArrayList<Integer>();
    	
        for(Player p : players) {
        	ArrayList<Card> fullHand = new ArrayList<Card>();
        	fullHand.addAll(p.getHand());
        	fullHand.addAll(tableCards);
        	System.out.print(p.getName()+ " has cards ");
        	for(Card c:fullHand)
        	{
        		System.out.print(c.toString());
        	}
        	System.out.println("");
        	handRankings.add(HandEvaluator.eval(fullHand));
        	
        	}
        int winnerIndex = 0;
        for(int i = 0; i < handRankings.size()-1;i++) {
        	if(handRankings.get(i+1)>handRankings.get(winnerIndex))
        		winnerIndex = i+1;
        }
        int handRank = (handRankings.get(winnerIndex) >> 12);
        displayWinner(players.get(winnerIndex),handRank);
    }
    
    
    
    
    void sleep() {
        try {
            Thread.currentThread().sleep(1000);
        } catch(Exception e){}
    }


    void askChoice() {

        while (true) //I wrote a lot of this at 6:30AM. I hope it makes sense.
        {
        		if (players.get(playerTurn).isFolded())
        		{
        			playerTurn++;
        			break;  //skip if player is folded
        		}
        		System.out.println(players.get(playerTurn).getName() + "'s turn (Bank:" + players.get(playerTurn).getBank() + ")\nCurrent bet is " + bet);
                System.out.print("Choose and press Enter\n----------------------\n");
                if(bet == 0)
                	System.out.println("C:Check\nB:Bet\nF:Fold"); //no bets
                else if(bet != 0 && bet != players.get(playerTurn).getBet())
                	System.out.println("C:Call\nR:Raise\nF:Fold"); //someone has bet
                else
                	System.out.println("C:Check\nR:Raise\nF:Fold"); //should only be reached on big blind with no raise pre-flop

                String choice = in.nextLine();
                //if B and there is no current bet, BET
                if(bet == 0 && (choice.equals("B") || choice.equals("b")))
                {
                   System.out.print("\nEnter bet amount: ");
                   bet = Integer.parseInt(in.nextLine());
           		   players.get(playerTurn).bet(bet);
                   addToPot(bet);
           		   System.out.println(players.get(playerTurn).getName() + " Bets " + bet + "\n");
                   System.out.println("Pot: " + getPot());
                   playerTurn++;
                   break;
                }

                //if C, check for bet. if no bet, CHECK. if bet, CALL
                else if(choice.equals("C") || choice.equals("c"))
                {
                	if(bet == 0)
                	{
                		// do nothing, AKA check
                		System.out.println(players.get(playerTurn).getName() + " Checks" + "\n");
                		playerTurn++;
                	}
                	else
                	{
                		//call
                		addToPot(players.get(playerTurn).call(bet));
                		System.out.println(players.get(playerTurn).getName() + " Calls (" + bet + ")");
                        System.out.println("Pot: " + getPot() + "\n");
                        playerTurn++;
                	}
                		break;
                }
                //if R, RAISE, but make sure raise > bet before applying
                else if(bet > 0 && (choice.equals("R") || choice.equals("r")))
                {
                    System.out.print("\nEnter raise amount: ");
                    raise = Integer.parseInt(in.nextLine());
                    if (raise > bet)
                    {
                    	players.get(playerTurn).raise(raise);
                    	addToPot(raise);
                       	bet=raise;
                    	System.out.println(players.get(playerTurn).getName() + " Raises to " + bet);
                        System.out.println("Pot: " + getPot() + "\n");
                    	playerTurn++;
                    }
                    else
                    {
                    	System.out.println("Raise must be greater than current bet (" + bet + ")");
                    	askChoice();
                    }
                    	break;
                }
                else if(choice.equals("F") || choice.equals("f"))
                {
                    players.get(playerTurn).fold();
                    playerTurn++;
                    break;
                }
                else
                {
                	System.out.println("Invalid Entry");
                	askChoice();
                }
        }
    }

    void displayCards(ArrayList<Card> c) {
        String retVal="";
        for(Card s : c)
        {
            retVal += s + " ";
        }
        System.out.println(retVal);
    }

    void betRound() {
    	boolean bettingOver;
        while (true)
        { //modified version of betRound() for pre-flop scenario

        	playerTurn = playerTurn % numPlayers;
        	askChoice();
        	bettingOver = true;
        	for(Player p : players)
        	{
        		if (p.isFolded())
        			continue;
        		if (p.getBet() != bet)
        			bettingOver = false;		
        	}
        	if (bettingOver == true)
        		break;
        	}
    }
    
    void displayWinner(Player p, int i)
    {
    	finalHand f = finalHand.values()[i-1];
    	System.out.println("\n\n" + p.getName() + " has won the hand with a " + f.name());
    	
    }
}
