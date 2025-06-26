import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class P12_EmployeesMaximumSalaries {

    final private static String SELECT_MAX_SALARY_FROM_DEPARTMENT_NOT_IN_RANGE = "select e.department.name, max(e.salary) from Employee e " +
                                                "group by e.department.name " +
                                                "having max(e.salary) not between 30000 AND 70000";

    final private static String STRING_FORMAT = "%s  %.2f%n";

    public static void main(String[] args) {



        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constant.DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        entityManager.createQuery(SELECT_MAX_SALARY_FROM_DEPARTMENT_NOT_IN_RANGE, Object[].class)
                .getResultList()
                .forEach(e -> System.out.printf(STRING_FORMAT, e[0], e[1]));


        entityManager.getTransaction().commit();
        entityManager.close();

    }
    
    
}
