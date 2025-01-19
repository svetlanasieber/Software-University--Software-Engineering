package Lab05_Basic_Syntax_Recap;

import java.util.Scanner;

public class PassedOrFailed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        if(grade >= 3.00) {
            System.out.println("Passed!");
        } else {
            //grade < 3.00
            System.out.println("Failed!");
        }
    }
}

