import entities.Town;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Change_Casing_02 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Town> resultList = entityManager.createQuery("SELECT t FROM Town t", Town.class).getResultList();
        for (Town town : resultList) {
            String name = town.getName();
            if (name.length() <= 5) {
                String toUpper = name.toUpperCase();
                town.setName(toUpper);
                entityManager.persist(town);
                System.out.println(town.getName());
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
