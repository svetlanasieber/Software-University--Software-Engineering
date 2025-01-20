package scubaDive;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivingTests {
    private Diving diving;
    private DeepWaterDiver diver;
    @Before
    public void setUp(){

        diving = new Diving("Maldiven",2);
        diver = new DeepWaterDiver("Monika",1000);
        diving.addDeepWaterDiver(diver);
    }
    @Test
    public void testGetCorrectDiveCount(){

        int expected = 1;
        int actual  = diving.getCount();
        assertEquals(expected,actual);

    }

    @Test
    public void getCorrectDiversSideName(){

        String expected = "Maldiven";
        String actual = diving.getName();

        assertEquals(expected,actual);

    }
    @Test
    public void testGetCapacity(){
        int expected = 2;
        int actual = diving.getCapacity();
        assertEquals(expected,actual);

    }
    @Test
    public void testTryAddDiverWhenEnoughCapacity(){
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("Bobi",1000);
        diving.addDeepWaterDiver(deepWaterDiver1);
        int expected = 2;
        int actual = diving.getCount();
        assertEquals(expected,actual);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddDiverWhitNoCapacityShouldThrow(){
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("Bobi",10000);
        DeepWaterDiver deepWaterDiver2 = new DeepWaterDiver("Iliyan",10000);
        DeepWaterDiver deepWaterDiver3 = new DeepWaterDiver("Iliyana",10000);
        diving.addDeepWaterDiver(deepWaterDiver1);
        diving.addDeepWaterDiver(deepWaterDiver2);
        diving.addDeepWaterDiver(deepWaterDiver3);


    }
    @Test(expected = IllegalArgumentException.class)
    public void testTryToAddDiverWhoAlreadyExists(){
        diving.addDeepWaterDiver(new DeepWaterDiver("Monika",1000));

    }

    @Test
    public void testRemoveDiver(){

       assertTrue(diving.removeDeepWaterDiver("Monika"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTryToSetNegativeCapacityShouldThrow(){
        Diving diving1 = new Diving("Seyshels", -1);

    }
    @Test(expected = NullPointerException.class)
    public void testSetNullNameShouldThrow(){

        Diving diving1  = new Diving(null,2);

    }


}
