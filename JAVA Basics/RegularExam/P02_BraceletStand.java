import java.util.Scanner;

public class P02_BraceletStand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


                double dailyIncome = Double.parseDouble(scanner.nextLine());
                double dailyEarnings = Double.parseDouble(scanner.nextLine());
                double totalExpenses = Double.parseDouble(scanner.nextLine());
                double giftPrice = Double.parseDouble(scanner.nextLine());

                // Calculate
                double savingsPocket = dailyIncome * 5;
                double earnings = dailyEarnings * 5;
                double totalSavings = savingsPocket + earnings - totalExpenses;


                if (totalSavings >= giftPrice) {
                    System.out.printf("Profit: %.2f BGN, the gift has been purchased.%n", totalSavings);
                } else {
                    double neededMoney = giftPrice - totalSavings;
                    System.out.printf("Insufficient money: %.2f BGN.%n", neededMoney);
                }

                scanner.close();
            }
        }



