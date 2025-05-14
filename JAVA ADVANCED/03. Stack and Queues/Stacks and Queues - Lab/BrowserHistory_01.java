package stack_and_queues_lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentURL = "";
        ArrayDeque<String> browserHistory = new ArrayDeque<String>();

        String command = scanner.nextLine();
        while (!command.equals("Home")) {
            if (command.equals("back")) {

                if (browserHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                }
                else {
                    browserHistory.pop(); 
                    currentURL = browserHistory.peek();
                    System.out.println(currentURL);
                }
            } else {
                currentURL = command;
                System.out.println(currentURL);
                browserHistory.push(currentURL);
            }
            command = scanner.nextLine();
        }
    }
}

