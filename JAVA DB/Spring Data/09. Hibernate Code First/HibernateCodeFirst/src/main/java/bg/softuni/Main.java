package bg.softuni;

import bg.softuni.HasEntities.Article;
import bg.softuni.HasEntities.PlateNumber;
import bg.softuni.HasEntities.Truck;
import bg.softuni.HasEntities.User;
import bg.softuni.entities.Bike;
import bg.softuni.entities.Car;
import bg.softuni.entities.Plane;
import bg.softuni.entities.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("relations");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

       /* Vehicle car = new Car("Octavia", "Petrol", 5);
        Vehicle bike = new Bike();
        Vehicle plane = new Plane("Airbus", "Kerosene", 200);

        PlateNumber number = new PlateNumber("123");
        Truck truck1 = new Truck(number);
        Truck truck2 = new Truck(number);

        entityManager.persist(car);
        entityManager.persist(bike);
        entityManager.persist(plane);

        entityManager.persist(number);

        entityManager.persist(truck1);
        entityManager.persist(truck2);


        Car fromDB = entityManager.find(Car.class, 1L);

        System.out.println(fromDB.getModel() + "-" + fromDB.getFuelType() + "-" + fromDB.getSeats());
*/

        Article article = new Article("alabala");
        User author = new User("Toshko");

        author.addArticle(article);
        article.setAuthor(author);
        entityManager.persist(author);

        User user = entityManager.find(User.class, 1);

        System.out.println(user);


        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
