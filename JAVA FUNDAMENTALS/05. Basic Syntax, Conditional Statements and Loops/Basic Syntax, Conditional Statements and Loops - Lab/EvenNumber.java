package Lab05_Basic_Syntax_Recap;

import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int enteredNumber = Integer.parseInt(scanner.nextLine()); 
        while (enteredNumber % 2 != 0) {
          
            System.out.println("Please write an even number.");
            enteredNumber = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("The number is: " + Math.abs(enteredNumber));

    }
}
