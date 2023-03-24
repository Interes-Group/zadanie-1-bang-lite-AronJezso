package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.cards.Card;

import java.util.ArrayList;

public class Player {
    private String name;
    private boolean Alive = true;

    public boolean isAlive() {
        Alive = lives > 0;
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
    private ArrayList<Card> Hand = new ArrayList<>();

    public ArrayList<Card> getHand() {
        return Hand;
    }


    //////FRONT///////FRONT//////
    private ArrayList<Card> Front = new ArrayList<>();

    public ArrayList<Card> getFront() {
        return Front;
    }

    public void addFront(Card card) {
        Front.add(card);
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
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public void printOverlay(ArrayList<Player> players, int turns) {
        System.out.println("Turn = " + turns);
        cara(2);
        System.out.print(ANSI_YELLOW+"PLAYER"+ANSI_RESET);
        cara(5);
        System.out.print(ANSI_GREEN+"LIVES"+ANSI_RESET);
        cara(6);
        System.out.print(ANSI_CYAN+"FRONT"+ANSI_RESET);
        cara(5);
        System.out.println();
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).isAlive()){
                System.out.print(i+1 + " " +ANSI_YELLOW+ players.get(i).name +ANSI_RESET+ " - lives "+ ANSI_GREEN + "{" + players.get(i).lives + "}"+ANSI_RESET+" = ");
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
