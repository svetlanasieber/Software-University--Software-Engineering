import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Yul_SetsOfElements_retainAll {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int countElementsFirstSet = Integer.parseInt(input.split("\\s+")[0]);
        int countElementsSecondSet = Integer.parseInt(input.split("\\s+")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        /*for (int i = 1; i <= countElementsFirstSet + countElementsSecondSet; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            if(i <= countElementsFirstSet){
                firstSet.add(currentNumber);
            }else {
                secondSet.add(currentNumber);
            }
        }*/





        fillSet(countElementsFirstSet, scanner, firstSet);
        fillSet(countElementsSecondSet, scanner, secondSet);

        firstSet.retainAll(secondSet);//retainAll
        firstSet.forEach(element -> System.out.print(element + " "));

       /* for (int numberFromFirstSet : firstSet){
            if (secondSet.contains(numberFromFirstSet)){
                System.out.print(numberFromFirstSet + " ");
            }
        }*/



    }

    private static void fillSet(int countElements, Scanner scanner, Set<Integer> firstSet) {
        for (int i = 1; i <= countElements; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            firstSet.add(currentNumber);
        }
    }
}
