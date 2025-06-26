import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;


public class P11_FindEmployeesByFirsName {

    final private static String SELECT_EMPLOYEES_START_WITH = "select e from Employee e where lower(e.firstName) like :pattern";

    final private static String STRING_FORMAT = "%s %s - %s - ($%.2f)%n";
    final private static String STRING_PATTERN = "pattern";
    public static void main(String[] args) {





        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constant.DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        final Scanner scanner = new Scanner(System.in);
        final String givenPattern = scanner.nextLine();

        entityManager.createQuery(SELECT_EMPLOYEES_START_WITH, Employee.class)
                .setParameter(STRING_PATTERN, givenPattern.toLowerCase() + "%")
                .getResultList()
                .forEach(e -> System.out.printf(STRING_FORMAT,
                        e.getFirstName(),
                        e.getLastName(),
                        e.getJobTitle(),
                        e.getSalary()));


        entityManager.getTransaction().commit();
        entityManager.close();

    }
    
    
}
