package FixtureCreation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Teams t = new Teams(new ArrayList<>());
        System.out.print("Please enter the number of teams : ");
        int teamsNum = inp.nextInt();
        for (int i = 0;i < teamsNum;i++){
            System.out.print("Team "+(i+1)+" : ");
            t.addTeam(inp.next());
        }
        t.createFixture();
        t.printFixture();
    }
}