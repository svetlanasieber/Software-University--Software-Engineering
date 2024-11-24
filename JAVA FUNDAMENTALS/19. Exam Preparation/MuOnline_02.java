package MidExamPrep1;

import java.util.Scanner;

public class MuOnline_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rooms = scanner.nextLine().split("\\|");

        int health = 100;
        int bitcoins = 0;

        for (int i = 0; i < rooms.length; i++) {
       
            String [] currentRoom = rooms[i].split(" ");

            String commandOrMonster = currentRoom[0];
  
            int points = Integer.parseInt(currentRoom[1]);

            switch (commandOrMonster){

                case "potion" ->{
               
                    if(points + health > 100){
           
                        points = 100 - health;
                    }
             
                    health += points;

                    System.out.printf("You healed for %d hp.%n", points);
                    System.out.printf("Current health: %d hp.%n", health);
                }

                case "chest" -> {
                    bitcoins += points;
                    System.out.printf("You found %d bitcoins.%n", points);
                }

                default -> {
             
                    health -= points;

                    if(health > 0){
                        System.out.printf("You slayed %s.%n", commandOrMonster);
                    }else {
               
                        System.out.printf("You died! Killed by %s.%n", commandOrMonster);
                        System.out.printf("Best room: %d", i + 1);
                    }

                }

            }


            if(health <= 0){
                break;
            }

        }


        if(health > 0){
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", health);
        }

    }
}
