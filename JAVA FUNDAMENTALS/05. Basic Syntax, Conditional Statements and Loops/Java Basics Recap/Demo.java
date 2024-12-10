package Lek01_BasicSyntaxRecap;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = "Yuli";
        
        int number = Integer.parseInt(scanner.nextLine());
        double salary = Double.parseDouble(scanner.nextLine());
        char symbol = scanner.nextLine().charAt(0);
        boolean isValid = false; //false

        System.out.println("Works!");
        System.out.println("Hello Java!");
        System.out.printf("I'm %s!", name);
    }
}
