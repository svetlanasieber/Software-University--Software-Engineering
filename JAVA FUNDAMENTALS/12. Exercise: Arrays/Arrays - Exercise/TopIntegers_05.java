package Exercise12_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int position = 0; position <= array.length - 1; position++) {

         
            if (position == array.length - 1) {
                System.out.println(array[position]);
                break;
            }

       
            int currentNum = array[position];

            boolean isTopInteger = true;
            for (int nextPosition = position + 1; nextPosition <= array.length - 1; nextPosition++) {

             
                int nextNumber = array[nextPosition];

                if (nextNumber >= currentNum) {
                    isTopInteger = false;
                    break;
                }
            }
          
            if (isTopInteger) {
                System.out.print(currentNum + " ");
            }
        }

    }
}
