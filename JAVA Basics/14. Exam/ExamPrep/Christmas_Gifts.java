package FirstStepsInCoding.Lab.Exam;

import java.util.Scanner;

public class Christmas_Gifts {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();

        int toyPrice = 5;
        int sweaterPrice = 15;
        int kid = 0;
        int adult = 0;
        int toysMoney = 0;
        int sweaterMoney = 0;

        while (!command.equals("Christmas")) {
             int years = Integer.parseInt(command);


            if (years <= 16) {
                kid++;
                toysMoney = toyPrice * kid;
            } else {
                adult++;
                sweaterMoney = sweaterPrice * adult;
            }
            command = scanner.nextLine();

        }
        System.out.printf("Number of adults: %d%n", adult);
        System.out.printf("Number of kids: %d%n", kid);
        System.out.printf("Money for toys: %d%n", toysMoney);
        System.out.printf("Money for sweaters: %d", sweaterMoney);
    }
}
