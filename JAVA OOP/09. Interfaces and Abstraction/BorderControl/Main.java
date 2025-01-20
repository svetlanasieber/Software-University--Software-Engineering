package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Identifiable> enteringTheCity = new ArrayList<>();
        fillList(enteringTheCity, scanner);
        printInvalidId(enteringTheCity, scanner);
    }

    private static void printInvalidId(List<Identifiable> enteringTheCity, Scanner scanner) {
        String invalidId = scanner.nextLine();
        enteringTheCity.forEach(e -> {

            int startIndex = e.getId().length() - invalidId.length();
            String currentId = e.getId().substring(startIndex);
            if (currentId.equals(invalidId)) {
                System.out.println(e.getId());
            }
        });
    }

    private static void fillList(List<Identifiable> enteringTheCity, Scanner scanner) {
        String line = scanner.nextLine();
        while (!line.equals("End")) {

            String[] tokens = line.split("\\s+");
            switch (tokens.length) {
                case 3:
                    enteringTheCity.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
                    break;
                case 2:
                    enteringTheCity.add(new Robot(tokens[0], tokens[1]));
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
