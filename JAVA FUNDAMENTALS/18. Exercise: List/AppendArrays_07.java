package Lists_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        List<String> texts = Arrays.stream(input.split("\\|")).collect(Collectors.toList());

        Collections.reverse(texts);
     

        System.out.println(texts.toString() 
                        .replace("[", "") 
                        .replace("]", "")
                        .replaceAll(",", "")
                        .replaceAll("\\s+", " ") 
                        .trim()); //"3 2 5 1 0 4 5 7"

    }
}
