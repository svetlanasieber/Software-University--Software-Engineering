import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Remove_Towns_13 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();

        Town town = entityManager.createQuery(
                        "SELECT t FROM Town t" +
                                " WHERE t.name = :townName", Town.class)
                .setParameter("townName", townName)
                .getSingleResult();

        List<Address> addresses = entityManager.createQuery(
                        "SELECT a FROM Address a" +
                                " WHERE a.town.name = :townName", Address.class)
                .setParameter("townName", townName)
                .getResultList();

        String output = String.format("%d address%s in %s deleted%n",
                addresses.size(),
                (addresses.size() != 1) ? "es" : "",
                town.getName());

        addresses.forEach(a -> {
            for (Employee employee : a.getEmployees()) {
                employee.setAddress(null);
            }
            a.setTown(null);
            entityManager.remove(a);
        });

        entityManager.remove(town);
        entityManager.getTransaction().commit();

        System.out.println(output);

        entityManager.close();
    }
}
