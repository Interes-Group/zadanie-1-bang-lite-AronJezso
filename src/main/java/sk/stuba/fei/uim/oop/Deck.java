package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.cards.Card;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final ArrayList<Card> DeckOfManyThings;
    private final ArrayList<Card> Bin;
    public Deck() {
        DeckOfManyThings = new ArrayList<>();
        Bin = new ArrayList<>();
    }

    public ArrayList<Card> getDeck() {
        return DeckOfManyThings;
    }

    public void addDeck(Card card) {
        DeckOfManyThings.add(card);
    }

    public ArrayList<Card> getBin() {
        return Bin;
    }

    public void addBin(Card card) {
        Bin.add(card);
    }

    public void addAllBin(ArrayList<Card> pack) {
        Bin.addAll(pack);
    }

    public void Shuffle() {
        System.out.println(ANSI_PURPLE + "The Deck was Shuffled" + ANSI_RESET);
        DeckOfManyThings.addAll(Bin);
        Bin.removeAll(Bin);
        Collections.shuffle(DeckOfManyThings);
    }
}
