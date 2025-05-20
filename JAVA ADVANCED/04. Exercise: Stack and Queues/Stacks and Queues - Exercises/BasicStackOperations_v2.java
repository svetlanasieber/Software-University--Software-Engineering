package stack_and_queues_exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]); 
        int s = Integer.parseInt(input[1]); 
        int x = Integer.parseInt(input[2]); 

       
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] elements = scanner.nextLine().split("\\s+");

        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(elements[i]));
        }

       
        for (int i = 0; i < s && !stack.isEmpty(); i++) {
            stack.pop();
        }

     
        if (stack.isEmpty()) {
            System.out.println(0);
        } 
      
        else if (stack.contains(x)) {
            System.out.println("true");
        } 
     
        else {
            int smallest = Integer.MAX_VALUE;
            for (Integer element : stack) {
                if (element < smallest) {
                    smallest = element;
                }
            }
            System.out.println(smallest);
        }
    }
}
