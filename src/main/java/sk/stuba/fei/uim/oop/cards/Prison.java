package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Deck;
import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Prison extends BlueCard {
    public Prison() {
        super(ANSI_BLUE + "Prison" + ANSI_RESET);
    }

    @Override
    public void play(ArrayList<Player> players, int player, Deck deck) {
        System.out.println("Choose a player :");
        for (int i = 0; i != players.size(); i++) {
            if (players.get(i).isAlive()) {
                if (players.get(i) != players.get(player) && players.get(i).isAlive())
                    System.out.println(i + 1 + " " + players.get(i).getName()); // Get player names
            }
        }

        Scanner scanIn = new Scanner(System.in);
        int answer;
        do {
            answer = scanIn.nextInt();
            if (answer > players.size() || answer <= 0 || answer == player + 1) {
                System.out.print("\nOut of range\nTry again:");
            }
        } while (answer == player + 1 || answer > players.size() || answer <= 0);


        for (int v = 0; v < players.get(answer - 1).getFront().size(); v++) {
            if ((players.get(answer - 1).getFront().get(v) instanceof Prison)) {
                System.out.println("That player is already in prison Cheef!");
                return;

            }

        }
        players.get(answer - 1).addFront(new Prison());
        System.out.println("Rot in Hell " + players.get(answer - 1).getName() + "!");


        for (int v = 0; v < players.get(player).getHand().size(); v++) {
            if ((players.get(player).getHand().get(v) instanceof Prison)) {
                deck.addBin(players.get(player).getHand().get(v));
                players.get(player).getHand().remove(v);
                return;
            }
        }


    }

    @Override
    public boolean activation(ArrayList<Player> players, int player, ArrayList<Card> deck) {
        Player currPlayer = players.get(player);
        if (1 == (int) Math.floor(Math.random() * (4 - 1 + 1) + 1)) {
            System.out.println(currPlayer.getName() + " escaped from " + ANSI_PURPLE + "Prison" + ANSI_RESET + "!");
            for (int v = 0; v < currPlayer.getFront().size(); v++) {
                if ((currPlayer.getFront().get(v) instanceof Prison)) {
                    deck.add(currPlayer.getFront().get(v));
                    currPlayer.getFront().remove(v);
                    return true;
                }
            }
        }
        System.out.println(currPlayer.getName() + " was unable to escape from " + ANSI_PURPLE + "Prison" + ANSI_RESET + "!");
        return false;


    }
}
