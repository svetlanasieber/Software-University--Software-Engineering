package Regular_Expression_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexPassword = "_\\.+(?<passwordText>[A-Z][A-Za-z0-9]{4,}[A-Z])_\\.+";
        Pattern pattern = Pattern.compile(regexPassword);

        int n = Integer.parseInt(scanner.nextLine()); 
        for (int count = 1; count <= n; count++) {
            String password = scanner.nextLine();
          
            Matcher matcher = pattern.matcher(password);
        

            if (matcher.find()) {

                String textPassword = matcher.group("passwordText"); 
              
                StringBuilder sbDigits = new StringBuilder(); 
                for (char symbol : textPassword.toCharArray()) {
                    if (Character.isDigit(symbol)) {
                      
                        sbDigits.append(symbol);
                    }
                }
         
                if (sbDigits.length() == 0) {
                    System.out.println("Group: default");
                }
             
                else {
                    System.out.println("Group: " + sbDigits);
                }
            } else {
               
                System.out.println("Invalid pass!");
            }

        }
    }
}
