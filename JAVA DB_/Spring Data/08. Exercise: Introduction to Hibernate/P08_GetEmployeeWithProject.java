

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;


public class P08_GetEmployeeWithProject {

    final private static String SELECT_EMPLOYEE = "select e from Employee e where e.id = :id";

    final private static String  STRING_ID = "id";
    final private static String STRING_FORMAT = "%s %s - %s%n";
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);


        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constant.DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        final int id = Integer.parseInt(scanner.nextLine());



        final Employee employee = entityManager.createQuery(SELECT_EMPLOYEE, Employee.class)
                .setParameter(STRING_ID, id)
                .getSingleResult();

        final TreeSet<String> sortedProjects = new TreeSet<>();

        employee.getProjects().forEach(p -> sortedProjects.add(p.getName()));

        System.out.printf(STRING_FORMAT, employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        sortedProjects.forEach(p -> System.out.println("\t" + p));

        entityManager.getTransaction().commit();
        entityManager.close();

    }
    
    
}
