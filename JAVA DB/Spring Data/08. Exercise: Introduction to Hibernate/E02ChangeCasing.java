import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class E02ChangeCasing
 {
    public static void main(String[] args) {
       final EntityManager entityManager = Connector.createEntityManager();
        entityManager.getTransaction().begin();

        List<Town> allTowns = entityManager.createQuery("FROM Town", Town.class).getResultList();


        for (Town town : allTowns) {
            if (town.getName().length() > 5) {
                entityManager.detach(town);
                continue;
            }
            town.setName(town.getName().toUpperCase());
            entityManager.persist(town);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
