import java.util.ArrayList;


public class Game {
    private Deck deck = new Deck();
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Card> tableCards = new ArrayList<Card>();
    private int smallBlind;
    private int blindPosition;
    private int pot;
    
    public Game(ArrayList<Player> p ,Deck d, int sB, int bP)
    {
        
        players = p;
        smallBlind = sB;
        blindPosition = bP;
        deck = d;
        
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
        
    }
}
