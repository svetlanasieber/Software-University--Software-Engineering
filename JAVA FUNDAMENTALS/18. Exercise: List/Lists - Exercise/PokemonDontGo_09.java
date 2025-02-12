package List_Exercise;

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

        while (numbers.size() > 0) { //while (!numbers.isEmpty()) {
            int position = Integer.parseInt(scanner.nextLine());
            if (position < 0) {

                int firstElement = numbers.get(0); 
                numbers.remove(0);
                sumRemovedElements += firstElement;
                int lastElement = numbers.get(numbers.size() - 1);
                numbers.add(0, lastElement);

                modifyList(numbers, firstElement);
            } else if (position > numbers.size() - 1) {

                int lastElement = numbers.get(numbers.size() - 1); 
                numbers.remove(numbers.size() - 1);
                sumRemovedElements += lastElement;
                int firstElement = numbers.get(0);
                numbers.add(firstElement);

                modifyList(numbers, lastElement);
            } else {
        
                int elementForRemove = numbers.get(position);
                numbers.remove(position);
                sumRemovedElements += elementForRemove;


                modifyList(numbers, elementForRemove);
            }
        }

        System.out.println(sumRemovedElements);
    }


    private static void modifyList (List<Integer> numbers, int removedElement) {

        for (int position = 0; position <= numbers.size() - 1; position++) {
            int currentElement = numbers.get(position);
            if (currentElement <= removedElement) {
                currentElement += removedElement;
            } else { //currentElement > removedElement
                currentElement -= removedElement;
            }
            numbers.set(position, currentElement);
        }
    }
}
