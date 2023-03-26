package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Deck;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class CatBalou extends Card {
    public CatBalou() {
        super(ANSI_CYAN + "Cat Balou" + ANSI_RESET);
    }

    @Override
    public void play(ArrayList<Player> players, int player, Deck deck) {

        System.out.println("Choose a player :");
        for (int i = 0; i != players.size(); i++) {
            if (players.get(i).isAlive() && players.get(i) != players.get(player)) {
                System.out.println(i + 1 + " " + players.get(i).getName()); // Get player names
            }


        }
        int answer;
        do {
            answer = ZKlavesnice.readInt("Answer: ");
            if (answer > players.size() || answer <= 0 || answer == player + 1 || !players.get(answer - 1).isAlive()) {
                System.out.print("\nOut of range\nTry again:");
            }
        } while (answer == player + 1 || answer > players.size() || answer <= 0 || !players.get(answer - 1).isAlive());

        int chosenWay;
        do {
            chosenWay = ZKlavesnice.readInt("Do you Want to throw away a card from his FRONT or HAND?\n1=FRONT\n2=HAND");
        } while (chosenWay != 1 && chosenWay != 2);

        if (chosenWay == 1) {
            if (players.get(answer - 1).getFront().size() == 0) {
                System.out.println("You cannot play this card on this players Front");
            } else {
                int rand = (int) Math.floor(Math.random() * (players.get(answer - 1).getFront().size()) + 1) - 1;
                deck.addBin(players.get(answer - 1).getFront().get(rand));
                players.get(answer - 1).getFront().remove(rand);
                //remove card
                for (int v = 0; v < players.get(player).getHand().size(); v++) {
                    if ((players.get(player).getHand().get(v) instanceof CatBalou)) {
                        deck.addBin(players.get(player).getHand().get(v));
                        players.get(player).getHand().remove(v);
                        return;
                    }
                }
            }
        } else {
            if (players.get(answer - 1).getHand().size() == 0) {
                System.out.println("You cannot play this card on this players Hand");
            } else {
                int rand = (int) Math.floor(Math.random() * (players.get(answer - 1).getFront().size()) + 1) - 1;
                deck.addBin(players.get(answer - 1).getHand().get(rand));
                players.get(answer - 1).getHand().remove(rand);
                for (int v = 0; v < players.get(player).getHand().size(); v++) {
                    if ((players.get(player).getHand().get(v) instanceof CatBalou)) {
                        deck.addBin(players.get(player).getHand().get(v));
                        players.get(player).getHand().remove(v);
                        return;
                    }
                }
            }

        }


    }
}
