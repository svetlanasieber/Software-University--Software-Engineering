import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class E03ContainsEmployee {
    public static void main(String[] args) {

        final EntityManager entityManager = Connector.createEntityManager();
        final Scanner scanner = new Scanner(System.in);
        final String fullName = scanner.nextLine();
        entityManager.getTransaction().begin();

        final String isEmployeePresented =
                entityManager
                        .createQuery("FROM Employee WHERE CONCAT_WS(' ', first_name, last_name) = :fullName", Employee.class)
                        .setParameter("fullName", fullName)
                        .getResultList()
                        .isEmpty() ? "No" : "Yes";

        entityManager.getTransaction().commit();
        System.out.println(isEmployeePresented);
    }
}