import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String data = scanner.nextLine();

        while (!data.equals("search")) {

            String name = data.split("-")[0];
            String phoneNumber = data.split("-")[1];

            phonebook.put(name, phoneNumber);

            data = scanner.nextLine();
        }
        String nameToPrint = scanner.nextLine();

        while (!nameToPrint.equals("stop")) {

            if (phonebook.containsKey(nameToPrint)) {
                System.out.printf("%s -> %s%n", nameToPrint, phonebook.get(nameToPrint));
            } else {
                System.out.printf("Contact %s does not exist.%n", nameToPrint);
            }

            nameToPrint = scanner.nextLine();
        }


    }
}

