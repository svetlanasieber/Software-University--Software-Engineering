package Lab05_Basic_Syntax_Recap;

import java.util.Scanner;

public class P06ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        //	"English" -> if the entered country is "USA" or "England"
        //	"Spanish" -> if the entered country is "Spain" or "Argentina" or "Mexico"
        //	"unknown" -> if the entered country is any other different from countries listed above


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
