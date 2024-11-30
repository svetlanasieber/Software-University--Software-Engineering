package ExamPreparation;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine(); 
        StringBuilder modifiedMessage = new StringBuilder(encryptedMessage); 

        String command = scanner.nextLine();
        while (!command.equals("Decode")) {
       
            if (command.contains("Move")) {
              
                int countLetters = Integer.parseInt(command.split("\\|")[1]); 
         
                String firstLetters = modifiedMessage.substring(0, countLetters);
                modifiedMessage.delete(0, countLetters); 
                modifiedMessage.append(firstLetters);
            } else if (command.contains("Insert")) {
          
                int position = Integer.parseInt(command.split("\\|")[1]); 
                String textToInsert = command.split("\\|")[2]; 
                modifiedMessage.insert(position, textToInsert);
            } else if (command.contains("ChangeAll")) {
              
                String textForChange = command.split("\\|")[1]; 
                String replacement = command.split("\\|")[2]; 
             
                String currentMessage = modifiedMessage.toString();
                currentMessage = currentMessage.replace(textForChange, replacement);
                modifiedMessage = new StringBuilder(currentMessage);
            }

            command = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + modifiedMessage);
    }
}
