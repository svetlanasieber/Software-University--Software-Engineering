package Others_Tasks;

import java.util.Scanner;

public class DayOfWeek_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfWeek = Integer.parseInt(scanner.nextLine());

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (daysOfWeek >= 1 && daysOfWeek <= 7) {
            System.out.println(days[daysOfWeek-1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
