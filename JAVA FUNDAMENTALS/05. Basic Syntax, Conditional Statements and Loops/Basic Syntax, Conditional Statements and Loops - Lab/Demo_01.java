package Lab05_Basic_Syntax_Recap;

import java.util.Scanner;

public class Demo_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int number = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        String name = scanner.nextLine(); //String name = "Desislava";
        boolean isTrue = false;
        char symbol = scanner.nextLine().charAt(0);  //char symbol = 'R';
    }
}
