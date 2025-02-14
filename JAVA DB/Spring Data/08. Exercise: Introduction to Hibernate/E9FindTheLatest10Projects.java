import entities.Project;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;

public class E9FindTheLatest10Projects {
    public static void main(String[] args) {
        Connector.createEntityManager()
                .createQuery("FROM Project ORDER BY startDate DESC, name", Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(Project::printGeneralInformation);
    }
}