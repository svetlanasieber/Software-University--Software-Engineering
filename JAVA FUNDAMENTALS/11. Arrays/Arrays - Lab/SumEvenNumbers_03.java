package Others_Tasks;

import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int sumEven = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                sumEven += number;
            }

        }
        System.out.println(sumEven);
    }
}

