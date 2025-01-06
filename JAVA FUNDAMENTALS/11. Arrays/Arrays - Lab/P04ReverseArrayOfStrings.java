package Lab11_Arrays;

import java.util.Scanner;

public class P04ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] texts = scanner.nextLine().split(" ");

        for (int position = texts.length - 1; position >= 0; position--) {
            System.out.print(texts[position] + " ");
        }

    }
}

