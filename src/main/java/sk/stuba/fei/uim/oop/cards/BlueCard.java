package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Deck;
import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;

public class BlueCard extends Card {


    public BlueCard(String name) {
        super(name);
    }

    public void play(ArrayList<Player> players, int player, Deck deck) {

    }

    public boolean activation(ArrayList<Player> players, int player, ArrayList<Card> deck) {
        return false;
    }
}
