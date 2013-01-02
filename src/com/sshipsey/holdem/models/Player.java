package com.sshipsey.holdem.models;

import java.util.ArrayList;
import java.util.Observable;

import com.sshipsey.holdem.Card;

public class Player extends Observable {

    private String m_name;
    private int m_bank;
    private ArrayList<Card> m_hand;
    private boolean m_folded;
    private int m_bet;
    private boolean m_allIn;

    public Player(String name, int startBank) {
        m_name = name;
        m_bank = startBank;
        m_hand = new ArrayList<Card>();
        m_folded = false;
        m_allIn = false;
        m_bet = 0;
    }

    public String getName() {
    	return m_name;
    }
    
    public void reset() {
    	m_folded = false;
    	m_hand.clear();
    	resetBet();
    }
    
    public void addBank(int n) {
        m_bank += n;
        setChanged();
    }

    public void removeBank(int n) {
        m_bank -= n;
        setChanged();
    }

    public int getBank() {
        return m_bank;
    }

    public void deal(Card card) {
        m_hand.add(card);
        setChanged();
    }

    public ArrayList<Card> getHand() {
        return m_hand;
    }

    public Card getCard(int i) {
    	return m_hand.get(i);
    }

    public void fold() {
        m_folded = true;
        setChanged();
    }

    public boolean isFolded() {
        return m_folded;
    }

    public boolean isAllIn() {
        return m_allIn;
    }

    public void bet(int b) {
            removeBank(b);
            m_bet += b;
            if (getBank() == 0)
                m_allIn = true;
            setChanged();
    }
    
    public int getBet() {
    	return m_bet;
    }
    
    public void resetBet() {
    	m_bet = 0;
    }

    public String displayHoleCards() {
        String retVal = (getCard(0).toString() + " " + getCard(1).toString());
        return retVal;
    }
}

