package Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countProducts = Integer.parseInt(scanner.nextLine()); 
        List<String> products = new ArrayList<>(); 

        for (int count = 1; count <= countProducts; count++) {
            String productName = scanner.nextLine();
            products.add(productName);
        }

        Collections.sort(products);

        int number = 1; 
        for (String product : products) {
            System.out.println(number + "." + product);
            number++;
        }
    }
}
