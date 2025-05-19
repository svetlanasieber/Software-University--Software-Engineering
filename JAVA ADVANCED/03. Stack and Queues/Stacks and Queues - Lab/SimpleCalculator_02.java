import java.util.ArrayDeque;
import java.util.Scanner;

public class _SimpleCalculator_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < inputArr.length; i++) {
            String symbol = inputArr[i];
            if (Character.isDigit(symbol.charAt(0))) {
                numbers.push(Integer.parseInt(symbol));
            } else {
                int rightDigit = Integer.parseInt(inputArr[++i]);
                int leftDigit = numbers.getFirst();
                numbers.push(rightDigit);

                int result = symbol.equals("+")
                        ? leftDigit + rightDigit 
                        : leftDigit - rightDigit; 

                numbers.push(result);
            }
        }

        System.out.println(numbers.peek());
    }
}
