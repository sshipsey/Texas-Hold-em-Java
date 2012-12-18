import java.util.ArrayList;

public class Player {

    enum choice{
        B,
        C,
        R,
        F
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
    public void bet(Table t, int b)
    {
        m_bank -= b;
        t.addToPot(b);
    }
}

