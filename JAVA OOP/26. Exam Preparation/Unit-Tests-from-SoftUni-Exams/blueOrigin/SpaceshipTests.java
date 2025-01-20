package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpaceshipTests {
    private Spaceship spaceship;
    private Astronaut astronaut;
    @Before
    public void setUp(){
        spaceship =  new Spaceship("Spaceship",2);
        astronaut = new Astronaut("Astronaut",12.2);
    }


    @Test
    public void testAddAstronaut(){
        spaceship.add(astronaut);
        int expected = 1;
        int actual = spaceship.getCount();
        assertEquals(expected,actual);


    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhitNotEnoughCapacityShouldThrow(){
        spaceship.add(astronaut);
        spaceship.add(new Astronaut("Astonaut2",11.0));
        spaceship.add(new Astronaut("Astonaut3",11.0));


    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhoExists(){
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }
    @Test
    public void testGetName(){

        String expected = "Spaceship";
        String actual = spaceship.getName();
        assertEquals(expected,actual);
    }
    @Test
    public void testRemoveAstronaut(){
        spaceship.add(astronaut);
        assertTrue(spaceship.remove("Astronaut"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeCapacity(){
        spaceship = new Spaceship("Space",-1);

    }
    @Test(expected = NullPointerException.class)
    public void testSetNullNameShouldThrow(){
        spaceship = new Spaceship(null,123);

    }@Test(expected = NullPointerException.class)
    public void testSetWhitespaceShouldThrow(){
        spaceship = new Spaceship("    ",123);

    }


}
