package Lists_Exercise;

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
                 
                    int numberToAdd = Integer.parseInt(commandParts[1]);
                    numbers.add(numberToAdd);
                }
                case "Insert" -> {
                    int numberToInsert = Integer.parseInt(commandParts[1]);
                    int position = Integer.parseInt(commandParts[2]);
                   
                    if (position >= 0 && position <= numbers.size() - 1) {
                      
                        numbers.add(position, numberToInsert);
                    } else {
                     
                        System.out.println("Invalid index");
                    }
                }
                case "Remove" -> {
                    
                    int positionToRemove = Integer.parseInt(commandParts[1]);
                    
                    if (positionToRemove >= 0 && positionToRemove <= numbers.size() - 1) {
                        
                        numbers.remove(positionToRemove);
                    } else {
                        
                        System.out.println("Invalid index");
                    }
                }
                case "Shift" -> {
                    
                    String direction = commandParts[1]; 
                    int count = Integer.parseInt(commandParts[2]);
                    if (direction.equals("left")) {
                        //first number becomes last 'count' times
                        for (int i = 1; i <= count; i++) {
                            
                            int firstNumber = numbers.get(0);
                           
                            numbers.remove(0);
                            
                            numbers.add(firstNumber);
                        }
                    } else if (direction.equals("right")) {
                       
                        for (int i = 1; i <= count; i++) {
                            
                            int lastNumber = numbers.get(numbers.size() - 1);
                            
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
