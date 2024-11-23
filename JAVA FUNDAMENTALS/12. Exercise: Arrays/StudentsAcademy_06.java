package maps;

import java.util.*;

public class StudentsAcademy_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        Map<String, List<Double>> studentGrades = new LinkedHashMap<>();

        int countStudents = Integer.parseInt(scanner.nextLine()); 
        for (int count = 1; count <= countStudents; count++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

         
            if (studentGrades.containsKey(studentName)) {
                List<Double> currentGrades = studentGrades.get(studentName);
                currentGrades.add(grade);
            }
        
            else {
                studentGrades.put(studentName, new ArrayList<>());
                studentGrades.get(studentName).add(grade);
            }
        }

   

        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
          
            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();
            double averageGrade = getAverageGrade(grades);

            if (averageGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n", studentName, averageGrade);
            }
        }
    }

  
    private static double getAverageGrade(List<Double> grades) {
        //{5, 4, 6, 3}
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
