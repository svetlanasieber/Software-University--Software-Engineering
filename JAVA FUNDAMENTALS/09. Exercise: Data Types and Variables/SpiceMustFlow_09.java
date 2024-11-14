import java.util.Scanner;

public class SpiceMustFlow_09 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       
        int startingYield = Integer.parseInt(scanner.nextLine());

        int days = 0;
        int totalSpices = 0;

        while (startingYield >= 100) {

            totalSpices += startingYield;

          
            startingYield -= 10;

        
            totalSpices -= 26;

            days++;

      
            if (startingYield < 100) {
                totalSpices -= 26;
            }
        }

        System.out.println(days);
        System.out.println(totalSpices);
    }
}
