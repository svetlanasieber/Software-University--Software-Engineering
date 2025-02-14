import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class E08GetEmployeesWithProject {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Connector.createEntityManager()
                .createQuery("FROM Employee WHERE id = :employeeId", Employee.class)
                .setParameter("employeeId", new Scanner(System.in).nextInt())
                .getSingleResult()
                .printFullNameWithProjectNames();
    }
}