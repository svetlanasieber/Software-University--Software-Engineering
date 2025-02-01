package Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine()
                                 .split(" "))
                                 .mapToInt(Integer::parseInt).toArray();
  

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            if (command.contains("swap")) {

                int positionFirstNumber = Integer.parseInt(command.split(" ")[1]); 
                int positionSecondNumber = Integer.parseInt(command.split(" ")[2]);

                int firstNumber = numbers[positionFirstNumber]; 
                int secondNumber = numbers[positionSecondNumber]; 

                numbers[positionFirstNumber] = secondNumber;
                numbers[positionSecondNumber] = firstNumber;

            } else if (command.contains("multiply")) {
              
                int positionFirstNumber = Integer.parseInt(command.split(" ")[1]); 
                int positionSecondNumber = Integer.parseInt(command.split(" ")[2]); 

                int firstNumberForMultiply = numbers[positionFirstNumber];
                int secondNumberForMultiply = numbers[positionSecondNumber];

                int product = firstNumberForMultiply * secondNumberForMultiply;
                numbers[positionFirstNumber] = product;
            } else if (command.equals("decrease")) {

                for (int position = 0; position <= numbers.length - 1; position++) {

                    numbers[position]--;

                }
            }

            command = scanner.nextLine();
        }

        for (int position = 0; position <= numbers.length - 1; position++) {
            int currentNumber = numbers[position];
            if (position != numbers.length - 1) {
                System.out.print(currentNumber + ", ");
            } else {

                System.out.print(currentNumber);
            }
        }

    }
}
