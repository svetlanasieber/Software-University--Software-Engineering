package FirstStepsInCoding.Lab.Exam;

import java.util.Scanner;

public class ProgrammingBook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double pagePrice = Double.parseDouble(scanner.nextLine());
        double coverPrice = Double.parseDouble(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());
        double designerPrice = Double.parseDouble(scanner.nextLine());
        int teamPrice = Integer.parseInt(scanner.nextLine());

        double printingPrice =  899 * pagePrice + coverPrice * 2;
        double discountPercent = discount * 0.01;
        double priceWDiscount = printingPrice - (discountPercent * printingPrice);
        double DesignerMoney = designerPrice + priceWDiscount;
        double teamPercent = teamPrice * 0.01;
        double teamMoney = DesignerMoney - (teamPercent * DesignerMoney);

        System.out.printf("Avtonom should pay %.2f BGN.", teamMoney);


    }
}
