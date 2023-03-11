package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import sk.stuba.fei.uim.oop.cards.*;
public class Game {

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
        ArrayList<Player> players = new ArrayList<Player>();
        Player Player1 = new Player();
        Player1.setName("Player1");
        players.add(Player1);

        Player Player2 = new Player();
        Player2.setName("Player2");
        players.add(Player2);

        Player Player3 = new Player();
        Player3.setName("Player3");
        players.add(Player3);

        Player Player4 = new Player();
        Player4.setName("Player4");
        players.add(Player4);
        System.out.println("You have these player names:");
        for(int i=0;i!=player_count;i++)
        System.out.println(i + " " + players.get(i).name); // Get player names

        /////BLUE CARDS/////BLUE CARDS////BLUE CARDS////BLUE CARDS///////////
        ArrayList<Object> Deck_of_many_things = new ArrayList<>();
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
            //System.out.println(i+" - "+ Deck_of_many_things.get(i).getClass());

    ///////////////////////////////
        for(int k=player_count-1;k!=-1;k--) {
            for (int i = 0; i != 4; i++) {
                players.get(k).Hand.add(Deck_of_many_things.get(0));
                Deck_of_many_things.remove(0);
            }
            for (int i = 0; i != players.get(k).Hand.size(); i++)// Deckbuilding fuckup control
                System.out.println(i + " player"+(k+1)+" cards- " + players.get(k).Hand.get(i));

        };

    }}

