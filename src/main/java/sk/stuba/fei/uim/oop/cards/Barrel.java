package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.*;

import java.util.ArrayList;

public class Barrel extends Card{

    public Barrel() {
        super("Barrel");
    }
    @Override
    public void play(ArrayList<Player> players,int player,ArrayList<Card> deck){
        for(int v=0;v!=players.get(player).getFront().size();v++){
            if((players.get(player).getFront().get(v) instanceof Barrel)==true){
                System.out.println("You already have a Barrel in front of you!");
                break;

            }

        }
        players.get(player).addFront(new Barrel());
        System.out.println("A Barrel has been placed in front of you Cheef!");
    }

}
