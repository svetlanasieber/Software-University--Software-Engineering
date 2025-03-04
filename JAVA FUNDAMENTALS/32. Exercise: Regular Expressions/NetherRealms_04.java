package RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] demonNames = scanner.nextLine().replace(" ", "").split(",");

        for (String demonName : demonNames) {
            int health = getHealth(demonName);
            double damage = getDamage(demonName);

            for (char symbol : demonName.toCharArray()) {
                if (symbol == '*') {
                    damage *= 2;
                } else if (symbol == '/') {
                    damage /= 2;
                }
            }

     
            System.out.printf("%s - %d health, %.2f damage%n", demonName, health, damage);
        }
    }


    private static double getDamage(String demonName) {
        double damage = 0;
      
        String regexNumbers = "[-]?[0-9]+\\.?[0-9]*";
        Pattern pattern = Pattern.compile(regexNumbers);
        Matcher matcher = pattern.matcher(demonName);

        while (matcher.find()) {
            damage += Double.parseDouble(matcher.group());
        }
        return damage;
    }

 
    private static int getHealth(String demonName) {
        int health = 0;
     
        for (char symbol : demonName.toCharArray()) {
            if (!Character.isDigit(symbol) && symbol != '+' && symbol != '-' && symbol != '*' && symbol != '.' && symbol != '/') {
                health += (int)(symbol);
            }
        }
        return health;
    }
}
