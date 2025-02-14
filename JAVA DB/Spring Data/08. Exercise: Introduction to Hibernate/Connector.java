import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Connector {
    static EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
    }
}
