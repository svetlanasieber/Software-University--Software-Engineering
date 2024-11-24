package Methods_Exercise;

import java.util.Locale;
import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
    

        int countVowels = getVowelsCount(text);
        System.out.println(countVowels);
    }

    public static int getVowelsCount (String text) {
        int count = 0;


        for (char symbol : text.toLowerCase().toCharArray()) {
          
            switch (symbol) {
                case 'a', 'e', 'o', 'u', 'i' -> count++;
            }
        }

        return count;
    }
}
