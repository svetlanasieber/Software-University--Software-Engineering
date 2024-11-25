package bg.softuni;

import bg.softuni.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();

        Student insert = new Student();
        insert.setName("Hiber");

        currentSession.persist(insert);

        Student get = currentSession.get(Student.class, 1);
        System.out.println(get);

        List<Student> fromStudent =
                currentSession.createQuery("FROM Student", Student.class).list();

        for (Student student : fromStudent) {
            System.out.println(student);
        }

        currentSession.getTransaction().commit();
        currentSession.close();
    }

}