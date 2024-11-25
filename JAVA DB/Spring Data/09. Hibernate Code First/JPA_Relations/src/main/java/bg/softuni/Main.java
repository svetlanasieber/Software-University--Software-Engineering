package bg.softuni;

import bg.softuni.entities.composition.Batch;
import bg.softuni.entities.composition.Ingredient;
import bg.softuni.entities.composition.Label;
import bg.softuni.entities.composition.Shampoo;
import bg.softuni.entities.vehicles.Bike;
import bg.softuni.entities.vehicles.Car;
import bg.softuni.entities.vehicles.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa-relations");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Bike bike = new Bike();
        bike.setWheelSize(26);

        Car car = new Car();
        car.setPaintCode("red");

        entityManager.persist(bike);
        entityManager.persist(car);

        List<Vehicle> vehicles = List.of(bike, car);

        persistShampoo(entityManager);

        Shampoo shampoo = entityManager.find(Shampoo.class, 1L);

        System.out.println(shampoo.getBatch().getSerial());

//        System.out.println(label.getShampoo());

//        Label label1 = entityManager.find(Label.class, 1);
//        label1.setShampoo(shampoo2);

//        Batch batch = new Batch();
//        Collections.unmodifiableSet()
//        batch.getShampoo().add(new Shampoo());
//        batch.getShampoo().get(0).setBrand("");

        entityManager.getTransaction().commit();
        entityManager.close();

        // LazyInit Exception
//        System.out.println(shampoo.getIngredients().get(0).getName());
    }

    private static void persistShampoo(EntityManager entityManager) {
        Shampoo shampoo = new Shampoo();

        Label label = new Label();
        label.setTitle("Primary label");

        Batch batch = new Batch();
        batch.setSerial("1x-snan-bnff");

        Batch batch2 = new Batch();
        batch2.setSerial("22-snan-bnff");

        Ingredient ing = new Ingredient();
        ing.setName("Lavender");
        Ingredient ing2 = new Ingredient();
        ing2.setName("Salt");

        shampoo.setLabel(label);
//        shampoo.setBatch(batch);
        shampoo.setIngredients(List.of(ing, ing2));

        batch.addShampoo(shampoo);
        batch2.addShampoo(shampoo);

        entityManager.persist(label);
        entityManager.persist(shampoo);
        entityManager.persist(batch);
        entityManager.persist(batch2);
        entityManager.persist(ing);
        entityManager.persist(ing2);

    }
}