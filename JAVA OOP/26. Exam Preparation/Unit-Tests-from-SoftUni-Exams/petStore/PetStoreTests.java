package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PetStoreTests {
    private PetStore petStore;
    private Animal animal;

    @Before
    public void setUp() {
        petStore = new PetStore();
        animal = new Animal("Dog", 60, 100.0);

    }

    @Test
    public void findAnimalBySpecie() {
        Animal animal1 = new Animal("Horse", 500, 12000);
        Animal animal2 = new Animal("Lizard", 1, 123);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal);
        List<Animal> expected = new ArrayList<>(Collections.singletonList(animal1));
        List<Animal> actual = petStore.findAllAnimalBySpecie("Horse");

        assertEquals(expected,actual);
    }


    @Test
    public void testAddAnimalToPetStore() {
        petStore.addAnimal(animal);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalToPetStoreWhitInvalidNameShouldThrow() {

        petStore.addAnimal(null);

    }


    @Test
    public void testGetAnimals() {
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("Cat", 2, 1));
        petStore.addAnimal(new Animal("Cat", 3, 3));
        List<Animal> expectedAnimals = new ArrayList<>(petStore.getAnimals());
        assertEquals(expectedAnimals, petStore.getAnimals());

    }

    @Test
    public void testGetAnimalCount() {
        petStore.addAnimal(animal);

        petStore.addAnimal(new Animal("Dog", 15, 12.0));

        int expected = 2;
        int actual = petStore.getCount();
        assertEquals(expected, actual);

    }

    @Test
    public void testGetMaxKilogramAnimal() {
        petStore.addAnimal(animal);
        Animal animal1 = new Animal("Horse", 500, 12000);
        Animal animal2 = new Animal("GoldFish", 1, 10);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);


        List<Animal> expectedAnimal = new ArrayList<>(Arrays.asList(animal, animal1));
        List<Animal> actual = petStore.findAllAnimalsWithMaxKilograms(10);
        assertEquals(expectedAnimal, actual);


    }

    @Test
    public void testGetMostExpensiveAnimal() {
        petStore.addAnimal(animal);
        Animal animal1 = new Animal("Horse", 500, 12000);
        Animal animal2 = new Animal("GoldFish", 1, 10);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);

    Animal actual =  petStore.getTheMostExpensiveAnimal();
        assertEquals(animal1, actual);


    }





}

