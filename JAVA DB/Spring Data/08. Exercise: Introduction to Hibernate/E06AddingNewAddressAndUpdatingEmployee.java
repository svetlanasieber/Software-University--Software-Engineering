import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class E06AddingNewAddressAndUpdatingEmployee {
    public static void main(String[] args) {
        final EntityManager entityManager = Connector.createEntityManager();
        final Scanner scanner = new Scanner(System.in);

        entityManager.getTransaction().begin();

        final String lastName = scanner.nextLine();

        final List<Employee> resultList = entityManager
                .createQuery("FROM Employee WHERE lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getResultList();

        final Set<Employee> employees = new HashSet<>(resultList);

        if (!employees.isEmpty()) {
            Address newAddress = new Address();
            newAddress.setText("Vitoshka 15");

            Town town = entityManager.find(Town.class, 7);
            newAddress.setTown(town);

            entityManager.persist(newAddress);

            employees.forEach(employee -> employee.setAddress(newAddress));

            entityManager.flush();
        } else {
            System.out.println("No employee found with the provided last name.");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
        scanner.close();
    }
}