package stack_and_queues_exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Stack_and_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Stack
        //LIFO - First in, First Out
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        stack.push(11);
        stack.push(22);
        stack.push(33);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        
        
        //Queue
        //FIFO - First In, First Out
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        queue.offer(12);
        queue.offer(13);
        queue.offer(14);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
