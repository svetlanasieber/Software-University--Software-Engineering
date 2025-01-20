package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {
    private House house;
    private Cat cat;
    @Before
    public void setUp(){
        house = new House("Stark",10);
        cat = new Cat("Monka");

    }

    @Test(expected = NullPointerException.class)
public void testSetNullHouseNameShouldThrow(){
        house = new House(null,1);

    }   @Test(expected = NullPointerException.class)
public void testSetWhitespaceHouseNameShouldThrow(){
        house = new House("     ",1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeCapacityShouldThrow(){

        house = new House("Bolton",-1);


    }
    @Test
    public void testGetCapacity(){
        house.addCat(cat);
        int expected = 10;
        int actual = house.getCapacity();
        assertEquals(expected,actual);

    }

    @Test
    public void testGetName(){
        String expected = "Stark";
        String actual = house.getName();
        assertEquals(expected,actual);

    }

    @Test
    public void testGetCount(){
        house.addCat(cat);

        int expected = 1;
        int actual = house.getCount();

        assertEquals(expected,actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatWhitNoCapacityShouldThrow(){
        house = new House("Bolton",1);

        house.addCat(cat);
        house.addCat(new Cat("Bona"));

    }
    @Test
    public void testRemoveCat(){
        house.addCat(cat);
        house.addCat(new Cat("Pisi"));
        house.removeCat("Pisi");
        int expected = 1;
        int actual = house.getCount();
        assertEquals(expected,actual);


    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatShouldThrow(){
        house.addCat(cat);
        house.removeCat("Pisi");

    }
    @Test
    public void testPutCatForSale(){
        house.addCat(cat);
        house.catForSale("Monka");

        assertFalse(cat.isHungry());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleShouldThrow(){
        house.addCat(cat);
        house.catForSale("Pisi");
        cat.setHungry(false);


    }
    @Test
    public void testStatistics(){
        house.addCat(cat);
        String expected = "The cat Monka is in the house Stark!";
        String actual = house.statistics();

        assertEquals(expected,actual);

    }



}
