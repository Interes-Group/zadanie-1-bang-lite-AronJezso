package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.cards.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private final ArrayList<Player> players;
    private final Scanner scanIn;
    private final ArrayList<Card> Deck_of_many_things;

    public Game() {
        players = new ArrayList<>();
        scanIn = new Scanner(System.in);
        Deck_of_many_things = new ArrayList<>();
        settings();
    }

    private Player currPlayer;

    public Player getCurrPlayer(Player player) {
        return currPlayer;
    }

    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }

    public void settings() {

        int player_count;
        System.out.print("BANG\nI geet you citizen!\nPlease enter your player count from 2 - 4 :");
        player_count = scanIn.nextInt();
        System.out.println("You entered " + player_count + "!");

        while (player_count < 2 || player_count > 4) {
            System.out.println("thats not between 2-4");
            System.out.print("Please enter your player count from 2 - 4 :");
            player_count = scanIn.nextInt();
            System.out.println("You entered " + player_count + "!");
        }
        System.out.println("Thank you");

        ///////////////////////////////////////////////////////////////////////////////////////////////

        Player Player1 = new Player(4);
        Player1.setName("Player1");
        setCurrPlayer(Player1);
        players.add(Player1);

        Player Player2 = new Player(4);
        Player2.setName("Player2");
        players.add(Player2);
        if (player_count > 2) {
            Player Player3 = new Player(4);
            Player3.setName("Player3");
            players.add(Player3);
        }
        if (player_count == 4) {
            Player Player4 = new Player(4);
            Player4.setName("Player4");
            players.add(Player4);
        }
        System.out.println("You have these player names:");
        for (int i = 0; i != players.size(); i++) {
            System.out.println(i + " " + players.get(i).getName()); // Get player names
        }
        /////BLUE CARDS/////BLUE CARDS////BLUE CARDS////BLUE CARDS///////////

        Deck_of_many_things.add(new Barrel());
        Deck_of_many_things.add(new Barrel());
        Deck_of_many_things.add(new Dynamite());
        for (int i = 0; i != 3; i++) {
            Deck_of_many_things.add(new Prison());
        }
        /////BROWN CARDS////
        for (int i = 0; i != 30; i++) {
            Deck_of_many_things.add(new Prison());
        }
        for (int i = 0; i != 15; i++) {
            Deck_of_many_things.add(new Missed());//////////////////////////
        }
        for (int i = 0; i != 8; i++) {
            Deck_of_many_things.add(new Beer());
        }
        for (int i = 0; i != 6; i++) {
            Deck_of_many_things.add(new Cat_Balou());
        }
        for (int i = 0; i != 4; i++) {
            Deck_of_many_things.add(new Stagecoach());
        }
        for (int i = 0; i != 2; i++) {
            Deck_of_many_things.add(new Indians());
        }
        Collections.shuffle(Deck_of_many_things);
        //for(int i=0;i!=Deck_of_many_things.size();i++)// Deckbuilding fuckup control
        //System.out.println(i+" - "+ Deck_of_many_things.get(i).getName();

        ///////////////////////////////

        for (int k = players.size() - 1; k != -1; k--) {
            for (int i = 0; i != 4; i++) {
                players.get(k).Hand.add(Deck_of_many_things.get(0));
                Deck_of_many_things.remove(0);
            }
        }
        //for(int k=0;k!=players.size();k++) {
        //for (int i = 0; i != players.get(k).Hand.size(); i++)// Deckbuilding fuckup control

        //System.out.println((i+1) + " player" + (k + 1) + " cards- " + players.get(k).Hand.get(i).getName());

        //}
        Game_loop();
    }

    public void Game_loop() {
        int answer;

        for (int turns = 1; true; turns++) {
            for (int i = 0; i != players.size(); i++) {
                boolean escaped=true;

                currPlayer = players.get(i);
                // STATUS CHECK
                for (int v = 0; v < currPlayer.getFront().size(); v++) {
                    if ((currPlayer.getFront().get(v) instanceof Prison)) {
                        escaped = ((Prison) currPlayer.getFront().get(v)).activation(players, i, Deck_of_many_things);
                        }}

                if (currPlayer.isAlive() && escaped) {






                    // 2 CARD DRAWING
                    for (int card = 0; card != 2; card++) {
                        currPlayer.Hand.add(Deck_of_many_things.get(0));
                        Deck_of_many_things.remove(0);
                    }

                    currPlayer.printOverlay(players,turns);
                    System.out.print("Enter the number of the card u want to play or enter 0 if u dont want to play a card\nAnswer:");
                    answer = scanIn.nextInt();
                    //////////Answer control
                    while (answer < 0 || answer > currPlayer.Hand.size()) {
                        System.out.println("No bad player!\nEnter the number of the card u want to play or enter 0 if u dont want to play a card\nAnswer:");
                        answer = scanIn.nextInt();
                    }
                    //////////Card execusion
                    while (answer > 0 && answer <= currPlayer.Hand.size()) {
                        currPlayer.Hand.get(answer - 1).play(players, i, Deck_of_many_things);
                        currPlayer.AmILastAlive(players, i);
                        i = players.indexOf(currPlayer);

                        // Deckbuilding fuckup control

                        currPlayer.printOverlay(players,turns);
                        System.out.print("Enter the number of the card u want to play or enter 0 if u dont want to play a card\nAnswer:");
                        answer = scanIn.nextInt();

                    }
                    // Too many cards

                while (currPlayer.Hand.size() > currPlayer.getLives()) {

                    currPlayer.printOverlay(players,turns);
                    System.out.println("you have too many cards select one to discard");
                    System.out.print("card:");
                    answer = scanIn.nextInt();
                    while (answer <= 0 || answer > players.get(i).Hand.size()) {
                        for (int w = 0; w != 25; w++) {
                            System.out.println();
                        }
                        currPlayer.printOverlay(players,turns);
                        System.out.println("No bad player!\nEnter the number of the card u want to Discard\nAnswer:");
                        answer = scanIn.nextInt();
                    }
                    Deck_of_many_things.add(players.get(i).Hand.get(answer - 1));
                    players.get(i).Hand.remove(answer - 1);


                }}

                //currPlayer.AmILastAlive(players, i);
            }

        }


    }

}

