
import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class P07_AddressesWithEmployeeCount {

    final private static String SELECT_ADDRESSES = "select a from Address a order by a.employees.size desc";
    final private static int MAX_RESULT = 10;
    final private static String STRING_FORMAT = "%s, %s - %d employees%n";
    public static void main(String[] args) {


        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constant.DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();



        entityManager.createQuery(SELECT_ADDRESSES, Address.class)
                .setMaxResults(MAX_RESULT)
                .getResultStream()
                        .forEach(a -> System.out.printf(STRING_FORMAT,
                                a.getText(),
                                a.getTown() == null ? "" : a.getTown().getName(),
                                a.getEmployees().size()));



        entityManager.getTransaction().commit();
        entityManager.close();

    }
    
    
}
