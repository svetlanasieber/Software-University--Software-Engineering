package Lab11_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Reading Array Value from a Single Line -> Arrays.stream

        String input = " 1 2 3 4 5";

        String[] nums = input.split(" "); //-> ["1", "2", "3", "4", "5"]

//----------------------------------------------------------------------------------------------
       
        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))//-> ["1", "2", "3", "4", "5"]
                .mapToInt(Integer::parseInt) //-> [1, 2, 3, 4, 5]
                .toArray();

        double[] salary = Arrays.stream(scanner.nextLine()
                        .split(""))
                .mapToDouble(Double::parseDouble)
                .toArray();
//-------------------------------------------------------------------------------------------------
        /*for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }
        */


    }
}
