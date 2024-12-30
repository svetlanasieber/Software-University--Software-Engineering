package Lab11_Arrays;

import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentDay = Integer.parseInt(scanner.nextLine());

        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (currentDay >= 1 && currentDay <= 7) {
            System.out.println(weekDays[currentDay - 1]);
        } else {
            System.out.println("Invalid day!");
        }

    }
}

