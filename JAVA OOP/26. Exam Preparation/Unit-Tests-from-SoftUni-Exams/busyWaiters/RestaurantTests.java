package busyWaiters;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RestaurantTests {
    private Restaurant restaurant;
    private FullTimeWaiter fullTimeWaiter;
    @Before
public void setUp(){
restaurant = new Restaurant("Radici",2);
fullTimeWaiter = new FullTimeWaiter("Murku",3);

    }
    @Test
    public void testAddFullTimeWaiter(){
        restaurant.addFullTimeWaiter(fullTimeWaiter);
        int expected = 1;
        int actual = restaurant.getCount();
        assertEquals(expected,actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWaiterWhitSameNameShouldThrow(){
        restaurant.addFullTimeWaiter(fullTimeWaiter);
        restaurant.addFullTimeWaiter(fullTimeWaiter);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddWaiterWhitNotEnoughCapacityShouldThrow(){
        restaurant.addFullTimeWaiter(fullTimeWaiter);
        restaurant.addFullTimeWaiter(new FullTimeWaiter("Second",3));
        restaurant.addFullTimeWaiter(new FullTimeWaiter("Third",6));

    }
    @Test
    public void removeWaiter(){
        restaurant.addFullTimeWaiter(fullTimeWaiter);
        assertTrue(restaurant.removeFullTimeWaiter("Murku"));

    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeCapacityShouldThrow(){
        restaurant = new Restaurant("Rest",-1);

    }
    @Test(expected = NullPointerException.class)
    public void testSetNullNameShouldThrow(){
        restaurant = new Restaurant(null,3);

    }
      @Test(expected = NullPointerException.class)
    public void testSetWhitespaceNameShouldThrow(){
        restaurant = new Restaurant("    ",3);

    }



}
