import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmail_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();
        String email = "";

        Map<String, String> collection = new LinkedHashMap<>();

        while (!command.equals("stop")){

            email = scanner.nextLine();

            if(!email.toLowerCase().endsWith("uk") && !email.toLowerCase().endsWith("us") && !email.toLowerCase().endsWith("com")){

                collection.put(command, email);
            }
            command = scanner.nextLine();
        }

        collection.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
