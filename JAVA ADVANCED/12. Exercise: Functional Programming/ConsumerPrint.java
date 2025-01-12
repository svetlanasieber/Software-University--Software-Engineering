import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

     
        Consumer<String> consumer = name -> System.out.println(name);


      
        names.forEach(consumer);

       
//        names.forEach(name -> System.out.println(name));
    }
}
