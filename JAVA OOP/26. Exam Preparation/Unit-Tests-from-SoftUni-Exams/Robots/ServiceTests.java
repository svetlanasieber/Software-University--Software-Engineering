package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class ServiceTests {
    private static final int CAPACITY = 1;
    private Service service;
    private Robot roboter;


    @Before
    public void setUp() {

        roboter = new Robot("Ivo");
        service = new Service("Karchev", CAPACITY);
        service.add(roboter);
    }

    @Test
    public void testGetName(){
       assertEquals("Karchev",service.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetServiceNameWhitNull() throws NullPointerException {
  service = new Service(null, CAPACITY);

    }

    @Test(expected = NullPointerException.class)
    public void testSetServiceNameWhitespace() {
       service = new Service(" ", CAPACITY);
    }

    @Test
    public void testGetCapacity() {

        assertEquals(CAPACITY, service.getCapacity());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeCapacity(){
        service = new Service("Ivo",-1);

    }
    @Test
    public void testGetRobotCount(){
        assertEquals(1,service.getCount());

    }
    @Test(expected =  IllegalArgumentException.class)
    public void testAddRobotToCollectionWhitNotEnoughCapacity() throws IllegalArgumentException{

        Robot robot1 = new Robot("Krak");
     service.add(robot1);

    }
    @Test
    public void testRemoveRobotFromService(){
        service.remove("Ivo");
    assertEquals(0,service.getCount());
    }
@Test(expected = IllegalArgumentException.class)
    public void testTryToRemoveNotExistingRobot(){
        service.remove("Krak");
}
@Test
    public void testRobotForSale(){
        service.forSale("Ivo");
        assertFalse(roboter.isReadyForSale());
}
@Test(expected = IllegalArgumentException.class)
    public void testTryToSellInvalidRobot(){
        service.forSale("Bobi");
}
@Test
    public void testReport(){
        assertEquals(String.format("The robot %s is in the service %s!", "Ivo", "Karchev"),service.report());
}

}
