package Lists_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                                         .map(Integer::parseInt).collect(Collectors.toList());
         int sumRemovedElements = 0; 
         
        while (numbers.size() > 0) {
            int position = Integer.parseInt(scanner.nextLine());
          
            if (position < 0) {
               
                int removedElement = numbers.get(0);
               
                sumRemovedElements += removedElement;
               
                numbers.remove(0);
              
                int lastNumber = numbers.get(numbers.size() - 1);
           
                numbers.add(0, lastNumber);
              
                modifyList(numbers, removedElement);
            }
          
            else if (position > numbers.size() - 1) {
             
                int removedElement = numbers.get(numbers.size() - 1);
              
                sumRemovedElements += removedElement;
              
                numbers.remove(numbers.size() - 1);
           
                int firstNumber = numbers.get(0);
            
                numbers.add(firstNumber);
    
                modifyList(numbers, removedElement);
            }
          
            else { //position >= 0 && position <= numbers.size() - 1

              
                int removedElement = numbers.get(position);
              
                sumRemovedElements += removedElement;
               
                numbers.remove(position);
               
                modifyList(numbers, removedElement);
            }
        }
        System.out.println(sumRemovedElements);
    }

    
    private static void modifyList(List<Integer> numbers, int removedElement) {
        
        for (int position = 0; position <= numbers.size() - 1; position++) {
            int currentNumber = numbers.get(position);
            if (currentNumber <= removedElement) {
                currentNumber += removedElement;
            } else { //current > removedElement
                currentNumber -= removedElement;
            }
            numbers.set(position, currentNumber);
        }
    }
}
