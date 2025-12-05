package stack_queue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("print")) {
          
            if (input.equals("cancel")) {
              
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printerQueue.poll());
                }
            } else {
               
                printerQueue.offer(input);
            }

            input = scanner.nextLine();
        }


        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}


