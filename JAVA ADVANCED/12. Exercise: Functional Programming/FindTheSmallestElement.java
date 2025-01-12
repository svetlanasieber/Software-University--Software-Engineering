import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        Function<List<Integer>, Integer> function = listOfNumbers -> Collections.min(listOfNumbers);

        Integer minValue = function.apply(numbers);

       
        System.out.println(numbers.lastIndexOf(minValue)); 
    }
}
