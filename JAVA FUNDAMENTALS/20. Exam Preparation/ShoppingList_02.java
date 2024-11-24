package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        List<String> productsList = Arrays.stream(scanner.nextLine()     
                                    .split("!"))                   
                                    .collect(Collectors.toList());        


        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {

            String [] commandParts = command.split(" ");
            String commandName = commandParts[0]; 
            String item = commandParts[1]; 

            switch (commandName) {
                case "Urgent":
     
                    if (!productsList.contains(item)) {
                        productsList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                 
                    productsList.remove(item); 
                    break;
                case "Correct":
                 
                    String newItem = commandParts[2]; 
                   
                    if (productsList.contains(item)) {
                        int position = productsList.indexOf(item);
                        productsList.set(position, newItem); 
                    }
                    break;
                case "Rearrange":
              
                    if (productsList.contains(item)) {
                        productsList.remove(item);
                        productsList.add(item);
                    }
                    break;

            }
            command = scanner.nextLine();
        }


        System.out.println(String.join(", ", productsList));


                .replace("[", "")  
                .replace("]", "")); 

        
        }
}
