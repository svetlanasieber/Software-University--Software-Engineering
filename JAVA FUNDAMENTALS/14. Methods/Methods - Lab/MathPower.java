import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPowerV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        double power = Double.parseDouble(scanner.nextLine());

        DecimalFormat decimalFormat = new DecimalFormat("0.####");
        System.out.println(decimalFormat.format(pow(number,power)));
    }

    public static double pow (double number, double power){
        double result = 1;

        for (int i = 0; i < power; i++) {
            result *= number;
        }

        return result;
    }
}
