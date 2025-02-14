import entities.Employee;

import javax.persistence.EntityManager;

public class E04EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        final EntityManager entityManager = Connector.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager
                .createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultList()
                .forEach(employee -> System.out.println(employee.getFirstName()));

        entityManager.getTransaction().commit();
    }
}