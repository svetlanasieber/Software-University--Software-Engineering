package Methods_Exercise;

import java.util.Scanner;

public class PalindromeIntegers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine(); 

        while (!input.equals("END")) {

            if (isPalindrome(input)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            input = scanner.nextLine();
        }
    }

    public static boolean isPalindrome (String text) {
    
        String reversedText = ""; 

        for (int position = text.length() - 1; position >= 0 ; position--) {
            reversedText += text.charAt(position);
        }

        return text.equals(reversedText);

    }
}
