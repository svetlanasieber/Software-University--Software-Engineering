package Conditional_Statements_Lab;

import java.util.Scanner;

public class boolean_demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = 5;
        boolean isPositive = a > 0;
        System.out.println(isPositive);

        int b = -5;
        boolean isNegative = b > 0;
        System.out.println(isNegative);
    }
}
