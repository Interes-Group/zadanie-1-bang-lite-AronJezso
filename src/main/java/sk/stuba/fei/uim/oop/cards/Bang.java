package sk.stuba.fei.uim.oop.cards;
import sk.stuba.fei.uim.oop.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Bang extends Card {

    public Bang() {
        super("Bang");
    }
    @Override
    public void play(ArrayList<Player> players,int player,ArrayList<Card> deck){
        System.out.println("Choose a player to shoot :");
        for(int i=0;i!=players.size();i++) {

            System.out.println(i+1 + " " + players.get(i).getName()); // Get player names
        }
        Scanner scanIn = new Scanner(System.in);
        int answer = player+1;
        while(answer==player+1){
        answer = scanIn.nextInt();
        if(player == answer-1){
            System.out.print("\nYou cant shoot yourself(Lets not be that kinky)\nTry again:");
        }}
        for(int v=0;v!=players.get(answer-1).getHand().size();v++){
            if((players.get(answer-1).getHand().get(v) instanceof Missed)==true){
                deck.add(players.get(answer-1).getHand().get(v));
                players.get(answer-1).getHand().remove(v);
                System.out.println("\nMissed! " + players.get(answer-1).getName() + " Has " + players.get(answer-1).getLives() + "lives.");
                break;
            }
        }
        players.get(answer-1).setLives(players.get(answer-1).getLives()-1);
        System.out.println("\nBang! " + players.get(answer-1).getName() + " Has " + players.get(answer-1).getLives() + "lives.");
        if(players.get(answer-1).getLives()<=0){
            System.out.println("\n"+players.get(answer-1).getName() + "has been killed, what a dumbass...");
            players.get(answer-1).getHand().addAll(deck);
            players.remove(answer-1);

        }
    }
}
