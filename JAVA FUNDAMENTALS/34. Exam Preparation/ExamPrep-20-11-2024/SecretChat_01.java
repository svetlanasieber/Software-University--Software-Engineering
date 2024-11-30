package ExamPrep;

import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder concealedMessage = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();


        while (!command.equals("Reveal")){

          
            //InsertSpace, Reverse, ChangeAll
            String[] currentData = command.split(":\\|:");
            String currentCommand = currentData[0];

            switch (currentCommand){

                case "InsertSpace" -> {
                 
                    int index = Integer.parseInt(currentData[1]);
                  
                    concealedMessage.insert(index, " ");//abcdefabc -> 2
                    System.out.println(concealedMessage);
                }

                case "Reverse" -> {
                    StringBuilder substring = new StringBuilder(currentData[1]);
                    //Reverse:|:{substring}

                   
                    if (!concealedMessage.toString().contains(substring)){
                       
                        System.out.println("error");
                    }else {
                      
                        int firstIndex = concealedMessage.indexOf(substring.toString());//0
                        int lastIndex = firstIndex + substring.length();//3
                   
                        String reversedString = substring.reverse().toString();
                      
                        concealedMessage.delete(firstIndex, lastIndex);
                      
                        concealedMessage.append(substring);
                        System.out.println(concealedMessage);

                    }
                }

                case "ChangeAll" -> {
                    String substringToReplace = currentData[1];
                    String replacement = currentData[2];

                    //String newMessage = concealedMessage.toString().replace(substringToReplace, replacement);

                    while (concealedMessage.toString().contains(substringToReplace)){
                        int firstIndex = concealedMessage.indexOf(substringToReplace);
                        int lastIndex = firstIndex + substringToReplace.length();
                        concealedMessage.replace(firstIndex, lastIndex, replacement);
                    }
                    System.out.println(concealedMessage);

                }
            }
            command = scanner.nextLine();
        }


        System.out.println("You have a new text message: " + concealedMessage);


    }
}
