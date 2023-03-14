package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;

public class Missed extends Card{
    public Missed() {
        super("Missed");
    }

    @Override
    public void play(ArrayList<Player> players,int player,ArrayList<Card> deck){
        System.out.println("No, stop it, get some help");

    }
}
