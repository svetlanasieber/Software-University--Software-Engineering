package Lab11_Arrays;

import java.util.Scanner;

public class P02PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        int count = Integer.parseInt(scanner.nextLine()); 
        int[] numbers = new int[count];

        for (int position = 0; position <= numbers.length - 1; position++) {
            numbers[position] = Integer.parseInt(scanner.nextLine());
        }

      
        for (int position = numbers.length - 1; position >= 0; position--) {
            System.out.print(numbers[position] + " ");
        }

    }
}

