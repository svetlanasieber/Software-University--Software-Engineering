package Lab11_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int [] firstArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] secondArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        boolean isIdentical = true;
       
        int differentIndex = 0;
        int sum = 0;

        for (int position = 0; position <= firstArray.length - 1; position++) {
            int elementFirstArray = firstArray[position]; 
            int elementSecondArray = secondArray[position];

            if (elementFirstArray == elementSecondArray) {
                sum += elementFirstArray;
            } else {
            
                isIdentical = false;
                differentIndex = position;
                break;
            }
        }

        if (isIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
     
        else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", differentIndex);
        }
    }
}

