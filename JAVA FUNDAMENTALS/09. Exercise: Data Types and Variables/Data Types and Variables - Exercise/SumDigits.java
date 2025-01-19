package Exercise09_Data_Types_And_Variables;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        //number % 10 = 1
        //number / 10

        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;

        
            sum += lastDigit;

         
            number = number / 10;

        }
    }
}

