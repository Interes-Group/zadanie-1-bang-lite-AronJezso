package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import sk.stuba.fei.uim.oop.cards.*;
public class Game {
    public Game() {
        settings();
    }


    public void settings() {
        Scanner scanIn = new Scanner(System.in);
        int player_count;
        System.out.print("BANG\nI geet you citizen!\nPlease enter your player count from 2 - 4 :");
        player_count = scanIn.nextInt();
        System.out.println("You entered " +player_count + "!");

        while(player_count<2 || player_count > 4) {
            System.out.println("thats not between 2-4");
            System.out.print("Please enter your player count from 2 - 4 :");
            player_count = scanIn.nextInt();
            System.out.println("You entered " +player_count + "!");
        }
        System.out.println("Thank you");

        ///////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Player> players = new ArrayList<>();
        Player Player1 = new Player(4);
        Player1.setName("Player1");
        players.add(Player1);

        Player Player2 = new Player(4);
        Player2.setName("Player2");
        players.add(Player2);
        if(player_count>2) {
            Player Player3 = new Player(4);
            Player3.setName("Player3");
            players.add(Player3);
        }
        if(player_count==4) {
            Player Player4 = new Player(4);
            Player4.setName("Player4");
            players.add(Player4);
        }
        System.out.println("You have these player names:");
        for(int i=0;i!=players.size();i++) {
            System.out.println(i + " " + players.get(i).getName()); // Get player names
        }
        /////BLUE CARDS/////BLUE CARDS////BLUE CARDS////BLUE CARDS///////////
        ArrayList<Card> Deck_of_many_things = new ArrayList<>();
        Deck_of_many_things.add(new Barrel());
        Deck_of_many_things.add(new Barrel());
        Deck_of_many_things.add(new Dynamite());
        for(int i=0;i!=3;i++) {
            Deck_of_many_things.add(new Prison());
        }
        /////BROWN CARDS////
        for(int i=0;i!=30;i++) {
            Deck_of_many_things.add(new Bang());
        }
        for(int i=0;i!=15;i++) {
            Deck_of_many_things.add(new Missed());
        }
        for(int i=0;i!=8;i++) {
            Deck_of_many_things.add(new Beer());
        }
        for(int i=0;i!=6;i++) {
            Deck_of_many_things.add(new Cat_Balou());
        }
        for(int i=0;i!=4;i++) {
            Deck_of_many_things.add(new Stagecoach());
        }
        for(int i=0;i!=2;i++) {
            Deck_of_many_things.add(new Indians());
        }
        Collections.shuffle(Deck_of_many_things);
        //for(int i=0;i!=Deck_of_many_things.size();i++)// Deckbuilding fuckup control
            //System.out.println(i+" - "+ Deck_of_many_things.get(i).getName();

    ///////////////////////////////

        for(int k=players.size()-1;k!=-1;k--) {
            for (int i = 0; i != 4; i++) {
                players.get(k).Hand.add(Deck_of_many_things.get(0));
                Deck_of_many_things.remove(0);
            }}
        //for(int k=0;k!=players.size();k++) {
            //for (int i = 0; i != players.get(k).Hand.size(); i++)// Deckbuilding fuckup control

                //System.out.println((i+1) + " player" + (k + 1) + " cards- " + players.get(k).Hand.get(i).getName());

        //}
       int answer;
       for(int turns=1;true;turns++)
       {
           for(int i=0;i!=players.size();i++) {
               System.out.println(players.get(i).getName());
               System.out.println("turn = " + turns);
                // 2 CARD DRAWING
               for (int card = 0; card != 2; card++) {
                   players.get(i).Hand.add(Deck_of_many_things.get(0));
                   Deck_of_many_things.remove(0);
               }
               System.out.println(players.get(i).getName() + " -- lives: " + players.get(i).getLives());
               // card play
               for (int card = 0; card != players.get(i).Hand.size(); card++) {// Deckbuilding fuckup control

                   System.out.println((card + 1) +  " card- " + players.get(i).Hand.get(card).getName());
               }
               System.out.print("Enter the number of the card u want to play or enter 0 if u dont want to play a card\nAnswer:");
               answer = scanIn.nextInt();
               while(answer > 0 && answer <= players.get(i).Hand.size()){
                   players.get(i).Hand.get(answer-1).play(players,i,Deck_of_many_things);
                   Deck_of_many_things.add(players.get(i).Hand.get(answer-1));
                   players.get(i).Hand.remove(answer-1);
                   // Deckbuilding fuckup control
                   for (int card = 0; card != players.get(i).Hand.size(); card++) {
                       System.out.println((card + 1) + " card- " + players.get(i).Hand.get(card).getName());
                   }
                   System.out.print("Enter the number of the card u want to play or enter 0 if u dont want to play a card\nAnswer:");
                   answer = scanIn.nextInt();
               }
               // Too many cards
               while(players.get(i).Hand.size()>players.get(i).getLives()){
                   System.out.println("you have too many cards select one to discard");
                   for (int card = 0; card != players.get(i).Hand.size(); card++) {// Deckbuilding fuckup control

                       System.out.println((card + 1) +  " card- " + players.get(i).Hand.get(card).getName());
                   }
                   System.out.print("card:");
                   answer = scanIn.nextInt();
                   Deck_of_many_things.add(players.get(i).Hand.get(answer-1));
                   players.get(i).Hand.remove(answer-1);


               }
           }
        if(players.size()==1){

            break;
        }
       }
       System.out.println("CONGRATS " + players.get(0).getName() + "WON");
    }



}

