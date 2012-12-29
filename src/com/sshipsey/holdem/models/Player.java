package com.sshipsey.holdem.models;

import java.util.ArrayList;

import com.sshipsey.holdem.Card;

public class Player {

    private String m_name;
    private int m_bank;
    private ArrayList<Card> m_hand;
    private boolean m_folded;
    private int m_bet;

    public Player(String name, int startBank) {
        m_name = name;
        m_bank = startBank;
        m_hand = new ArrayList<Card>();
        m_folded = false;
        m_bet = 0;
    }

    public String getName() {
    	return m_name;
    }
    
    public void reset() {
    	m_folded = false;
    	m_hand.clear();
    	m_bet = 0;
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
        m_folded = true;
    }

    public boolean isFolded() {
        return m_folded;
    }

    public void bet(int b) {
        removeBank(b);
        m_bet += b;
    }

    public int getBet() {
    	return m_bet;
    }
}

