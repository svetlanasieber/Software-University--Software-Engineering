package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FarmvilleTests {

    private Farm farm;
    private Animal animal;
   @Before
    public void setUp(){
       farm = new Farm("Farm",2);
       animal = new Animal("Cow",12.2);

   }
   @Test
   public void testGetName(){
       String expected = "Farm";
       String actual = farm.getName();
       assertEquals(expected,actual);

   }
   @Test
    public void testAddAnimal(){
       farm.add(animal);
       int expected = 1;
       int actual = farm.getCount();

       assertEquals(expected,actual);

   }
   @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalShouldThrow(){
       farm.add(animal);
       farm.add(new Animal("Goat",12.23));
       farm.add(new Animal("Sheep",123.2));

   }
   @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalThatExistsShouldThrow(){
       farm.add(animal);
       farm.add(animal);

   }

   @Test
    public void testRemoveAnimal(){
       farm.add(animal);
       assertTrue(farm.remove("Cow"));

   }
   @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeCapacityShouldThrow(){
       farm = new Farm("Farm2",-2);

   }
   @Test(expected = NullPointerException.class)
    public void testSetNullNameShouldThrow(){
       farm = new Farm(null,2);

   }
   @Test(expected = NullPointerException.class)
    public void testSetWhitespaceNameShouldThrow(){
       farm = new Farm("   ",12);

   }



}
