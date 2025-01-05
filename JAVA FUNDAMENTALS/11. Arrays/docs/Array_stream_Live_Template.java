package Lab11_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Array_stream_Live_Template {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //intarr
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //doublearr
        double [] salaries = Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .mapToDouble(Double::parseDouble)
                        .toArray();
    }
}
