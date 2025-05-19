import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        ArrayDeque<String> queueKids = Arrays.stream(scanner.nextLine().split("\\s+"))
                                  .collect(Collectors.toCollection(ArrayDeque::new));

        int  countPasses = Integer.parseInt(scanner.nextLine());

        while (queueKids.size() > 1) {
           
            for (int i = 1; i < countPasses; i++) {
                String rotatedKid = queueKids.poll(); 
                queueKids.offer(rotatedKid); 
            }
         
            System.out.println("Removed " + queueKids.poll());
        }

   
      System.out.println("Last is " + queueKids.peek());
    }
}

