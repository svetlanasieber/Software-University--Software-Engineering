import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> symbolCount = new TreeMap<>();

        String line = scanner.nextLine();

        for (char symbol : line.toCharArray()) {
        
            if (symbolCount.containsKey(symbol)) {
             
                int count = symbolCount.get(symbol) + 1;
                symbolCount.put(symbol, count);
            }
         
            else {
                symbolCount.put(symbol, 1);
            }
        }

        symbolCount.entrySet().forEach(entry -> System.out.printf("%c: %d time/s\n", entry.getKey(), entry.getValue()));
    }
}
