import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<String> browserHistory = new ArrayDeque<>();
        Deque<String> forwardHistory = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!"Home".equals(command)) {
            if (command.equals("back")) {
                if (browserHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardHistory.addFirst(browserHistory.peek());
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            } else if (command.equals("forward")) {
                if (forwardHistory.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardHistory.peek());
                    browserHistory.push(forwardHistory.pop());
                }
            } else {
                System.out.println(command);
                browserHistory.push(command);
                forwardHistory.clear();
            }
            command = scanner.nextLine();
        }

    }
}
