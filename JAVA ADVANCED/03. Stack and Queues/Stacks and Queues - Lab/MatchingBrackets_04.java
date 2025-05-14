package stack_and_queues_lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int position = 0; position <= expression.length() - 1; position++) {
            char currentSymbol = expression.charAt(position);
            if (currentSymbol == '(') {
                stack.push(position);
            } else if (currentSymbol == ')') {
                int positionOpenBracket = stack.pop();
                System.out.println(expression.substring(positionOpenBracket, position + 1));
            }
        }
    }
}

