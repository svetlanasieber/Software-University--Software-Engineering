package agriculture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AgricultureTests {
    private Land land;
    private Seed seed1;
    private Seed seed2;

    @BeforeEach
    public void setUp() {
        land = new Land("MyLand", "Clay");
        seed1 = new Seed("Rose", "Clay", 80, true);
        seed2 = new Seed("Tulip", "Clay", 90, false);
    }

    @Test
    public void testConstructor() {
        assertEquals("MyLand", land.getName());
        assertEquals("Clay", land.getSoilType());
        assertEquals(0, land.getCount());
    }

    @Test
    public void testSetNameWithNull() {
        assertThrows(NullPointerException.class, () -> new Land(null, "Clay"));
    }

    @Test
    public void testSetNameWithEmptyString() {
        assertThrows(NullPointerException.class, () -> new Land("  ", "Clay"));
    }

    @Test
    public void testAddSeed() {
        land.addSeed(seed1);
        assertEquals(1, land.getCount());
        assertEquals(seed1, land.getSeed("Rose"));
    }

    @Test
    public void testAddSeedWithIncompatibleSoil() {
        Seed incompatibleSeed = new Seed("Lily", "Sand", 70, true);
        assertThrows(IllegalArgumentException.class, () -> land.addSeed(incompatibleSeed));
    }

    @Test
    public void testAddExistingSeed() {
        land.addSeed(seed1);
        assertThrows(IllegalArgumentException.class, () -> land.addSeed(seed1));
    }

    @Test
    public void testRemoveSeed() {
        land.addSeed(seed1);
        land.addSeed(seed2);
        assertTrue(land.removeSeed("Rose"));
        assertEquals(1, land.getCount());
        assertNull(land.getSeed("Rose"));
    }



    @Test
    public void testRemoveNonExistentSeed() {
        land.addSeed(seed1);
        assertFalse(land.removeSeed("Lily"));
        assertEquals(1, land.getCount());
    }

    @Test
    public void testGetMostGerminatingSeed() {
        land.addSeed(seed1);
        land.addSeed(seed2);
        assertEquals("Tulip", land.getMostGerminatingSeed());
    }

    @Test
    public void testGetValuableSeeds() {
        land.addSeed(seed1);
        land.addSeed(seed2);
        assertEquals("Rose", land.getValuableSeeds());
    }

    @Test
    public void testGetSeedBySoilType() {
        land.addSeed(seed1);
        land.addSeed(seed2);
        List<Seed> seedsBySoil = land.getSeedBySoilType("Clay");
        assertEquals(2, seedsBySoil.size());
        assertTrue(seedsBySoil.contains(seed1));
        assertTrue(seedsBySoil.contains(seed2));
    }

    @Test
    public void testGetCount() {
        land.addSeed(seed1);
        assertEquals(1, land.getCount());
        land.addSeed(seed2);
        assertEquals(2, land.getCount());
    }

    @Test
    public void testGetSeed() {
        land.addSeed(seed1);
        assertEquals(seed1, land.getSeed("Rose"));
        assertNull(land.getSeed("Tulip"));
    }
}
