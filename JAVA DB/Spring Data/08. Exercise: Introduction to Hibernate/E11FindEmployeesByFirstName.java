import entities.Employee;

import java.util.Scanner;

public class E11FindEmployeesByFirstName {
    public static void main(String[] args) {
        Connector.createEntityManager()
                .createQuery("FROM Employee WHERE firstName LIKE CONCAT(:letters, '%')", Employee.class)
                .setParameter("letters", new Scanner(System.in).nextLine())
                .getResultList()
                .forEach(empl -> System.out.printf("%s %s - %s - ($%s)%n",
                        empl.getFirstName(),
                        empl.getLastName(),
                        empl.getJobTitle(),
                        empl.getSalary()));
    }
}
