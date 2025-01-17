package Lab08_Data_Types_And_Variables;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int meters = Integer.parseInt(scanner.nextLine());

        //km = meters / 1000
        double kilometers = meters / 1000.0;
        System.out.printf("%.2f", kilometers);
    }
}

