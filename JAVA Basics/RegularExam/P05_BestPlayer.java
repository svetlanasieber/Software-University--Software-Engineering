import java.util.Scanner;

public class P05_BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();

        String bestPlayer = "";
        int bestScore = 0;

        while (!command.equals("END")) {
            String playerName = command;
            int countOfGoals = Integer.parseInt(scanner.nextLine());

            if (countOfGoals > bestScore) {
                bestScore = countOfGoals;
                bestPlayer = playerName;
            }

            if (countOfGoals >= 10) {
                break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("%s is the best player!%n", bestPlayer);

        if (bestScore >= 3) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!%n", bestScore);
        } else {
            System.out.printf("He has scored %d goals.%n", bestScore);
        }
    }
}




