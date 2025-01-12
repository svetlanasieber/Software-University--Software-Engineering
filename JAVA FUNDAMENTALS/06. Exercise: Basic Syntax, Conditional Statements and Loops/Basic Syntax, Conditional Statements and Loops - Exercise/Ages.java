package Exercise06_BasicSyntax;

import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ages = Integer.parseInt(scanner.nextLine());

        if (ages >= 0 && ages <= 2) {
            System.out.println("baby");
        }

        else if (ages >= 3 && ages <= 13) {
            System.out.println("child");
        }

        else if (ages >= 14 && ages <= 19) {
            System.out.println("teenager");
        }
        else if (ages >= 20 && ages <= 65) {
            System.out.println("adult");
        }
        else if (ages >= 66) {
            System.out.println("elder");
        }
    }
}
