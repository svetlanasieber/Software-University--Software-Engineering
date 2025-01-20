package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExcavationTests {

    private Excavation excavation;
    private Archaeologist archaeologist;

    @Before
    public void setUp(){
        excavation = new Excavation("Plains",2);
        archaeologist = new Archaeologist("Liliya",12.0);
    }
    @Test
    public void testConstructorExcavation(){
        excavation = new Excavation("Pirin",2);
        excavation.addArchaeologist(archaeologist);

        int expectedCountArcheologists =1;
        int actualCountArcheologists = excavation.getCount();

        assertEquals(expectedCountArcheologists,actualCountArcheologists);

        String expectedName = "Pirin";
        String actualName = excavation.getName();

        assertEquals(expectedName,actualName);

        int expectedCapacity = 2;
        int actualCapacity = excavation.getCapacity();
        assertEquals(expectedCapacity,actualCapacity);

    }
    @Test(expected = NullPointerException.class)
    public void testSetNullNameShouldThrow(){

        excavation = new Excavation(null,2);
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameWhitespaceShouldThrow(){

        excavation = new Excavation("     ",2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeCapacity(){
        excavation = new Excavation("Test",-1);

    }
    @Test
    public void testRemoveArcheologist(){
        excavation.addArchaeologist(archaeologist);
       assertTrue (excavation.removeArchaeologist("Liliya"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTryToAddArcheologistWhitNoCapacityShouldThrow(){
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(new Archaeologist("TestPerson",1.1));
        excavation.addArchaeologist(new Archaeologist("TestPersonTwo",1.3));

    }
    @Test(expected = IllegalArgumentException.class)
    public void testTryToAddExistingArcheologist(){
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(new Archaeologist("Liliya",12.0));
    }


}
