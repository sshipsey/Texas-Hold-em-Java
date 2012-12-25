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
    boolean folded;
    
    public Player(String name) {
        m_name = name;
        m_bank = 0;
        m_hand = new ArrayList<Card>();
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
    public void bet(int b)
    {
        m_bank -= b;
    }
    public String check()
    {
        return "\nPlayer checks";
    }
    public void raise(int r)
    {
        m_bank -= r;
    }
    public String getFullHand(ArrayList<Card> tableCards)
    {
        String retVal = "";
        
        ArrayList<Card> fullHand = new ArrayList<Card>();
        fullHand.add(m_hand.get(0));
        fullHand.add(m_hand.get(1));
        for(int i = 0; i<3; ++i)
            fullHand.add(tableCards.get(i));
            

        
        return retVal;
    }
}

