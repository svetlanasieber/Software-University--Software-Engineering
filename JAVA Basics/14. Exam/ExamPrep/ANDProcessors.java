package FirstStepsInCoding.Lab.Exam;

import java.util.Scanner;

public class ANDProcessors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countProcessors = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int workingDays = Integer.parseInt(scanner.nextLine());

        double workHours = workers * workingDays * 8;
        double timeProcessors = Math.floor(workHours / 3);

        if (timeProcessors < countProcessors) {
            double loss = countProcessors - timeProcessors;

            System.out.printf("Losses: -> %.2f BGN", loss * 110.10);
        } else {
            double profit = timeProcessors - countProcessors;

            System.out.printf("Profit: -> %.2f BGN", profit * 110.10);
        }
    }
}
