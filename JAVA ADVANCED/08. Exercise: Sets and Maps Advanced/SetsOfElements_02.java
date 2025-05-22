import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int countElementsFirstSet = Integer.parseInt(input.split("\\s+")[0]);
        int countElementsSecondSet = Integer.parseInt(input.split("\\s+")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        fillSet(countElementsFirstSet, scanner, firstSet);
        fillSet(countElementsSecondSet, scanner, secondSet);


        for (int numberFromFirstSet : firstSet) {
            if (secondSet.contains(numberFromFirstSet)) {
                System.out.print(numberFromFirstSet + " ");
            }
        }
    }

    private static void fillSet(int countElements, Scanner scanner, Set<Integer> secondSet) {
        for (int i = 1; i <= countElements; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            secondSet.add(currentNumber);
        }
    }
}
