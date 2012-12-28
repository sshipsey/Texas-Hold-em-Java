package com.sshipsey.holdem;

import org.pokerai.twoplustwo.Generator;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.Exception;
import java.lang.IllegalArgumentException;

public class HandEvaluator {

    private static final String LUT_FILE = "handranks.dat";
    private static int[] handRanks;

    public static int eval(ArrayList<Card> hand) {
        if (hand.size() > 7 || hand.size() < 5)
            throw new IllegalArgumentException("Hand size must be between 5 and 7");

        loadLookupTable();

        int rank = 53;
        for(Card card : hand) {
            int cardNum = ((4 * card.getValue()) - 7) + card.getSuit().ordinal();
            rank = handRanks[rank + cardNum];
        }

        return rank;
    }

    private static void loadLookupTable() {
        File f = new File(LUT_FILE);

        if(!f.exists()) {
            Generator.generateTables();
            Generator.saveTables(LUT_FILE);
        }

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            handRanks = (int[])ois.readObject();
        }
        catch (Exception e)
        {
            // Eat exception (should we do more here?)
        }
    }
}
