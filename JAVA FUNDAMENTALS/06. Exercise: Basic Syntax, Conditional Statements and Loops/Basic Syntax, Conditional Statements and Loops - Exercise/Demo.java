package Exercise06_BasicSyntax;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String input = scanner.nextLine();

       while (!input.equals("sleep")) {
           System.out.println("Code the project");
           input = scanner.nextLine();
       }


    }
}
