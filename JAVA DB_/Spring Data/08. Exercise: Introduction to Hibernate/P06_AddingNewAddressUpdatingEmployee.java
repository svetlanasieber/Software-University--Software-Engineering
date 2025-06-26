
import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;


public class P06_AddingNewAddressUpdatingEmployee {

    final private static String UPDATE_EMPLOYEES = "update Employee e set e.address = :address where e.lastName = :name";
    final private static String STRING_NEW_ADDRESS = "Vitoshka 15";
    final private static String STRING_NAME = "name";
    final private static String STRING_ADDRESS = "address";
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);


        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constant.DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        final Address address = new Address();
        address.setText(STRING_NEW_ADDRESS);
        entityManager.persist(address);

        final String lastName = scanner.nextLine();

        entityManager.createQuery(UPDATE_EMPLOYEES)
                .setParameter(STRING_NAME, lastName)
                .setParameter(STRING_ADDRESS, address)
                .executeUpdate();



        entityManager.getTransaction().commit();
        entityManager.close();

    }
    
    
}
