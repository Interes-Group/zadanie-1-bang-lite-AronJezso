package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.*;

import java.util.ArrayList;

public class Card {
    private String name;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public Card(String name) {
        this.name = name;
    }

    public String getName() {return name;}
    public void play(ArrayList<Player> players,int player,Deck deck){
    }


}
