import java.util.Scanner;

public class ChristmasGifts_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int toyPrice = 5;
        int sweaterPrice = 15;
        int kidCount = 0;
        int adultCount = 0;
        int toysMoney = 0;
        int sweaterMoney = 0;

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Christmas")) {
                break;
            }

            int years = Integer.parseInt(command);

            if (years <= 16) {
                kidCount++;
                toysMoney = toyPrice * kidCount;
            } else {
                adultCount++;
                sweaterMoney = sweaterPrice * adultCount;
            }
        }

        System.out.println("Number of adults: " + adultCount);
        System.out.println("Number of kids: " + kidCount);
        System.out.println("Money for toys: " + toysMoney);
        System.out.println("Money for sweaters: " + sweaterMoney);

        scanner.close();

    }
}
