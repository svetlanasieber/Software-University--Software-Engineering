package Bills_Payment_System_05;

import Bills_Payment_System_05.entities.BankAccount;
import Bills_Payment_System_05.entities.BillingDetail;
import Bills_Payment_System_05.entities.CreditCard;
import Bills_Payment_System_05.entities.User;
import Bills_Payment_System_05.enums.BillingDetailType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main_05 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        insertData(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void insertData(EntityManager entityManager) {
        User user1 = new User("First-1", "Last-1", "mail1@mail.bg", "0123456789");
        User user2 = new User("First-2", "Last-2", "mail2@mail.bg", "9876543210");
        User user3 = new User("First-3", "Last-3", "mail3@mail.bg", "1357924680");
        User user4 = new User("First-4", "Last-4", "mail4@mail.bg", "2468013579");
        User user5 = new User("First-5", "Last-5", "mail5@mail.bg", "0246813579");
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.persist(user4);
        entityManager.persist(user5);


        BankAccount bankAccount1 = new BankAccount(123456789, user1, "B-1","Bank-1");
        BankAccount bankAccount2 = new BankAccount(987654321, user2, "B-2","Bank-2");
        BankAccount bankAccount3 = new BankAccount(135792468, user3, "B-3","Bank-3");
        entityManager.persist(bankAccount1);
        entityManager.persist(bankAccount2);
        entityManager.persist(bankAccount3);

        CreditCard creditCard1 = new CreditCard(147258369, user4, "Card-1", "June", "2022");
        CreditCard creditCard2 = new CreditCard(963852741, user5, "Card-2", "July", "2023");
        entityManager.persist(creditCard1);
        entityManager.persist(creditCard2);
    }
}
