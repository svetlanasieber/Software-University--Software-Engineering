package Lab05_Basic_Syntax_Recap;

import java.util.Scanner;

public class Demo_02 {
    public static void main(String[] args) {
        //Input -> scanner
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        double money = Double.parseDouble(scanner.nextLine());
        String type = scanner.nextLine();


        //Output -> System.out.println / System.out.print
        System.out.println("Desi");
        System.out.print("test");
        System.out.println("loves");


    }
}
