package Lab05_Basic_Syntax_Recap;

import java.util.Scanner;

public class P06ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        switch (country) {
            case "USA":
            case "England":
                System.out.println("English");
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                System.out.println("Spanish");
                break;
                default:
                    System.out.println("unknown");
                    break;

        }

    }
}
