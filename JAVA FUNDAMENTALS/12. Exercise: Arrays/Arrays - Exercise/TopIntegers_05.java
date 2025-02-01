package Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int [] numbers = Arrays.stream(scanner.nextLine()
                       .split(" "))
                       .mapToInt(Integer::parseInt).toArray();

        for (int position = 0; position <= numbers.length - 1; position++) {

            if (position == numbers.length - 1) {
                System.out.print(numbers[position]);
                break;
            }

           
            int currentNumber = numbers[position];
       
            boolean isTop = true;

            for (int nextPosition = position + 1; nextPosition <= numbers.length - 1; nextPosition++) {
                int nextNumber = numbers[nextPosition]; //числа, след моето
                if (currentNumber <= nextNumber) {
                    isTop = false;
                    break;
                }
            }

            if (isTop) {
                System.out.print(currentNumber + " ");
            }
        }

    }
}
