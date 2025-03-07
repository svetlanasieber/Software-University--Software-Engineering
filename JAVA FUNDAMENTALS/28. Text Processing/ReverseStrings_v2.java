package Text_Processing_Lab;

import java.util.Scanner;

public class ReverseStrings_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;

       
        while (true) {
            input = scanner.nextLine();

            
            if (input.equals("end")) {
                break;
            }

            
            String reversed = reverseString(input);

            
            System.out.println(input + " = " + reversed);
        }

        scanner.close();
    }

   
    private static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }
}

