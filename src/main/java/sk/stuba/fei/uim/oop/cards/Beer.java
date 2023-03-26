package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Deck;
import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;

public class Beer extends Card {

    public Beer() {
        super(ANSI_YELLOW + "Beer" + ANSI_RESET);
    }

    @Override
    public void play(ArrayList<Player> players, int player, Deck deck) {
        players.get(player).setLives(players.get(player).getLives() + 1);
        for (int v = 0; v < players.get(player).getHand().size(); v++) {
            if ((players.get(player).getHand().get(v) instanceof Beer)) {
                deck.addBin(players.get(player).getHand().get(v));
                players.get(player).getHand().remove(v);
                break;
            }
        }
    }
}
