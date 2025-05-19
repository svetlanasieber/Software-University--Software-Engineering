import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> queue = new PriorityQueue<>();

        for (String child : children) {
            queue.offer(child);
        }

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.remove()); 
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycle) {
        int n = cycle;

        boolean prime = (n >= 2);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }

        return prime;
    }
}
