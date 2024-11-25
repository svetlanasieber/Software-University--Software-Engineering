package Hospital_04;

import Hospital_04.entities.Diagnose;
import Hospital_04.entities.Medicament;
import Hospital_04.entities.Patient;
import Hospital_04.entities.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main_04 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        insertData(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void insertData(EntityManager entityManager) {
        Medicament medicament1 = new Medicament("M-1");
        Medicament medicament2 = new Medicament("M-2");
        Medicament medicament3 = new Medicament("M-3");
        entityManager.persist(medicament1);
        entityManager.persist(medicament2);
        entityManager.persist(medicament3);

        Patient patient1 = new Patient("Patient-1", "PP-1", "Sofia", "mail@mail.bg", LocalDate.now(), "Picture-1", false);
        Patient patient2 = new Patient("Patient-2", "PP-2", "Pleven", "mail1@mail.bg", LocalDate.now(), "Picture-2", false);
        Patient patient3 = new Patient("Patient-3", "PP-3", "Burgas", "mail2@mail.bg", LocalDate.now(), "Picture-3", true);
        Patient patient4 = new Patient("Patient-4", "PP-4", "Pernik", "mail3@mail.bg", LocalDate.now(), "Picture-4", true);
        Patient patient5 = new Patient("Patient-5", "PP-5", "Plovdiv", "mail4@mail.bg", LocalDate.now(), "Picture-5", true);
        entityManager.persist(patient1);
        entityManager.persist(patient2);
        entityManager.persist(patient3);
        entityManager.persist(patient4);
        entityManager.persist(patient5);

        Diagnose diagnose1 = new Diagnose("DD-1", "High temperature");
        Diagnose diagnose2 = new Diagnose("DD-2", "Broken leg");
        Diagnose diagnose3 = new Diagnose("DD-3", "Dead");
        Diagnose diagnose4 = new Diagnose("DD-4", "Headache");
        Diagnose diagnose5 = new Diagnose("DD-5", "Red eyes");
        entityManager.persist(diagnose1);
        entityManager.persist(diagnose2);
        entityManager.persist(diagnose3);
        entityManager.persist(diagnose4);
        entityManager.persist(diagnose5);

        Visitation visitation1 = new Visitation(LocalDate.now(), "Dr. John", patient1, diagnose1, medicament1);
        Visitation visitation2 = new Visitation(LocalDate.now(), "Dr. John", patient2, diagnose2, medicament2);
        Visitation visitation3 = new Visitation(LocalDate.now(), "Dr. John", patient3, diagnose3, medicament3);
        Visitation visitation4 = new Visitation(LocalDate.now(), "Dr. John", patient4, diagnose4, medicament1);
        Visitation visitation5 = new Visitation(LocalDate.now(), "Dr. John", patient5, diagnose5, medicament1);
        Visitation visitation6 = new Visitation(LocalDate.now(), "Dr. John", patient1, diagnose2, medicament2);
        Visitation visitation7 = new Visitation(LocalDate.now(), "Dr. John", patient1, diagnose3, medicament3);
        Visitation visitation8 = new Visitation(LocalDate.now(), "Dr. John", patient2, diagnose3, medicament3);
        Visitation visitation9 = new Visitation(LocalDate.now(), "Dr. John", patient2, diagnose4, medicament1);
        Visitation visitation10 = new Visitation(LocalDate.now(), "Dr. John", patient2, diagnose5, medicament1);
        entityManager.persist(visitation1);
        entityManager.persist(visitation2);
        entityManager.persist(visitation3);
        entityManager.persist(visitation4);
        entityManager.persist(visitation5);
        entityManager.persist(visitation6);
        entityManager.persist(visitation7);
        entityManager.persist(visitation8);
        entityManager.persist(visitation9);
        entityManager.persist(visitation10);
    }
}
