import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Adding_A_New_Address_And_Updating_Employee_06 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String addressText = "Vitoshka 15";

        Town town = new Town();
        town.setName("Denis town");
        entityManager.persist(town);

        Address address = new Address();
        address.setText(addressText);
        address.setTown(town);
        entityManager.persist(address);

        String lastName = scanner.nextLine();
        Employee employee = findEmployee(entityManager, lastName);
        printEmployeeData(employee);

        entityManager.createQuery(
                        "UPDATE Employee e" +
                                " SET e.address = :address" +
                                " WHERE e.lastName = :name")
                .setParameter("address", address)
                .setParameter("name", lastName)
                .executeUpdate();

        System.out.printf("%n%n");
        
        entityManager.refresh(employee);
        employee = findEmployee(entityManager, lastName);
        printEmployeeData(employee);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static Employee findEmployee(EntityManager entityManager, String lastName) {
        return entityManager.createQuery("SELECT e FROM Employee e" +
                        " WHERE lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getSingleResult();
    }

    private static void printEmployeeData(Employee employee) {
        System.out.printf("EmployeeId - %d%n" +
                        "First_name - %s%n" +
                        "Last_name - %s%n" +
                        "AddressId - %d%n" +
                        "Address_name - %s%n" +
                        "TownId - %d%n" +
                        "Town_name - %s",
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getAddress().getId(),
                employee.getAddress().getText(),
                employee.getAddress().getTown().getId(),
                employee.getAddress().getTown().getName());
    }
}
