package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elementsList = Arrays.stream(scanner.nextLine() 
                                                  .split(", ")) 
                                                  .collect(Collectors.toList()); 

        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {

            if (command.contains("Collect")) {
              
                String elementToAdd = command.split(" - ")[1];
                if (!elementsList.contains(elementToAdd)) {
                    elementsList.add(elementToAdd);
                }
            } else if (command.contains("Drop")) {
           
                String elementToRemove = command.split(" - ")[1];
                elementsList.remove(elementToRemove); 
            } else if (command.contains("Combine Items")) {
               
  
                String oldElement = command.split(" - ")[1].split(":")[0];
                String newElement = command.split(" - ")[1].split(":")[1];

                if (elementsList.contains(oldElement)) {
                    int positionOldElement = elementsList.indexOf(oldElement);
                    elementsList.add(positionOldElement + 1, newElement);
                }

            } else if (command.contains("Renew")) {
              
                String elementToMove = command.split(" - ")[1];
                if (elementsList.contains(elementToMove)) {
                    elementsList.remove(elementToMove);
                    elementsList.add(elementToMove);
                }
            }


            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", elementsList));
    }
}
