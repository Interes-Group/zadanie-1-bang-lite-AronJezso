package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
        System.out.println(players.get(i).name); // Get player names
        ///////////////////////////////////////////////////////////////////////////////////////////////////



}}

