package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Deck;
import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;

public class Stagecoach extends Card {
    public Stagecoach() {
        super(ANSI_YELLOW + "Stagecoach" + ANSI_RESET);
    }

    @Override
    public void play(ArrayList<Player> players, int player, Deck deck) {
        Player currPlayer = players.get(player);
        if (deck.getDeck().size() < 2) {
            deck.Shuffle();
            if (deck.getDeck().size() < 2) {
                System.out.println("You cant play this card now \n Not enough cards in deck");
                return;
            }
        }

        for (int card = 0; card < 2; card++) {
            currPlayer.getHand().add(deck.getDeck().get(0));
            deck.getDeck().remove(0);
        }
        for (int v = 0; v != players.get(player).getHand().size(); v++) {
            if ((players.get(player).getHand().get(v) instanceof Stagecoach)) {
                deck.addBin(players.get(player).getHand().get(v));
                players.get(player).getHand().remove(v);
                break;
            }
        }


    }
}
