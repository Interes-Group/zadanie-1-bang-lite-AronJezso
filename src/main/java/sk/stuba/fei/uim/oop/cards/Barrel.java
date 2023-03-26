package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Deck;
import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;

public class Barrel extends BlueCard {

    public Barrel() {
        super(ANSI_GREEN + "Barrel" + ANSI_RESET);
    }

    @Override
    public void play(ArrayList<Player> players, int player, Deck deck) {
        for (int v = 0; v < players.get(player).getFront().size(); v++) {
            if ((players.get(player).getFront().get(v) instanceof Barrel)) {
                System.out.println("You already have a Barrel in front of you!");
                return;

            }

        }
        players.get(player).addFront(new Barrel());
        System.out.println("A Barrel has been placed in front of you Cheef!");
        for (int v = 0; v < players.get(player).getHand().size(); v++) {
            if ((players.get(player).getHand().get(v) instanceof Barrel)) {
                deck.addBin(players.get(player).getHand().get(v));
                players.get(player).getHand().remove(v);
                break;
            }
        }
    }

    @Override
    public boolean activation(ArrayList<Player> players, int player, ArrayList<Card> deck) {

        return false;
    }

}
