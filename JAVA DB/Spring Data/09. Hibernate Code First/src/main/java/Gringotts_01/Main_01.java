package Gringotts_01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

public class Main_01 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        WizardDeposits wizard = new WizardDeposits(
                "Gandalf",
                "The White",
                "Can kill anyone",
                55,
                "Denis",
                (short) 11,
                "Camelot",
                LocalDateTime.now(),
                BigDecimal.valueOf(5000.00),
                BigDecimal.valueOf(5.95),
                BigDecimal.valueOf(59.99),
                LocalDateTime.of(2022, Month.DECEMBER, 12, 21, 24, 37)
        );

        entityManager.persist(wizard);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
