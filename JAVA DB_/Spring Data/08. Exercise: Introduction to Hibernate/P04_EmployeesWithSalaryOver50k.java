
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class P04_EmployeesWithSalaryOver50k {

    final private static String SELECT_EMPLOYEES = "select e.firstName from Employee e where e.salary > 50000";
    public static void main(String[] args) {



        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constant.DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery(SELECT_EMPLOYEES, String.class)
                .getResultStream()
                .forEach(System.out::println);


        entityManager.getTransaction().commit();
        entityManager.close();

    }
    
    
}
