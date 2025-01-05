package Lab11_Arrays;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;

public class P03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sumEven = 0; 
        
        for (int number : numbers) {
            
            if (number % 2 == 0) {
                sumEven += number;
            }
        }
       
        System.out.println(sumEven);
    }
}

