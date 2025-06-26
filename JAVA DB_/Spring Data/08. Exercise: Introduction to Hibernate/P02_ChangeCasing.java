import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class P02_ChangeCasing {

    private static final String SELECT_NAMES = "select t from Town t where length(t.name) <= 5";

    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constant.DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        final Query query = entityManager.createQuery(SELECT_NAMES, Town.class);

        final List<Town> towns = query.getResultList();

        towns.forEach(t -> t.setName(t.getName().toUpperCase()));


        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
