package Lists_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                                         .map(Integer::parseInt).collect(Collectors.toList());

     
        String input = scanner.nextLine();
      
        int bombNumber = Integer.parseInt(input.split(" ")[0]); //4
        int power = Integer.parseInt(input.split(" ")[1]); //2



        while (numbers.contains(bombNumber)) {
          
            int bombPosition = numbers.indexOf(bombNumber); //3
            
            int startPosition = Math.max(0, bombPosition - power);
            int endPosition = Math.min(numbers.size() - 1, bombPosition + power); 

         
            for (int position = endPosition; position >=  startPosition; position--) {
                numbers.remove(position);
            }
        }

     
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        System.out.println(sum);


    }
}
