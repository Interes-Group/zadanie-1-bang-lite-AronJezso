package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Deck;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Bang extends Card {

    public Bang() {
        super(ANSI_RED + "Bang" + ANSI_RESET);
    }

    @Override
    public void play(ArrayList<Player> players, int player, Deck deck) {
        for (int v = 0; v < players.get(player).getHand().size(); v++) {
            if ((players.get(player).getHand().get(v) instanceof Bang)) {
                deck.addBin(players.get(player).getHand().get(v));
                players.get(player).getHand().remove(v);
                break;
            }
        }
        System.out.println("Choose a player to shoot :");
        for (int i = 0; i != players.size(); i++) {
            if (players.get(i).isAlive() && player != i) {
                System.out.println(i + 1 + " " + players.get(i).getName()); // Get player names
            }

        }
        int answer = player + 1;
        while (answer == player + 1 || answer > players.size() || answer <= 0 || !players.get(answer - 1).isAlive()) {
            answer = ZKlavesnice.readInt("Answer:");
            if (player == answer - 1) {
                System.out.print("\nYou cant shoot yourself(Lets not be that kinky)\nTry again:");
            }
            if (answer > players.size() || answer <= 0) {
                System.out.print("\nOut of range\nTry again:");
            } else if (!players.get(answer - 1).isAlive()) {
                System.out.print("\nDAT PLAYER DED\nTry again:");
            }
        }

        for (int v = 0; v != players.get(answer - 1).getHand().size(); v++) {
            if ((players.get(answer - 1).getHand().get(v) instanceof Missed)) {
                deck.addBin(players.get(answer - 1).getHand().get(v));
                players.get(answer - 1).getHand().remove(v);
                System.out.println("\nMissed! " + players.get(answer - 1).getName() + " Has " + players.get(answer - 1).getLives() + "lives.");
                return;
            }
        }
        for (int v = 0; v != players.get(answer - 1).getFront().size(); v++) {
            if ((players.get(answer - 1).getFront().get(v) instanceof Barrel)) {
                if (1 == (int) Math.floor(Math.random() * (4 - 1 + 1) + 1)) {
                    System.out.println("\nDoing! U hit a Barrel. " + players.get(answer - 1).getName() + " Has " + players.get(answer - 1).getLives() + "lives.");
                    return;
                }
            }
        }
        players.get(answer - 1).setLives(players.get(answer - 1).getLives() - 1);
        System.out.println("\nBang! " + players.get(answer - 1).getName() + " Has " + players.get(answer - 1).getLives() + "lives.");
        if (!players.get(answer - 1).isAlive()) {
            System.out.println("\n" + players.get(answer - 1).getName() + "has been killed, what a dumbass...");
            players.get(answer - 1).getHand().addAll(deck.getBin());
            players.get(answer - 1).setAlive(false);

        }
    }
}
