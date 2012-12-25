import java.util.ArrayList;
import java.util.Scanner;


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
    
    public Game(ArrayList<Player> p ,Deck d, int sB, int bP)
    {
        
        players = p;
        smallBlind = sB;
        deck = d;
        dealerButton = bP;
        
    }
    
    
    public ArrayList<Card> flop()
    {
        tableCards.add(deck.getNext());
        tableCards.add(deck.getNext());
        tableCards.add(deck.getNext());
        
        return tableCards;
    }

    public Card turn()
    {
        deck.getNext(); //burn
        return deck.getNext();
    }
    

    public Card river()
    {
        deck.getNext(); //burn
        return deck.getNext();
    }
    public String toString()
    {
        String retVal = "";
        for(Card card:tableCards)
            retVal += card.toString();
        return retVal;
    }
    public int getPot()
    {
        return pot;
    }
    public void addToPot(int a)
    {
        pot+=a;
    }
    public void resetPot()
    {
        pot = 0;
        
    }
    public void start()
    {

        Scanner in = new Scanner(System.in); 
        String choice = null;
        int numPlayers = players.size();


        
        ArrayList<Card> tableCards = new ArrayList<Card>();

        for (i=0;i < 2*players.size();i++)
            players.get((playerTurn + 1 + i) % numPlayers).deal(deck.getNext());
            

        System.out.println("Hands:" + "\n" + "-----------");
        
        for(i=0; i < players.size(); ++i)
        System.out.println("Player " + i + " has " + players.get(i).getCard(0) + " " + players.get(i).getCard(1));
        playerTurn = playerTurn + 1;
        
        if(playerTurn > numPlayers)
            playerTurn = 1;

        System.out.println("\n"+"\n");
        sleep();
        System.out.println("\n" + "Round of betting.." + "\n");
        

        
        


        //deal
        sleep();
        System.out.println("Here Comes the Flop!");
        
        

        
        //FLOP*********************************************************************
        sleep();
        
        tableCards = flop();
        
        displayCards(tableCards);
        
        sleep();
        sleep();
        
        System.out.println("\n" + "Round of betting.." + "\n");
        sleep();
        
        //TURN*********************************************************************
        tableCards.add(turn());
        
        System.out.println("The Turn");
        sleep();
        displayCards(tableCards);
        
        sleep();
        System.out.println("\n" + "Round of betting.." + "\n");
        sleep();    
        
        //RIVER*********************************************************************
        tableCards.add(river());
        
        System.out.println("The River");
        sleep();
        displayCards(tableCards);

        sleep();
        System.out.println("\n" + "Round of betting.." + "\n");
        sleep();
        System.out.println("Results:" + "\n" + "blah blah blah");
    }          

    
        
        
    void sleep()
    {
        try {
            Thread.currentThread().sleep(1000);
        } catch(Exception e){}
    }
    
    
    void askChoice()
    {   
        String choice = in.nextLine();
        while (true)
        {
                System.out.print("Choose and press Enter -- B:Bet C:Check R:Raise F:Fold -- ");
    
                if(choice.equals("B") || choice.equals("b"))
                {
                   System.out.print("\nEnter bet amount: ");
                   bet = Integer.parseInt(in.nextLine());
                   players.get(playerTurn).bet(bet);
                   addToPot(bet);
                   System.out.println("Pot: " + getPot());                    
                   break;
                }
                else if(choice.equals("C") || choice.equals("c"))
                {
                    players.get(playerTurn).check();
                    break;
                }
                else if(choice.equals("R") || choice.equals("r"))
                {
                    System.out.print("\nEnter raise amount: ");
                    raise = Integer.parseInt(in.nextLine());
                    players.get(playerTurn).raise(raise);
                    addToPot(raise);
                    break;
                }
                else if(choice.equals("F") || choice.equals("f"))
                {
                    players.get(playerTurn).fold();
                    break;
                }

        }
    }
    void displayCards(ArrayList<Card> c)
    {
        String retVal="";
        for(Card s : c)
        {
            retVal += s + " ";
        }
        System.out.println(retVal);
    }
}