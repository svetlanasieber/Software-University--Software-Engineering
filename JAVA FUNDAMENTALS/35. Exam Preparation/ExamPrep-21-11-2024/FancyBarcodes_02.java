package ExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "[@][#]+[A-Z][A-Za-z0-9]{4,}[A-Z][@][#]+"; 
        Pattern pattern = Pattern.compile(regex);

        int countBarcodes = Integer.parseInt(scanner.nextLine()); /

        for (int count = 1; count <= countBarcodes; count++) {
            String textBarcode = scanner.nextLine(); //"@#FreshFisH@#"
            Matcher matcher = pattern.matcher(textBarcode);
         

          
            if (matcher.find()) {
                //въведения баркод е валиден
                String productGroup = calculateProductGroup(textBarcode);
                System.out.println("Product group: " + productGroup);
            } else {
                //въведения баркод не е валиден
                System.out.println("Invalid barcode");
            }
        }
    }

    private static String calculateProductGroup(String textBarcode) {
        //textBarcode = "@###Che46sE@##"
        StringBuilder sbProductGroup = new StringBuilder(); 
        //textBarcode.toCharArray() -> ['@', '#', '#', '#', ....]
        for (char symbol : textBarcode.toCharArray()) {
            if (Character.isDigit(symbol)) {
                sbProductGroup.append(symbol);
            }
        }



        if (sbProductGroup.isEmpty()) {
            return "00";
        } else {
            return sbProductGroup.toString();
        }
    }
}
