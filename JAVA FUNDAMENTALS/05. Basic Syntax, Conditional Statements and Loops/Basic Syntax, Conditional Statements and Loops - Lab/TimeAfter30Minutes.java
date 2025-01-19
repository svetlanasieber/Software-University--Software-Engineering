package Lab05_Basic_Syntax_Recap;

import java.util.Scanner;

public class TimeAfter30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        minutes += 30;

        if (minutes > 59) {
            minutes -= 60;
            hours++;
        }
        if (hours > 23) {
            hours = 0;
        }
        System.out.printf("%2d:%02d", hours, minutes);

    }
}

