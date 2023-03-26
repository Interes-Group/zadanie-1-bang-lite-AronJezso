package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.cards.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Game {
    private final ArrayList<Player> players;
    private final Deck Deck;
    private Player currPlayer;

    public Game() {
        players = new ArrayList<>();
        Deck = new Deck();
        settings();
    }


    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }

    public void settings() {

        int player_count;
        player_count = ZKlavesnice.readInt("BANG\nI gret you citizen!\nPlease enter your player count from 2 - 4 :");
        System.out.println("You entered " + player_count + "!");

        while (player_count < 2 || player_count > 4) {
            System.out.println("that s not between 2-4");
            player_count = ZKlavesnice.readInt("Please enter your player count from 2 - 4 :");
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

        Deck.addDeck(new Barrel());
        Deck.addDeck(new Barrel());
        Deck.addDeck(new Dynamite());
        for (int i = 0; i != 3; i++) {
            Deck.addDeck(new Prison());
        }
        /////BROWN CARDS////
        for (int i = 0; i != 30; i++) {//30
            Deck.addDeck(new Bang());
        }
        for (int i = 0; i != 15; i++) {//15
            Deck.addDeck(new Missed());
        }
        for (int i = 0; i != 8; i++) {//8
            Deck.addDeck(new Beer());
        }
        for (int i = 0; i != 6; i++) {//6
            Deck.addDeck(new CatBalou());
        }
        for (int i = 0; i != 4; i++) {//4
            Deck.addDeck(new Stagecoach());
        }
        for (int i = 0; i != 2; i++) {
            Deck.addDeck(new Indians());
        }
        Deck.Shuffle();

        ///////////////////////////////

        for (int k = players.size() - 1; k != -1; k--) {
            for (int i = 0; i != 4; i++) {
                players.get(k).getHand().add(Deck.getDeck().get(0));
                Deck.getDeck().remove(0);
            }
        }
        Game_loop();
    }

    public void Game_loop() {
        int answer;

        for (int turns = 1; true; turns++) {
            for (int i = 0; i != players.size(); i++) {
                boolean escaped = true;

                currPlayer = players.get(i);
                // STATUS CHECK
                for (int v = 0; v < currPlayer.getFront().size(); v++) {
                    if (currPlayer.getFront().get(v) instanceof Dynamite) {
                        ((Dynamite) currPlayer.getFront().get(v)).activation(players, i, Deck.getBin());
                    }
                }
                for (int v = 0; v < currPlayer.getFront().size(); v++) {
                    if (currPlayer.getFront().get(v) instanceof Prison) {
                        escaped = ((Prison) currPlayer.getFront().get(v)).activation(players, i, Deck.getBin());
                    }
                }
                if (currPlayer.isAlive() && escaped) {
                    //GIMME SPACE
                    for (int w = 0; w != 4; w++) {
                        System.out.println();
                    }


                    // 2 CARD DRAWING
                    if (Deck.getDeck().size() < 2) {
                        Deck.Shuffle();
                    }
                    if (Deck.getDeck().size() >= 2) {
                        for (int card = 0; card != 2; card++) {
                            currPlayer.getHand().add(Deck.getDeck().get(0));
                            Deck.getDeck().remove(0);
                        }
                    } else {
                        System.out.println("\nNot enough cards in Deck");
                    }

                    currPlayer.printOverlay(players, turns);
                    answer = ZKlavesnice.readInt("Enter the number of the card u want to play or enter 0 if u dont want to play a card\nAnswer:");
                    //////////Answer control
                    while (answer < 0 || answer > currPlayer.getHand().size()) {
                        answer = ZKlavesnice.readInt("No bad player!\nEnter the number of the card u want to play or enter 0 if u dont want to play a card\nAnswer:");
                    }
                    //////////Card execution
                    while (answer > 0 && answer <= currPlayer.getHand().size()) {
                        currPlayer.getHand().get(answer - 1).play(players, i, Deck);
                        currPlayer.AmILastAlive(players, i);
                        i = players.indexOf(currPlayer);


                        currPlayer.printOverlay(players, turns);
                        answer = ZKlavesnice.readInt("Enter the number of the card u want to play or enter 0 if u dont want to play a card\nAnswer:");
                    }
                    // Too many cards
                    while (currPlayer.getHand().size() > currPlayer.getLives()) {

                        currPlayer.printOverlay(players, turns);
                        answer = ZKlavesnice.readInt("you have too many cards select one to discard\ncard:");
                        while (answer <= 0 || answer > players.get(i).getHand().size()) {
                            for (int w = 0; w != 25; w++) {
                                System.out.println();
                            }
                            currPlayer.printOverlay(players, turns);
                            answer = ZKlavesnice.readInt("No bad player!\nEnter the number of the card u want to Discard\nAnswer:");
                        }
                        Deck.getBin().add(players.get(i).getHand().get(answer - 1));
                        players.get(i).getHand().remove(answer - 1);


                    }

                }

                //currPlayer.AmILastAlive(players, i);
            }

        }


    }

}

