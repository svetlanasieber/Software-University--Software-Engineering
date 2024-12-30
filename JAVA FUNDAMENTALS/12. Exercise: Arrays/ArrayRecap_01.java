package Exercise12_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRecap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Integer Array
        int[] numbers1 = new int[3];

        numbers1[0] = 5;
        numbers1[1] = 20;
        numbers1[2] = 25;

        // Read Array from the Console
    
        String input = scanner.nextLine();
        String[] towns = input.split(" ");

        // foreach loop
        for (String town : towns) {
            System.out.println(town + " is a nice city.");
        }

        // String.join
        System.out.println(String.join(", ", towns));

        // Reat Integer Array from the Console
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

    }
}
