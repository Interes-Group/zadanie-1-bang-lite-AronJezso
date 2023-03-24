package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Cat_Balou extends Card{
    public Cat_Balou() {
        super(ANSI_CYAN+"Cat Balou"+ANSI_RESET);
    }

    @Override
    public void play(ArrayList<Player> players,int player,ArrayList<Card> deck){

        System.out.println("Choose a player :");
        for (int i = 0; i != players.size(); i++) {
            if (players.get(i).isAlive()){
                if(players.get(i)!=players.get(player))
                System.out.println(i + 1 + " " + players.get(i).getName()); // Get player names
            }


        }
        Scanner scanIn = new Scanner(System.in);
        int answer;
        do{
            answer = scanIn.nextInt();
            if (answer > players.size() || answer <= 0 || answer == player+1) {
                System.out.print("\nOut of range\nTry again:");
            }
        }while(answer == player+1 || answer > players.size() || answer <= 0);

        int chosenWay;
        do{
            System.out.println("Do you Want to throw away a card from his FRONT or HAND?\n1=FRONT\n2=HAND");
            chosenWay = scanIn.nextInt();
        }while(chosenWay != 1 && chosenWay != 2);

        if(chosenWay==1){
            if(players.get(answer-1).getFront().size()==0){
                System.out.println("You cannot play this card on this players Front");
                return;
            }
            else{
                int rand = (int) Math.floor(Math.random() * (players.get(answer-1).getFront().size()-1) + 0);
                deck.add(players.get(answer-1).getFront().get(rand));
                players.get(answer-1).getFront().remove(rand);
                for (int v = 0; v < players.get(player).getHand().size(); v++) {
                    if ((players.get(player).getHand().get(v) instanceof Cat_Balou)) {
                        deck.add(players.get(player).getHand().get(v));
                        players.get(player).getHand().remove(v);
                        return;
                    }}
            }
        }
        else{
            if(players.get(answer-1).getHand().size()==0){
                System.out.println("You cannot play this card on this players Hand");
                return;
            }
            else{
                int rand = (int) Math.floor(Math.random() * (players.get(answer-1).getFront().size()-1) + 0);
                deck.add(players.get(answer-1).getFront().get(rand));
                players.get(answer-1).getHand().remove(rand);
                for (int v = 0; v < players.get(player).getHand().size(); v++) {
                    if ((players.get(player).getHand().get(v) instanceof Cat_Balou)) {
                        deck.add(players.get(player).getHand().get(v));
                        players.get(player).getHand().remove(v);
                        return;
                    }}
            }

        }



        }
}
