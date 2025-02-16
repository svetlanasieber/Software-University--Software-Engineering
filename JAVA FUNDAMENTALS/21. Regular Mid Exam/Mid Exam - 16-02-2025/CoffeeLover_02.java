package MidExam_16_02_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeLover_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> coffeeNames = new ArrayList<>(List.of(scanner.nextLine().split(" ")));


        int numberOfCommands = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandParts = scanner.nextLine().split(" ");

            switch (commandParts[0]) {
                case "Include":
                    includeCoffee(coffeeNames, commandParts[1]);
                    break;
                case "Remove":
                    removeCoffee(coffeeNames, commandParts[1], Integer.parseInt(commandParts[2]));
                    break;
                case "Prefer":
                    preferCoffee(coffeeNames, Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
                    break;
                case "Reverse":
                    reverseCoffee(coffeeNames);
                    break;
            }
        }


        System.out.println("Coffees:");
        System.out.println(String.join(" ", coffeeNames));

        scanner.close();
    }

    private static boolean isValidIndex(List<String> list, int index) {
        return index >= 0 && index < list.size();
    }

    private static void includeCoffee(List<String> coffeeList, String coffee) {
        coffeeList.add(coffee);
    }

    private static void removeCoffee(List<String> coffeeList, String position, int count) {
        if (count < 0 || count >= coffeeList.size()) return;

        if ("first".equals(position)) {
            for (int i = 0; i < count; i++) {
                coffeeList.remove(0);
            }
        } else if ("last".equals(position)) {
            for (int i = 0; i < count; i++) {
                coffeeList.remove(coffeeList.size() - 1);
            }
        }
    }

    private static void preferCoffee(List<String> coffeeList, int indexOne, int indexTwo) {
        if (isValidIndex(coffeeList, indexOne) && isValidIndex(coffeeList, indexTwo)) {
            String temp = coffeeList.get(indexOne);
            coffeeList.set(indexOne, coffeeList.get(indexTwo));
            coffeeList.set(indexTwo, temp);
        }
    }

    private static void reverseCoffee(List<String> coffeeList) {
        int size = coffeeList.size();
        for (int i = 0; i < size / 2; i++) {
            String temp = coffeeList.get(i);
            coffeeList.set(i, coffeeList.get(size - 1 - i));
            coffeeList.set(size - 1 - i, temp);
        }
    }
}

