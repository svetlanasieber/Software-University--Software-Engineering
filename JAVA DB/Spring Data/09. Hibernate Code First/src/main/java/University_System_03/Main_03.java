package University_System_03;

import University_System_03.entities.Course;
import University_System_03.entities.Student;
import University_System_03.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main_03 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        insertData(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void insertData(EntityManager entityManager) {
        Teacher teacher1 = new Teacher("Teacher-1", "TT-1", "0987654321", "mail1@mail.com", 15.49f);
        Teacher teacher2 = new Teacher("Teacher-2", "TT-2", "0987654331", "mail2@mail.com", 16.49f);
        Teacher teacher3 = new Teacher("Teacher-3", "TT-3", "0987654341", "mail3@mail.com", 17.49f);
        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        entityManager.persist(teacher3);

        Course course1 = new Course("Java", "We love Java", LocalDate.now(), LocalDate.now(), 50, teacher1);
        Course course2 = new Course("JS", "We love JS", LocalDate.now(), LocalDate.now(), 10, teacher2);
        Course course3 = new Course("C++", "We love Java", LocalDate.now(), LocalDate.now(), 100, teacher3);
        Course course4 = new Course("Python", "We love Python", LocalDate.now(), LocalDate.now(), 100, teacher3);
        Course course5 = new Course("HTML", "We love HTML", LocalDate.now(), LocalDate.now(), 100, teacher3);
        entityManager.persist(course1);
        entityManager.persist(course2);
        entityManager.persist(course3);
        entityManager.persist(course4);
        entityManager.persist(course5);

        Student student1 = new Student("Student-1", "SS-1", "1234567890", 4.50, 10);
        Student student2 = new Student("Student-2", "SS-2", "0987654321", 5.50, 15);
        Student student3 = new Student("Student-3", "SS-3", "1357924680", 6.00, 20);
        Student student4 = new Student("Student-4", "SS-4", "1472583690", 4.55, 25);
        Student student5 = new Student("Student-5", "SS-5", "3692581470", 5.55, 30);
        Student student6 = new Student("Student-6", "SS-6", "15975384260", 6.00, 35);
        Student student7 = new Student("Student-7", "SS-7", "2581470369", 4.40, 40);
        Student student8 = new Student("Student-8", "SS-8", "03579518624", 5.40, 45);
        Student student9 = new Student("Student-9", "SS-9", "1245789630", 4.30, 50);
        Student student10 = new Student("Student-10", "SS-10", "0123456789", 5.30, 55);
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
        entityManager.persist(student5);
        entityManager.persist(student6);
        entityManager.persist(student7);
        entityManager.persist(student8);
        entityManager.persist(student9);
        entityManager.persist(student10);

        student1.addCourses(course1);
        student2.addCourses(course2);
        student3.addCourses(course3);
        student4.addCourses(course4);
        student5.addCourses(course5);
        student6.addCourses(course5);
        student7.addCourses(course5);
        student8.addCourses(course5);
        student9.addCourses(course5);
        student10.addCourses(course5);
        student1.addCourses(course2);
        student1.addCourses(course3);
        student2.addCourses(course4);
        student2.addCourses(course5);
    }
}
