import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


public class P10_IncreaseSalaries {

    final private static String SELECT_EMPLOYEES = "select e from Employee e where e.department.name in ( :department )";

    final private static String STRING_DEPARTMENT = "department";
    final private static String STRING_FORMAT = "%s %s ($%.2f)%n";
    public static void main(String[] args) {



        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constant.DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<String> departmentNames = Arrays.asList(
                "Engineering",
                "Tool Design",
                "Marketing",
                "Information Services");

        entityManager.createQuery(SELECT_EMPLOYEES, Employee.class)
                .setParameter(STRING_DEPARTMENT, departmentNames)
                .getResultList().
                forEach(e -> {
                    e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12)));
                    entityManager.persist(e);
                });


        entityManager
                .createQuery(SELECT_EMPLOYEES, Employee.class)
                .setParameter(STRING_DEPARTMENT, departmentNames)
                .getResultList()
                .forEach(e -> System.out.printf(STRING_FORMAT,
                        e.getFirstName(),
                        e.getLastName(),
                        e.getSalary()));





        entityManager.getTransaction().commit();
        entityManager.close();

    }
    
    
}
