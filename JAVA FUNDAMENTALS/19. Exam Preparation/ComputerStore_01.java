package MidExamPrep1;

import java.util.Scanner;

public class ComputerStore_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        double priceWithoutTaxes = 0;
        double taxes = 0;

      
        while (!command.equals("special") && !command.equals("regular")){
           
            double currentPrice = Double.parseDouble(command);

           
            if(currentPrice < 0){
                System.out.println("Invalid price!");
                command = scanner.nextLine();
                continue;
            }

            priceWithoutTaxes += currentPrice;

          
            taxes += currentPrice * 0.20;

            command = scanner.nextLine();
        }

        double totalSum = priceWithoutTaxes + taxes;

        if(command.equals("special")){
            totalSum = totalSum * 0.9;
        }

        String finalText = String.format("Congratulations you've just bought a new computer!%n") +
                String.format("Price without taxes: %.2f$%n", priceWithoutTaxes) +
                String.format("Taxes: %.2f$%n", taxes) +
                String.format("-----------%n") +
                String.format("Total price: %.2f$", totalSum);

        if(totalSum <= 0){
            System.out.println("Invalid order!");
        }else {
            System.out.println(finalText);
            /*System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalSum);*/

        }

    }
}
