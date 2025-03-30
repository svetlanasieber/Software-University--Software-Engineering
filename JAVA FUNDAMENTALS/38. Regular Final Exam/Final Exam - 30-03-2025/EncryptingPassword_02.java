package FinalExam_30_03_2025;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptingPassword_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "^(.+)>([0-9]{3})\\|([a-z]{3})\\|([A-Z]{3})\\|([^<>]{3})<\\1$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String encryptedPassword = matcher.group(2) +
                        matcher.group(3) +
                        matcher.group(4) +
                        matcher.group(5);

                System.out.println("Password: " + encryptedPassword);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}

