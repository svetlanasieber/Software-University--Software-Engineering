package maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replace(" ", "");

        Map<Character, Integer> symbolsCount = new LinkedHashMap<>();

  
        char[] symbols = input.toCharArray();
        for (char symbol : symbols) {
         
            if (symbol == ' ') {
                continue; 
            }
          
            if (!symbolsCount.containsKey(symbol)) {
            
                symbolsCount.put(symbol, 1);
            } else {
               
                int currentCount = symbolsCount.get(symbol); 
                symbolsCount.replace(symbol, currentCount, currentCount + 1);
            }
        }


        for(Map.Entry<Character, Integer> entry : symbolsCount.entrySet()) {

            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

       
        /*symbolsCount
                .entrySet()   //съвкупността от всички записи
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));*/

    }
}
