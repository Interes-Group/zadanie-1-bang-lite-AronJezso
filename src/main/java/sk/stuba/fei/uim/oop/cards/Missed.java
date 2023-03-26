package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Deck;
import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;

public class Missed extends Card{
    public Missed() {
        super(ANSI_WHITE+"Missed"+ANSI_RESET);
    }

    @Override
    public void play(ArrayList<Player> players, int player, Deck deck){
        System.out.println("No, you cant play this card!");

    }
}
