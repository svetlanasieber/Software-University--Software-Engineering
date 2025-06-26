

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class P03_ContainsEmployee {

    final private static String SELECT_EMPLOYEES = "select count(e) from Employee e where e.firstName = :first_name AND e.lastName = :last_name";
    final private static String STRING_FIRST_NAME = "first_name";
    final private static String STRING_LAST_NAME = "last_name";
    final private static String STRING_YES = "Yes";
    final private static String STRING_NO = "No";
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constant.DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        final String[] names = scanner.nextLine().split("\\s+");

        final String firstName = names[0];
        final String lastName = names[1];

        final Long employeeCount = entityManager.createQuery(SELECT_EMPLOYEES, Long.class)
                .setParameter(STRING_FIRST_NAME, firstName)
                .setParameter(STRING_LAST_NAME, lastName)
                .getSingleResult();

        if(employeeCount > 0){
            System.out.println(STRING_YES);

        }else {
            System.out.println(STRING_NO);
        }



        entityManager.getTransaction().commit();
        entityManager.close();



    }
    
    
}
