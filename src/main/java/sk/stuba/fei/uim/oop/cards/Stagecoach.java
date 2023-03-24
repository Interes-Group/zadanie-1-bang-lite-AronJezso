package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;

public class Stagecoach extends Card{
    public Stagecoach() {
        super(ANSI_YELLOW+"Stagecoach"+ANSI_RESET);
    }

    @Override
    public void play(ArrayList<Player> players,int player,ArrayList<Card> deck){
        Player currPlayer = players.get(player);
        if(deck.size()>=2){
            for (int card = 0; card < 2; card++) {
                currPlayer.getHand().add(deck.get(0));
                deck.remove(0);
            }
            for (int v = 0; v != players.get(player).getHand().size(); v++) {
                if ((players.get(player).getHand().get(v) instanceof Stagecoach)) {
                    deck.add(players.get(player).getHand().get(v));
                    players.get(player).getHand().remove(v);
                    break;
                }}
        }
        else {
            System.out.println("You cant play this card now \n Not enough cards in deck");
        }
    }
}
