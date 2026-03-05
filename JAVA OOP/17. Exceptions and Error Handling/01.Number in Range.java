import java.util.Optional;
import java.util.Scanner;

public class numberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rangeNums = scanner.nextLine().split("\\s+");
        int begin = Integer.parseInt(rangeNums[0]);
        int end = Integer.parseInt(rangeNums[1]);
        System.out.println("Range: [" + begin + "..." + end + "]");
        String input = scanner.nextLine();
        while (!validInput(input, begin, end)) {
            input = scanner.nextLine();

        }
    }

    private static boolean validInput(String input, int begin, int end) {
        Optional<Integer> number = Optional.empty();

        try {
            number = Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException ignored) {
        }
        boolean numberIsValid = number.isPresent()
                && number.get() >= begin
                && number.get() <= end;


        String output = numberIsValid
                ? String.format("Valid number: %d", number.get())
                : String.format("Invalid number: %s", input);
        System.out.println(output);
        return numberIsValid;
    }

}
