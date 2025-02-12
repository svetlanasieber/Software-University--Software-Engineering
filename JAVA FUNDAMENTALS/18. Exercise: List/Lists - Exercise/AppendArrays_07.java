package List_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> texts = Arrays.stream(input.split("\\|")).collect(Collectors.toList());

        Collections.reverse(texts);


        for (String text : texts) {

            if (text.equals("") || text.equals(" ")) {
                continue;
            }
            System.out.print(text.trim().replaceAll("\\s+", " ") + " ");
        }

    }
}
