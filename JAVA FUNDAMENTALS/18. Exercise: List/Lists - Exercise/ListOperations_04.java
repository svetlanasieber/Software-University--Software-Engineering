package List_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split(" ");
            String commandName = commandParts[0];

            switch (commandName) {
                case "Add" -> {

                    int numberToAdd = Integer.parseInt(commandParts[1]); //"5" -> 5
                    numbers.add(numberToAdd);
                }

                case "Insert" -> {

                    int numberForInsertion = Integer.parseInt(commandParts[1]); 
                    int positionForInsertion = Integer.parseInt(commandParts[2]); /

                    if (positionForInsertion >=  0 && positionForInsertion <= numbers.size() - 1) {
                        
                        numbers.add(positionForInsertion, numberForInsertion);
                    } else {
                     
                        System.out.println("Invalid index");
                    }

                }

                case "Remove" -> {

                    int positionForRemove = Integer.parseInt(commandParts[1]); 

                    if (positionForRemove >= 0 && positionForRemove <= numbers.size() - 1) {

                        numbers.remove(positionForRemove);
                    } else {
                     
                        System.out.println("Invalid index");
                    }

                }

                case "Shift" -> {
                    String position = commandParts[1]; //"left", "right"
                    int count = Integer.parseInt(commandParts[2]);

                    if (position.equals("left")) {
                   
                        for (int i = 1; i <= count; i++) {
      
                            int firstNumber = numbers.get(0); //getFirst();
                         
                            numbers.remove(0);
                         
                            numbers.add(firstNumber);
                        }
                    } else if (position.equals("right")) {
                       
                        for (int i = 1; i <= count ; i++) {
                          
                            int lastNumber = numbers.get(numbers.size() - 1); //getLast();
                      
                            numbers.remove(numbers.size() - 1);
                         
                            numbers.add(0, lastNumber);
                        }

                    }
                }
            }
            command = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
