package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class Player {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //////////////////////////////////////////
    int lives = 4;

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    ArrayList<Object> Hand = new ArrayList<Object>();

    public ArrayList<Object> getHand() {
        return Hand;
    }

    public void setHand(ArrayList<Object> hand) {
        Hand = hand;
    }
}
