package G03_Arrays;

import java.util.Scanner;

public class ArrayRecap_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];

        numbers[0] = 5;
        numbers[1] = 20;
        numbers[2] = 25; //numbers: [5, 20, 25]


        String[] towns = scanner.nextLine().split(" ");

        //System.out.println();

        // foreach loop
        for (String town : towns) {
            System.out.println(town + " is a nice city.");

            
        }
    }



}
