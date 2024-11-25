import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Contains_Employee_03 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String[] searchedFor = scanner.nextLine().split("\\s+");

        Long employeeCount = entityManager.createQuery(
                        "SELECT COUNT(e)" +
                                " FROM Employee e" +
                                " WHERE" +
                                " e.firstName = :first_name AND" +
                                " e.lastName = :last_name", Long.class)
                .setParameter("first_name", searchedFor[0])
                .setParameter("last_name", searchedFor[1])
                .getSingleResult();

        if (employeeCount > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
