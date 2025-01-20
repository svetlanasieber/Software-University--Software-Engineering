package stuntClimb;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClimbingTests {
    private Climbing climbing;
    private RockClimber rockClimber;

    @Before
    public void setUp(){
        climbing = new Climbing("Rila",1);
        rockClimber = new RockClimber("Monika",3);
        climbing.addRockClimber(rockClimber);

    }

    @Test
    public void testGetCorrectCount(){

        assertEquals(1,climbing.getCount());
    }

    @Test
    public void testGetClimbingName(){
        assertEquals("Rila",climbing.getName());
    }
    @Test
    public void testGetCapacityClimbing(){

        assertEquals(1,climbing.getCapacity());

    }
    @Test
    public void testAddRockClimberWhitValidCapacity(){
        Climbing climbing1 = new Climbing("Pirin",1);

        climbing1.addRockClimber(rockClimber);

        assertEquals(1,climbing.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRockClimberWhitNoCapacity(){
        climbing.addRockClimber(new RockClimber("Ivo",2));

    }
    @Test(expected = IllegalArgumentException.class)
    public void testTryToAddRockClimberWhoExists(){
        climbing.addRockClimber(new RockClimber("Monika",3));

        assertEquals(1,climbing.getCount());
    }

    @Test
    public void testRemoveClimber(){

        assertTrue(climbing.removeRockClimber("Monika"));

    }
    @Test
    public void  testRemove(){
        climbing.removeRockClimber("Monika");
        assertEquals(0,climbing.getCount());

    }

    @Test
    public void testSetCapacity(){
        Climbing climbing1  =new Climbing("Vitosha",2);

        assertEquals(2,climbing1.getCapacity());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeCapacity(){

        climbing = new Climbing("Rila",-1);

    }

    @Test
    public void testSetValidName(){
        climbing = new Climbing("Strandja",2);

        assertEquals("Strandja",climbing.getName());

    }
    @Test(expected = NullPointerException.class)
    public void testSetNullName (){

        climbing  = new Climbing(null,3);
    }

}
