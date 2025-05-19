import java.util.Arrays;
import java.util.Scanner;

public class P04_SumMatrixElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int cols = dimension[1];
        int totalSum = 0;

        for (int i = 0; i < rows; i++) {
            int sum = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .sum();
            totalSum += sum;

        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(totalSum);
    }
}
