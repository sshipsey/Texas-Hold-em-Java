import java.util.ArrayList;

public class Player {

    private String m_name;
    private int m_bank;
    private ArrayList<Card> m_hand;
    private boolean folded;
    private int m_bet;

    public Player(String name, int startBank) {
        m_name = name;
        m_bank = startBank;
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

    public Card getCard(int i) {
    	return m_hand.get(i);
    }

    public void fold() {
        folded = true;
    }

    public boolean isFolded() {
        return folded;
    }

    public void newHand() {
        folded = false;
    }

    public void bet(int b) {
        removeBank(b);
        m_bet = b;
    }

    public void raise(int r) {
        m_bank -= r;
    }

    public int call(int c) {
        int call = c - m_bet;
        removeBank(call);
    	m_bet = c;
    	return call;
    }

    public int getBet() {
    	return m_bet;
    }
}

