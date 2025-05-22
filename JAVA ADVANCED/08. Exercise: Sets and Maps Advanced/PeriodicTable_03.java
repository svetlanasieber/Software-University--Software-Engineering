import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countChemicalCompounds = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalElements = new TreeSet<>();

        for (int i = 1; i <= countChemicalCompounds; i++) {

            //String[] currentChemicalCompound = scanner.nextLine().split("\\s+ ");
            chemicalElements.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }

        chemicalElements.forEach(e -> System.out.printf("%s ", e));

    }
}

