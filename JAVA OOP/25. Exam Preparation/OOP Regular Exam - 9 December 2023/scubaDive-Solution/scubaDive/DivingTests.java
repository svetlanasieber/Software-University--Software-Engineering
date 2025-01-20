package scubaDive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivingTests {

    private Diving diving;
    private DeepWaterDiver diver;

    @BeforeEach
    public void setUp() {
        diving = new Diving("SeaAdventure", 5);
        diver = new DeepWaterDiver("Elijah", 90);
    }

    @Test
    public void constructor_ShouldSetSuccessfullyValues() {

        String expectedName = "SeaAdventure";
        int expectedCapacity = 5;

        String actualName = diving.getName();
        int actualCapacity = diving.getCapacity();

        Assertions.assertEquals(expectedCapacity, actualCapacity);
        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    public void constructor_ShouldThrowArgumentNullExceptionForInvalidName() {

        Assertions.assertThrows(NullPointerException.class, () -> {
            new Diving(null, 10);
        });


    }

    @Test
    public void constructor_ShouldThrowArgumentExceptionForInvalidCapacity() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Diving("SeaAdventure", -10);
        });

    }

    @Test
    public void addMethod_ShouldThrowsExceptionForInvalidCapacity() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Diving diving1 = new Diving("Lake", 0);
            diving1.addDeepWaterDiver(diver);
        });
    }

    @Test
    public void removeMethod_ShouldReturnTrueIfDiverIsFound() {
        Diving ontario = new Diving("Ontario", 2);
        ontario.addDeepWaterDiver(diver);

        boolean isRemove = ontario.removeDeepWaterDiver("Elijah");

        Assertions.assertTrue(isRemove);
    }
}
