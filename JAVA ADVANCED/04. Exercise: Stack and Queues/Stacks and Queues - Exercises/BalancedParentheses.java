import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stackOpenBrackets = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);

            if(currentBracket == '(' || currentBracket == '[' || currentBracket == '{'){
                stackOpenBrackets.push(currentBracket);
            }else {
                if(stackOpenBrackets.isEmpty() || !machBrackets(stackOpenBrackets.pop(), currentBracket)){
                    System.out.println("NO");
                    return;
                }
            }


        }

        System.out.println("YES");

    }

    private static boolean machBrackets(Character openBracketFromStack, char closedBracket) {

        if(openBracketFromStack == '('){
            return closedBracket == ')';
        } else if (openBracketFromStack == '[') {
            return closedBracket == ']';

        }else {
            return closedBracket == '}';
        }
    }
}
