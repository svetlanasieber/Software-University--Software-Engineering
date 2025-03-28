package JavaAdvRegular_20oct_2024;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BallGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] strengthTokens = scanner.nextLine().split("\\s+");
        Deque<Integer> strengths = new ArrayDeque<>();

        for (String token : strengthTokens) {
            strengths.addLast(Integer.parseInt(token));
        }


        String[] accuracyTokens = scanner.nextLine().split("\\s+");
        Deque<Integer> accuracies = new ArrayDeque<>();

        for (String token : accuracyTokens) {
            accuracies.addLast(Integer.parseInt(token));
        }

        int goals = 0;


        while (!strengths.isEmpty() && !accuracies.isEmpty()) {
            int currentStrength = strengths.removeLast();
            int currentAccuracy = accuracies.removeFirst();
            int sum = currentStrength + currentAccuracy;

            if (sum == 100) {

                goals++;
            } else if (sum < 100) {

                if (currentStrength < currentAccuracy) {

                    accuracies.addFirst(currentAccuracy);
                } else if (currentStrength > currentAccuracy) {

                    strengths.addLast(currentStrength);
                } else {

                    strengths.addLast(currentStrength + currentAccuracy);
                }
            } else {

                currentStrength -= 10;
                strengths.addLast(currentStrength);
                accuracies.addLast(currentAccuracy);
            }
        }


        if (goals == 3) {
            System.out.println("Paul scored a hat-trick!");
        } else if (goals == 0) {
            System.out.println("Paul failed to score a single goal.");
        } else if (goals > 3) {
            System.out.println("Paul performed remarkably well!");
        } else {
            System.out.println("Paul failed to make a hat-trick.");
        }


        if (goals > 0) {
            System.out.println("Goals scored: " + goals);
        }


        if (!strengths.isEmpty()) {
            String strengthLeft = strengths.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Strength values left: " + strengthLeft);
        }


        if (!accuracies.isEmpty()) {
            String accuracyLeft = accuracies.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Accuracy values left: " + accuracyLeft);
        }

        scanner.close();
    }
}


