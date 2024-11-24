package OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        List<Person> peopleList = new ArrayList<>(); //празен лист

        int countPeople = Integer.parseInt(scanner.nextLine());
        for (int count = 1; count <= countPeople; count++) {
            String personalData = scanner.nextLine();
        
            String name = personalData.split(" ")[0]; //име -> "Peter"
            int age = Integer.parseInt(personalData.split(" ")[1]); //възраст -> 12

         
            if (age > 30) {
                Person person = new Person(name, age);
                peopleList.add(person);
            }
        }


        for (Person person : peopleList) {
       
            System.out.println(person.getName() + " - " + person.getAge());
        }

    }
}
