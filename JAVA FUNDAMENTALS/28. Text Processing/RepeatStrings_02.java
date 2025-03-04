package textProcessing;

import java.util.Scanner;

public class RepeatStrings_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] texts = scanner.nextLine().split(" ");

        for (String text : texts) {
            int length = text.length(); 
       
            System.out.println(text.repeat(length));
        }
    }
}
