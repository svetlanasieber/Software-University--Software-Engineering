import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;


public class P09_FindLatest10Projects {

    final private static String SELECT_STARTED_PROJECTS = "select p from Project p order by p.startDate desc ";

    public static void main(String[] args) {



        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constant.DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        final List<Project> sortedProjects = entityManager.createQuery(SELECT_STARTED_PROJECTS, Project.class)
                .setMaxResults(10)
                .getResultList().stream()
                .sorted(Comparator.comparing(Project::getName)).toList();

        sortedProjects.forEach(p ->{
            System.out.print("Project name: " + p.getName() + System.lineSeparator() +
                            "\tProject Description: " + p.getDescription() + System.lineSeparator() +
                            "\tProject Start Date:" + p.getStartDate().minusHours(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")) + System.lineSeparator() +
                            "\tProject End Date: " + p.getEndDate() + System.lineSeparator());


        });


        entityManager.getTransaction().commit();
        entityManager.close();

    }
    
    
}
