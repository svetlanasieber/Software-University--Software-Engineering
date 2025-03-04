import java.util.*;

public class CountRealNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double [] numbers = Arrays.stream(scanner.nextLine().split(" "))

        Map<Double, Integer> numbersCountMap = new TreeMap<>();

        for (double number : numbers) {
            
            if (!numbersCountMap.containsKey(number)) {
               
                numbersCountMap.put(number, 1);
            }
         
            else {
                int currentCount = numbersCountMap.get(number);
                numbersCountMap.put(number, currentCount + 1);
            }
        }


        for (Map.Entry<Double, Integer> pair : numbersCountMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", pair.getKey(), pair.getValue());
        }



    }
}
