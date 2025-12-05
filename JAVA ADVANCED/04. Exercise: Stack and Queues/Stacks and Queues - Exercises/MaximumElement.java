import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= numberOfCommands ; i++) {
            String currentCommand = scanner.nextLine();

            if(currentCommand.equals("2")){
                stack.pop();
            } else if (currentCommand.equals("3")) {
                if(!stack.isEmpty()){
                    System.out.println(Collections.max(stack));
                }
            }else {
                int numberToPush = Integer.parseInt(currentCommand.split("\\s+")[1]);
                stack.push(numberToPush);
            }

        }




    }
}

