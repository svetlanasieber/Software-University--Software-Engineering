package FinalExam_30_03_2025;

import java.util.Scanner;

public class DecryptingCommands_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String command;
        while (!(command = scanner.nextLine()).equals("Finish")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Replace":
                    String currentChar = tokens[1];
                    String newChar = tokens[2];
                    message = message.replace(currentChar, newChar);
                    System.out.println(message);
                    break;

                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (isValidIndex(startIndex, message) && isValidIndex(endIndex, message)) {
                        String firstPart = message.substring(0, startIndex);
                        String secondPart = message.substring(endIndex + 1);
                        message = firstPart + secondPart;
                        System.out.println(message);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

                case "Make":
                    String caseType = tokens[1];
                    if (caseType.equals("Upper")) {
                        message = message.toUpperCase();
                    } else if (caseType.equals("Lower")) {
                        message = message.toLowerCase();
                    }
                    System.out.println(message);
                    break;

                case "Check":
                    String stringToCheck = tokens[1];
                    if (message.contains(stringToCheck)) {
                        System.out.println("Message contains " + stringToCheck);
                    } else {
                        System.out.println("Message doesn't contain " + stringToCheck);
                    }
                    break;

                case "Sum":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);

                    if (isValidIndex(startIndex, message) && isValidIndex(endIndex, message) && startIndex <= endIndex) {
                        String substring = message.substring(startIndex, endIndex + 1);
                        int sum = 0;
                        for (char c : substring.toCharArray()) {
                            sum += c;
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;
            }
        }
    }

    private static boolean isValidIndex(int index, String str) {
        return index >= 0 && index < str.length();
    }
}

