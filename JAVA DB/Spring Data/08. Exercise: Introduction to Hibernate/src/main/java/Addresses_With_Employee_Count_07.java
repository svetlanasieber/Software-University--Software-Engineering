import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Addresses_With_Employee_Count_07 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        int limit = 10;
        entityManager.createQuery(
                        "SELECT a FROM Address a" +
                                " ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(limit)
                .getResultStream()
                .forEach(address -> {
                    String out = String.format("%s, %s - %d employees",
                            address.getText(),
                            address.getTown().getName(),
                            address.getEmployees().size());
                    System.out.println(out);
                });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
