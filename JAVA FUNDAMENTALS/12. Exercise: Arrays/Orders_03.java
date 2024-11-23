package maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();
  
        Map<String, Double> productsPrice = new LinkedHashMap<>();


        String productData = scanner.nextLine();

        while (!productData.equals("buy")) {
           
            String productName = productData.split(" ")[0];
            double price = Double.parseDouble(productData.split(" ")[1]); 
            int quantity = Integer.parseInt(productData.split(" ")[2]);

           
            if (!productsQuantity.containsKey(productName)) {
              
                productsQuantity.put(productName, quantity);
            } else {
               
                int currentQuantity = productsQuantity.get(productName);
                productsQuantity.put(productName, currentQuantity + quantity);
            }

          
            productsPrice.put(productName, price);

            productData = scanner.nextLine();
        }

      
        for (Map.Entry<String, Integer> entry : productsQuantity.entrySet()) {
            //entry (key: име на продукта -> value: количество)
            String productName = entry.getKey();
            double finalSum = entry.getValue() * productsPrice.get(productName);
            System.out.printf("%s -> %.2f%n", productName, finalSum);
        }

    }
}
