package DataTypes;

import java.util.Scanner;

public class LowerOrUpper_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol = scanner.nextLine().charAt(0);

        int code = (int) symbol; 
        if (code >= 97 && code <= 122) {
            System.out.println("lower-case");
        } else if (code >= 65 && code <= 90) {
            System.out.println("upper-case");
        }
    }
}
