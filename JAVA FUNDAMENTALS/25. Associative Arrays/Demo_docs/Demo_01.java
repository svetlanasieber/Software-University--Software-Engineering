import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //запис: име на ученик (String) -> оценка (double)

        //създаване на празен мап
        Map<String, Double> studentsMap = new HashMap<>();

        //добавяме записи в мап
        studentsMap.put("Ivan", 5.60);
        studentsMap.put("Petya", 4.30);
        studentsMap.put("Georgi", 3.40);

        System.out.println(studentsMap.size()); //брой на записите в мап-а

        //премахваме запис от мап-а
        studentsMap.remove("Petya"); //премахване по ключ
        studentsMap.remove("Georgi", 3.40); //премахване на запис

        //проверка дали мап-а е празен  (size = 0)
        System.out.println(studentsMap.isEmpty());


        // проверка дали съществува запис с даден ключ (true or false)
        System.out.println(studentsMap.containsKey("Desi"));
        System.out.println(studentsMap.containsValue(5.40));

        //премахва всички елементи от мап-а
        studentsMap.clear();
    }
}
