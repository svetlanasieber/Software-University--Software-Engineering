import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Get_Employee_With_Project_08 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        int employeeId = Integer.parseInt(scanner.nextLine());

        Employee employee = entityManager.createQuery(
                        "SELECT e FROM Employee e" +
                                " WHERE e.id = :employeeId", Employee.class)
                .setParameter("employeeId", employeeId)
                .getSingleResult();

        System.out.println(employee.getFirstName() + " " + employee.getLastName() + " - " + employee.getJobTitle());

        employee
                .getProjects()
                .stream()
                .sorted((a1, a2) -> a1.getName().compareTo(a2.getName()))
                .forEach(p -> System.out.println("\t" + p.getName()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
