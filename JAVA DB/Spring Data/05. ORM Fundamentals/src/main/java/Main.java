import entities.Student;
import entities.User;
import orm.Connector;
import orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Connector.createConnection("root", "1234", "soft_uni");

        Connection connection = Connector.getConnection();

        EntityManager<User> userEntityManager = new EntityManager<>(connection);
       /* User user = new User("First", 28, LocalDate.now());
        userEntityManager.persist(user);

        */
        EntityManager<Student> studentEntityManager = new EntityManager<>(connection);
        /*Student student = new Student("name");
        studentEntityManager.persist(student);*/

        User first = userEntityManager.findFirst(User.class);

        System.out.println(first.getId() + " " + first.getUsername());

        Student first1 = studentEntityManager.findFirst(Student.class, "name = 'name2'");

        System.out.println(first1.getId() + " " + first1.getName());

       userEntityManager.find(User.class, "age > 18 AND registration_date > '2022-06-06'")
               .forEach(u -> System.out.println(u.toString()));

    }
}
