
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class P05_EmployeesFromDepartment {

    final private static String SELECT_EMPLOYEES = "select e  from Employee e " +
                                                    "where e.department.name = :departmentName " +
                                                    "order by e.salary asc , e.id asc";
    final private static String DEPARTMENT = "Research and Development";
    final private static String STRING_DEPARTMENT_NAME = "departmentName";
    final private static String STRING_FORMAT = "%s %s from %s - $%.2f%n";

    public static void main(String[] args) {



        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constant.DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery(SELECT_EMPLOYEES, Employee.class)
                .setParameter(STRING_DEPARTMENT_NAME, DEPARTMENT)
                .getResultStream()
                .forEach(e -> System.out.printf(STRING_FORMAT,
                        e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary() ));


        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    
}
