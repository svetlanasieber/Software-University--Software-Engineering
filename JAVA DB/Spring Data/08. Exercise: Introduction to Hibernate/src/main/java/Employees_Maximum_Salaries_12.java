import entities.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class Employees_Maximum_Salaries_12 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Department> departments = entityManager.createQuery("SELECT d FROM Department d", Department.class).getResultList();

        for (Department department : departments) {
            BigDecimal maxSalary = entityManager.createQuery(
                            "SELECT MAX(e.salary)" +
                                    " FROM Employee e" +
                                    " WHERE" +
                                    " e.salary NOT BETWEEN 30000 AND 70000" +
                                    " AND e.department.name = :department" +
                                    " ORDER BY e.department.id DESC", BigDecimal.class)
                    .setParameter("department", department.getName())
                    .getSingleResult();
            if (maxSalary != null) {
                System.out.println(department.getName() + " " + maxSalary);
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
