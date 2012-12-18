import java.util.ArrayList;


public class Table {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Card> tableCards = new ArrayList<Card>();
	private int smallBlind;
	private int blindPosition;
	private int pot;
	
	public Table(ArrayList<Player> p , int sB, int bP)
	{
		
		players = p;
		smallBlind = sB;
		blindPosition = bP;
		
	}
	
	
	public ArrayList<Card> flop(Deck deck)
	{
		tableCards.add(deck.getNext());
		tableCards.add(deck.getNext());
		tableCards.add(deck.getNext());
		
		return tableCards;
	}
	
	Card burn;
	Card turn;
	public Card turn(Deck deck)
	{
		burn = deck.getNext();
		turn = deck.getNext();
		return turn;
	}
	
	Card river;
	public Card river(Deck deck)
	{
		burn = deck.getNext();
		river = deck.getNext();
		return river;
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
}
