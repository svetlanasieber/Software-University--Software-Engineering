package bg.softuni;

import bg.softuni.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("school-unit");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Student insert = new Student("Pesho");
        entityManager.persist(insert);

        Student found = entityManager.find(Student.class, 1L);

        System.out.println(found);

        List<Student> fromStudent = entityManager
                .createQuery("FROM Student", Student.class).getResultList();

        for (Student student : fromStudent) {
            System.out.println(student);
        }

        Student last = fromStudent.get(fromStudent.size() - 1);
        entityManager.remove(last);

        entityManager.getTransaction().commit();
    }
}