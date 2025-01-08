package Lab05_Basic_Syntax_Recap;

import java.util.Scanner;

public class P05MonthPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
      

        //	1 -> "January"
        // 	2 -> "February"
        // 	3 -> "March"
        // 	4 -> "April"
        // 	5 -> "May"
        // 	6 -> "June"
        // 	7 -> "July"
        // 	8 -> "August"
        // 	9 -> "September"
        // 	10 -> "October"
        // 	11 -> "November"
        //  12 -> "December"

        switch (number) {
            case 1 -> System.out.println("January");
            case 2 -> System.out.println("February");
            case 3 -> System.out.println("March");
            case 4 -> System.out.println("April");
            case 5 -> System.out.println("May");
            case 6 -> System.out.println("June");
            case 7 -> System.out.println("July");
            case 8 -> System.out.println("August");
            case 9 -> System.out.println("September");
            case 10 -> System.out.println("October");
            case 11 -> System.out.println("November");
            case 12 -> System.out.println("December");
            default -> System.out.println("Error!");

        }


    }
}
