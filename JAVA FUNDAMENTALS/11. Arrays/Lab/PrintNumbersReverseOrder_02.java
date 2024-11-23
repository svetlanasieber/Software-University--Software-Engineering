package Arrays;

import java.util.Scanner;

public class PrintNumbersReverseOrder_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        
        int[] numbers = new int[n];

  
        for (int position = 0; position <= numbers.length - 1; position++) {

            numbers[position] = Integer.parseInt(scanner.nextLine());
        }

      
        for (int i = numbers.length - 1; i >= 0 ; i--) {
            System.out.print(numbers[i] + " ");
        }


    }
}
