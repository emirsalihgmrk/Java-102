package advanture_game;

import java.util.Scanner;

public class Game {
        public static Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome to game");
        System.out.println("Your aim is collect the awards in the battle locations\nThese awards are : Food,Firewood and water");
        System.out.print("Enter your name : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Hi " + playerName + ", please enter ID of the character you want to use");
        player.selectChar();
        Location location = null;
        while (true){
            System.out.println();
            player.printPlayerInfo();
            System.out.println();
            System.out.println("############# Locations #############");
            System.out.println("Please enter ID of the Location you want to go");
            System.out.println("-------------------------------------------------------");
            System.out.println("ID : 1" + "\tSafe House");
            System.out.println("ID : 2" + "\tTool Store");
            System.out.println("ID : 3" + "\tCave");
            System.out.println("ID : 4" + "\tForest");
            System.out.println("ID : 5" + "\tRiver");
            System.out.println("ID : 6" + "\tMine");
            System.out.println("-------------------------------------------------------");
            System.out.print("Location ID : ");
            int selectLocation = input.nextInt();
            switch (selectLocation) {
                case 1 -> location = new SafeHouse(player);
                case 2 -> location = new ToolStore(player);
                case 3 -> location = new Cave(player);
                case 4 -> location = new Forest(player);
                case 5 -> location = new River(player);
                case 6 -> location = new Mine(player);
                default -> System.out.println("You entered an invalid Location");
            }
            assert location != null;
            if(!location.onLocation()){
                if (selectLocation == 1){
                    System.out.println("You got the all awards,You won!");
                    System.out.println(
                            "//////////////////////" +
                           "// CONGRATULATIONS! //" +
                          "//////////////////////");
                    break;
                }
                System.out.println(
                        "////////////////" +
                       "// GAME OVER! //" +
                      "////////////////");
                break;
            }
        }
    }
}
