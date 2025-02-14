import entities.Patient;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class DoctorConsoleUI {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hospital");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        while (true) {
            System.out.println("==== Doctor's Console ====");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Update Patient Information");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewPatient();
                    break;
                case 2:
                    viewAllPatients();
                    break;
                case 3:
                    updatePatient();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    entityManager.close();
                    entityManagerFactory.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewPatient() {
        System.out.println("Enter patient details:");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Date of Birth (yyyy-mm-dd): ");
        String dateOfBirthStr = scanner.nextLine();
        System.out.print("Has Insurance (true/false): ");
        boolean hasInsurance = scanner.nextBoolean();

        try {
            entityManager.getTransaction().begin();

            Patient patient = new Patient();
            patient.setFirstName(firstName);
            patient.setLastName(lastName);
            patient.setAddress(address);
            patient.setEmail(email);
            patient.setDateOfBirth(java.sql.Date.valueOf(dateOfBirthStr));
            patient.setHasInsurance(hasInsurance);

            entityManager.persist(patient);
            entityManager.getTransaction().commit();

            System.out.println("Patient added successfully!");
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Error adding patient: " + e.getMessage());
        }
    }

    private static void viewAllPatients() {
        try {
            TypedQuery<Patient> query = entityManager.createQuery("SELECT p FROM Patient p", Patient.class);
            List<Patient> patients = query.getResultList();

            System.out.println("All Patients:");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        } catch (Exception e) {
            System.err.println("Error viewing patients: " + e.getMessage());
        }
    }

    private static void updatePatient() {
        System.out.print("Enter Patient ID to update: ");
        long patientId = scanner.nextLong();
        scanner.nextLine();

        try {
            entityManager.getTransaction().begin();

            Patient patient = entityManager.find(Patient.class, patientId);
            if (patient == null) {
                System.out.println("Patient not found.");
                return;
            }

            System.out.println("Update patient details:");
            System.out.print("First Name: ");
            patient.setFirstName(scanner.nextLine());
            System.out.print("Last Name: ");
            patient.setLastName(scanner.nextLine());
            System.out.print("Address: ");
            patient.setAddress(scanner.nextLine());
            System.out.print("Email: ");
            patient.setEmail(scanner.nextLine());
            System.out.print("Date of Birth (yyyy-mm-dd): ");
            patient.setDateOfBirth(java.sql.Date.valueOf(scanner.nextLine()));
            System.out.print("Has Insurance (true/false): ");
            patient.setHasInsurance(scanner.nextBoolean());

            entityManager.merge(patient);
            entityManager.getTransaction().commit();

            System.out.println("Patient updated successfully!");
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Error updating patient: " + e.getMessage());
        }
    }

    private static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        long patientId = scanner.nextLong();
        scanner.nextLine();

        try {
            entityManager.getTransaction().begin();

            Patient patient = entityManager.find(Patient.class, patientId);
            if (patient == null) {
                System.out.println("Patient not found.");
                return;
            }

            entityManager.remove(patient);
            entityManager.getTransaction().commit();

            System.out.println("Patient deleted successfully!");
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Error deleting patient: " + e.getMessage());
        }
    }
}