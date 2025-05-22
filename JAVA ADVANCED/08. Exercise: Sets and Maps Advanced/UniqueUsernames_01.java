import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countUsernames = Integer.parseInt(scanner.nextLine());

        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 1; i <= countUsernames; i++) {
            String currentUsername = scanner.nextLine();
            boolean isAdded = usernames.add(currentUsername);
        }

        for (String name : usernames) {
            System.out.println(name);
        }
    }

}
