import java.util.ArrayList;

public class Player {


    enum hand
    {
        HIGH_CARD,
        PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        STRAIGHT_FLUSH,
        ROYAL_FLUSH
        
    }
    private String m_name;
    private int m_bank;
    private ArrayList<Card> m_hand;
    private boolean folded;
    private int m_bet;
    public Player(String name) {
        m_name = name;
        m_bank = 1000;
        m_hand = new ArrayList<Card>();
    }


    
    public String getName()
    {
    	return m_name;
    }
    public void addBank(int n) {
        m_bank += n;
    }

    public void removeBank(int n) {
        m_bank -= n;
    }

    public int getBank() {
        return m_bank;
    }

    public void deal(Card card) {
        m_hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return m_hand;
    }
    
    public Card getCard(int i)
    {
    	return m_hand.get(i);
    }
    public void fold()
    {
        folded = true;
    }
    public boolean getFold()
    {
        return folded;
    }
    public void newHand()
    {
        folded = false;
    }
    public void win(int pot)
    {
        m_bank+=pot;
    }
    public int bet(int b)
    {
        m_bank -= b; //take from player bank amount of 
        m_bet = b;
        return m_bet;
    }
    public int call(int c)
    {        
    	m_bank -= c - m_bet; //take from player bank amount of the current 
    	int temp = m_bet;	 //bet minus what they already had on the table
    	m_bet = c;
    	return c - temp;
    }
    public void raise(int r)
    {
        m_bank -= r;
    }
    public int getBet()
    {
    	return m_bet;
    }
    public String getBestHand(ArrayList<Card> tableCards)
    {
    	ArrayList<Integer> straight = new ArrayList<Integer>();
    	
        String retVal = "";
        
        ArrayList<Card> fullHand = new ArrayList<Card>();
        fullHand.add(m_hand.get(0));
        fullHand.add(m_hand.get(1));
        for(int i = 0; i<3; ++i)
            fullHand.add(tableCards.get(i));
        
        //check for royal flush
        //check for straight flush
        //check for check for full house
        //check for flush
        //check for straight
        //check for three of a kind
        //check for two pair
        //check for pair
        //check high card
        
        return retVal;
    }
}

