import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String email = "";

        Map<String, String> collection = new LinkedHashMap<>();

        while (!command.equals("stop")) {

            email = scanner.nextLine();

            if (!email.endsWith("uk") && !email.endsWith("us") && !email.endsWith("com")) {

                collection.put(command, email);
            }

            command = scanner.nextLine();
        }

        collection.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));

    }
}

