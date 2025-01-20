package SortByNameAndAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0], input[1], Integer.parseInt(input[2]));
            people.add(person);
        }

        people.stream().sorted((e1, e2) -> {
            int result = e1.getFirstName().compareTo(e2.getFirstName());
            if (result != 0) {
                return result;
            } 
            return Integer.compare(e1.getAge(),e2.getAge());
        }).forEach(e -> System.out.println(e.toString()));
    }
}
