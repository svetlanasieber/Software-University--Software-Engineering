package maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamResults_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        Map<String, Integer> userPoints = new LinkedHashMap<>();
     
        Map<String, Integer> languageCount = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String username = input.split("-")[0];
            if (input.contains("banned")) {
              
                userPoints.remove(username);
            } else {
             
                String language = input.split("-")[1];
                int points = Integer.parseInt(input.split("-")[2]);

               
                if (!userPoints.containsKey(username)) {
                    userPoints.put(username, points);
                } else {
                    int currentPoints = userPoints.get(username);
                    if (points > currentPoints) {
                        userPoints.put(username, points);
                    }
                }

                if (!languageCount.containsKey(language)) {
                    languageCount.put(language, 1);
                } else {
                    int currentCount = languageCount.get(language);
                    languageCount.put(language, currentCount + 1);
                }
            }
            input = scanner.nextLine();
        }


      
        System.out.println("Results:");
      
        userPoints.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));

      
        System.out.println("Submissions:");
  
        languageCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}
