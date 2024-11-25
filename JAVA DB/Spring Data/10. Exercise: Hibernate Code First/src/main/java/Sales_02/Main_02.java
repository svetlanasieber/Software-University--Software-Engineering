package Sales_02;

import Sales_02.entities.Customer;
import Sales_02.entities.Product;
import Sales_02.entities.Sale;
import Sales_02.entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Main_02 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        insertData(entityManager);
        

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void insertData(EntityManager entityManager) {
        Product product = new Product("Prod-1", 100, BigDecimal.valueOf(10));
        Product product1 = new Product("Prod-2", 200, BigDecimal.valueOf(20));
        Product product2 = new Product("Prod-3", 300, BigDecimal.valueOf(30));
        Product product3 = new Product("Prod-4", 400, BigDecimal.valueOf(40));
        Product product4 = new Product("Prod-5", 500, BigDecimal.valueOf(50));
        Product product5 = new Product("Prod-6", 600, BigDecimal.valueOf(60));
        entityManager.persist(product);
        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.persist(product3);
        entityManager.persist(product4);
        entityManager.persist(product5);

        Customer customer = new Customer("Ivan", "mail@mail.com", "123456789ASD");
        Customer customer1 = new Customer("Alex", "mail@mail.com", "987654321ADS");
        Customer customer2 = new Customer("Maria", "mail@mail.com", "135792468DSA");
        entityManager.persist(customer);
        entityManager.persist(customer1);
        entityManager.persist(customer2);


        StoreLocation storeLocation = new StoreLocation("Billa");
        StoreLocation storeLocation1 = new StoreLocation("Lidl");
        entityManager.persist(storeLocation);
        entityManager.persist(storeLocation1);


        Sale sale = new Sale(product1, customer, storeLocation, LocalDateTime.now());
        Sale sale1 = new Sale(product2, customer1, storeLocation1, LocalDateTime.now());
        Sale sale2 = new Sale(product3, customer2, storeLocation, LocalDateTime.now());
        Sale sale3 = new Sale(product4, customer, storeLocation1, LocalDateTime.now());
        Sale sale4 = new Sale(product5, customer1, storeLocation, LocalDateTime.now());
        Sale sale5 = new Sale(product1, customer2, storeLocation1, LocalDateTime.now());
        Sale sale6 = new Sale(product1, customer, storeLocation, LocalDateTime.now());
        Sale sale7 = new Sale(product2, customer1, storeLocation1, LocalDateTime.now());
        Sale sale8 = new Sale(product2, customer1, storeLocation1, LocalDateTime.now());
        Sale sale9 = new Sale(product2, customer2, storeLocation1, LocalDateTime.now());

        entityManager.persist(sale);
        entityManager.persist(sale1);
        entityManager.persist(sale2);
        entityManager.persist(sale3);
        entityManager.persist(sale4);
        entityManager.persist(sale5);
        entityManager.persist(sale6);
        entityManager.persist(sale7);
        entityManager.persist(sale8);
        entityManager.persist(sale9);
    }
}
