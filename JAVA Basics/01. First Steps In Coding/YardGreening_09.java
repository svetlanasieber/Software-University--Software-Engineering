import java.util.Scanner;

public class YardGreening_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double area = Double.parseDouble(scanner.nextLine());

        double priceNoDiscount = 7.61 * area;
        double discount = priceNoDiscount * 0.18;
        double finalPrice = priceNoDiscount - discount;

        System.out.printf("The final price is: %f lv. %n", finalPrice);
        System.out.printf("The discount is: %f lv.", discount);
    }
}
