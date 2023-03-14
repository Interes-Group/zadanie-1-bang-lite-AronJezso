package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.cards.Card;

import java.util.ArrayList;

public class Player {
    private String name;
    private int lives;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //////////////////////////////////////////


    public Player(int lives) {

        this.lives=lives;

    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    //////////HAND/////HAND//////
    ArrayList<Card> Hand = new ArrayList<Card>();

    public ArrayList<Card> getHand() {
        return Hand;
    }

    public void setHand(ArrayList<Card> hand) {
        Hand = hand;
    }

    //////FRONT///////FRONT//////
    ArrayList<Card> Front = new ArrayList<>();

    public ArrayList<Card> getFront() {
        return Front;
    }

    public void addFront(Card card) {
        Front.add(card);
    }
}
