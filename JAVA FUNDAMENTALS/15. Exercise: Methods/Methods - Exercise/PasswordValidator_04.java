import java.util.Scanner;

public class PasswordValidator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        boolean isValidLength = isValidLength(password);

        if (!isValidLength) {
  
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean isValidContent = isValidContent(password);

        if (!isValidContent) {
            System.out.println("Password must consist only of letters and digits");
        }

        boolean isValidCount = isValidCountDigits(password);

        if (!isValidCount) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidLength && isValidContent && isValidCount) {
            System.out.println("Password is valid");
        }

    }

    public static boolean isValidLength (String password) {

        return password.length() >= 6 && password.length() <= 10;
    }

    public static boolean isValidContent (String password) {
 
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {

                return false;
            }
        }

        return true;
    }


    public static boolean isValidCountDigits (String password) {
        int countDigits = 0; 

        for (char symbol :  password.toCharArray()) {
            if (Character.isDigit(symbol)) {

                countDigits++;
            }
        }

        return countDigits >= 2;
    }
}
