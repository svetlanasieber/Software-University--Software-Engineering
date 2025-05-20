package stack_and_queues_exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String number : tokens) {
            stack.push(number);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}

