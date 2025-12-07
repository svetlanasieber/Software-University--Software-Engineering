package stack_and_queues_exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_ReverseNumbersWithAStack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(stack::push);



        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
