import java.util.Scanner;

public class P04_ComputerFirm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int modelsOfComputers = Integer.parseInt(scanner.nextLine());
        double totalRating = 0;
        double totalSales = 0;

        for (int number = 1; number <= modelsOfComputers; number++) {
            int salesPlusRating = Integer.parseInt(scanner.nextLine());
            int units = salesPlusRating % 10;
            int hundredsPlusTens = salesPlusRating / 10;

            switch (units) {
                case 2:
                    totalSales += 0;
                    totalRating += units;
                    break;
                case 3:
                    totalSales += hundredsPlusTens * 0.50;
                    totalRating += units;
                    break;
                case 4:
                    totalSales += hundredsPlusTens * 0.70;
                    totalRating += units;
                    break;
                case 5:
                    totalSales += hundredsPlusTens * 0.85;
                    totalRating += units;
                    break;
                case 6:
                    totalSales += hundredsPlusTens * 1.0;
                    totalRating += units;
                    break;
            }
        }

        double avgRating = totalRating / modelsOfComputers;

        System.out.printf("%.2f%n", totalSales);
        System.out.printf("%.2f%n", avgRating);
    }
}
