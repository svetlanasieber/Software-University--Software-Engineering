package Lab05_Basic_Syntax_Recap;

import java.util.Scanner;

public class P08DivisibleBy3 {
    public static void main(String[] args) {

        for (int number = 1; number <= 100; number++) //number <= 99 {
            if (number % 3 == 0) {
                System.out.println(number);
            }
        }

    }

