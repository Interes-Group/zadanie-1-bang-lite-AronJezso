package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;


public class Indians extends Card{
    public Indians() {
        super(ANSI_PURPLE+"Indians"+ANSI_RESET);
    }

    @Override
    public void play(ArrayList<Player> players,int player,ArrayList<Card> deck){
        for (int v = 0; v != players.get(player).getHand().size(); v++) {
            if ((players.get(player).getHand().get(v) instanceof Indians)) {
                deck.add(players.get(player).getHand().get(v));
                players.get(player).getHand().remove(v);
                break;
            }}
        for(int currPlayer = 0;currPlayer<players.size();currPlayer++){
            if(currPlayer!=player){
                int check=0;
                for(int v=0;v<players.get(currPlayer).getHand().size();v++){
                    if((players.get(currPlayer).getHand().get(v) instanceof Bang)){
                        deck.add(players.get(currPlayer).getHand().get(v));
                        players.get(currPlayer).getHand().remove(players.get(currPlayer).getHand().get(v));
                        System.out.println("\nBang! " + players.get(currPlayer).getName() + " Defeated the Indians, He has " + players.get(currPlayer).getLives() + " lives.");
                        check++;
                        break;
                    }

                }
                if(check == 0 && players.get(currPlayer).isAlive()){

                    players.get(currPlayer).setLives(players.get(currPlayer).getLives()-1);
                    System.out.println("\nOWAOWA " + players.get(currPlayer).getName() + " Got hit by the indians, He has " + players.get(currPlayer).getLives() + " lives.");

                }


            }
            if(!players.get(currPlayer).isAlive()){
                System.out.println("\n"+players.get(currPlayer).getName() + "has been killed, what a dumbass...");
                players.get(currPlayer).setLives(-1);

                deck.addAll(players.get(currPlayer).getHand());
                players.get(currPlayer).getHand().removeAll(deck);
                players.get(currPlayer).setAlive(false);
            }
        }
    }
}
