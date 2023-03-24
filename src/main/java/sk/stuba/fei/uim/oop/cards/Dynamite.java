package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;

public class Dynamite extends Card {
    public Dynamite() {
        super("Dynamite");
    }

    @Override
    public void play(ArrayList<Player> players, int player, ArrayList<Card> deck) {
        for (int v = 0; v < players.get(player).getFront().size(); v++) {
            if (players.get(player).getFront().get(v) instanceof Dynamite) {
                System.out.println("You already have a " + ANSI_RED + "Dynamite" + ANSI_RESET + " in front of you!");
                return;

            }

        }
        players.get(player).addFront(new Dynamite());
        System.out.println("A " + ANSI_RED + "Dynamite" + ANSI_RESET + " has been placed in front of you Cheef!");
        for (int v = 0; v < players.get(player).getHand().size(); v++) {
            if (players.get(player).getHand().get(v) instanceof Dynamite) {
                players.get(player).getHand().remove(v);
                break;
            }
        }
    }

    public boolean activation(ArrayList<Player> players, int player, ArrayList<Card> deck) {
        Player currPlayer = players.get(player);
        if (1 == (int) Math.floor(Math.random() * (8 - 1 + 1) + 1)) {
            System.out.println(ANSI_RED + "[BOOM] Dynamite " + ANSI_RESET + "exploded!");
            currPlayer.setLives(currPlayer.getLives() - 3);
            for (int v = 0; v < players.get(player).getFront().size(); v++) {
                if (players.get(player).getFront().get(v) instanceof Dynamite) {
                    players.get(player).getFront().remove(v);
                    break;
                }
            }
            if (!currPlayer.isAlive()) {
                System.out.println("\n" + currPlayer.getName() + "has been killed, what a dumbass...");
                currPlayer.getHand().addAll(deck);
            }
            return true;
        } else {
            int next = player - 1;
            while (true) {
                if (next < 0) {
                    next = players.size() - 1;
                }
                if (!players.get(next).isAlive()) {
                    next--;
                } else {
                    break;
                }
            }
            System.out.println(ANSI_RED + "Dynamite " + ANSI_RESET + "is given to " + players.get(next).getName());
            for (int v = 0; v < currPlayer.getFront().size(); v++) {
                if (currPlayer.getFront().get(v) instanceof Dynamite) {
                    currPlayer.getFront().remove(v);
                }
            }
            players.get(next).getFront().add(new Dynamite());
            return false;
        }
    }
}
