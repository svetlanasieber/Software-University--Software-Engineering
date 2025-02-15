import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> studentsMap = new HashMap<>();
     
        studentsMap.put("Ivan", 5.60);
        studentsMap.put("Petya", 4.30);
        studentsMap.put("Georgi", 3.40);

        System.out.println(studentsMap.size()); 

        studentsMap.remove("Petya"); 
        studentsMap.remove("Georgi", 3.40); 
   
        System.out.println(studentsMap.isEmpty());
        System.out.println(studentsMap.containsKey("Desi"));
        System.out.println(studentsMap.containsValue(5.40));

        studentsMap.clear();
    }
}
