import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber_05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();

        BigInteger number1 = new BigInteger(firstNumber);
        BigInteger number2 = new BigInteger(secondNumber);

      
        System.out.println(number1.multiply(number2));

    }
}
