package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.cards.Card;

import java.util.ArrayList;

public class Player {
    private String name;
    private boolean Alive = true;

    public boolean isAlive() {
        return Alive;
    }

    public void setAlive(boolean alive) {
        Alive = alive;
    }

    private int lives;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //////////////////////////////////////////


    public Player(int lives) {

        this.lives = lives;

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

    public void addHand(Card card) {
        Hand.add(card);
    }

    //////FRONT///////FRONT//////
    ArrayList<Card> Front = new ArrayList<>();

    public ArrayList<Card> getFront() {
        return Front;
    }

    public void addFront(Card card) {
        Front.add(card);
    }

    public boolean hasInstanceOf(ArrayList<Card> deck, Card card) {
        return true;
    }

    public void PrintCards() {
        System.out.println(getName() + " -- lives: " + getLives());
        // card play
        for (int card = 0; card != getFront().size(); card++) {// Deckbuilding fuckup control

            System.out.println((card + 1) + " Front- " + getFront().get(card).getName());
        }
        for (int card = 0; card != Hand.size(); card++) {// Deckbuilding fuckup control

            System.out.println((card + 1) + " Card- " + Hand.get(card).getName());
        }
    }

    public void AmILastAlive(ArrayList<Player> players, int i) {
        boolean restDed = true;
        for (int d = 0; d != players.size(); d++) {
            if (d != i && players.get(d).isAlive()) {
                restDed = false;
                break;
            }
        }
        if (restDed) {
            System.out.println("\n\n\n\n    " + name + " Won");
            System.exit(0);
        }

    }

    public void cara(int length) {
        for (int i = 0; i != length; i++) {
            System.out.print("-");
        }

    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public void printOverlay(ArrayList<Player> players, int turns) {
        for (int w = 0; w != 6; w++) {
            System.out.println();
        }
        System.out.println("Turn = " + turns);
        cara(2);
        System.out.print("PLAYER");
        cara(5);
        System.out.print("LIVES");
        cara(6);
        System.out.print("FRONT");
        cara(5);
        System.out.println();
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).isAlive()){
                System.out.print(i+1 + " " + players.get(i).name + " - lives "+ ANSI_GREEN + "{" + players.get(i).lives + "}"+ANSI_RESET+" = ");
                for (int y = 0; y < players.get(i).Front.size(); y++) {
                    System.out.print(players.get(i).Front.get(y).getName() + " ");
                }
                System.out.print("\n");
            }
            if(!players.get(i).isAlive()){
                System.out.println(ANSI_RED +i+1 + " " + players.get(i).name + " - DED" +ANSI_RESET);

            }
        }
        cara(35);
        System.out.println();
        System.out.println(name);
        cara(15);
        System.out.print("CARDS");
        cara(15);
        System.out.println();
        for (int i = 0; i < Hand.size(); i++) {
            System.out.println(i+1 + " " + Hand.get(i).getName());
        }
        cara(35);
        System.out.println();

    }

}
