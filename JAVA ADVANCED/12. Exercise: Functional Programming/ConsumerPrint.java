import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); 
        String[] names = input.split("\\s+"); 


        Consumer<String[]> printArray = array -> {
            for (String name : array) {
                System.out.println(name);
            }
        };
       
        printArray.accept(names);

    }
}
