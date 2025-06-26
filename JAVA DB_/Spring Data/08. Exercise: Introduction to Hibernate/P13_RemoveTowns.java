import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;


public class P13_RemoveTowns {

    final private static String SELECT_ADDRESSES = "select a from Address a where a.town.name like :townName";
    final private static String SELECT_TOWN = "select t from Town t where t.name like : townName";

    final private static String STRING_FORMAT = "%d address in %s deleted";

    public static void main(String[] args) {



        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constant.DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        final Scanner scanner = new Scanner(System.in);
        final String townName = scanner.nextLine();


        final List<Address> addressesToBeRemoved = entityManager.createQuery(SELECT_ADDRESSES, Address.class)
                .setParameter("townName", townName).getResultList();

        final int countTowns = addressesToBeRemoved.size();

        if (countTowns == 0) {
            System.out.println("No such town");
            entityManager.close();
            return;
        }

        addressesToBeRemoved.forEach(a -> {
            a.getEmployees().forEach(e -> e.setAddress(null));
            entityManager.remove(a);
                });

        final Town townFromDB = entityManager.
                createQuery(SELECT_TOWN, Town.class).
                setParameter("townName", townName).
                getSingleResult();

        entityManager.remove(townFromDB);

        String address = countTowns == 1 ? "address" : "addresses";
        System.out.printf("%d %s in %s deleted", countTowns, address, townName);


        entityManager.getTransaction().commit();
        entityManager.close();

    }
    
    
}
