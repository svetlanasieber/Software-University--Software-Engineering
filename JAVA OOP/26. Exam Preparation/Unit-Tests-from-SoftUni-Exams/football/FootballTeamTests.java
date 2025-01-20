package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class FootballTeamTests {
    private FootballTeam footballTeam;
    private Footballer footballer;
    @Before
    public void setUp(){
        footballTeam = new FootballTeam("Liverpool",1);
        footballer = new Footballer("Iliyan");

    }

    @Test
    public void testConstructorFootballTeam(){
        footballTeam = new FootballTeam("CSKA",1);

        assertEquals("CSKA",footballTeam.getName());
        assertEquals(1,footballTeam.getVacantPositions());
        footballTeam.addFootballer(footballer);
        assertEquals(1,footballTeam.getCount());



    }
    @Test(expected = NullPointerException.class)
    public void testSetNullNameFootballTeam(){

        footballTeam = new FootballTeam(null,2);
    }
       @Test(expected = NullPointerException.class)
    public void testSetInvalidNameFootballTeam(){

        footballTeam = new FootballTeam("       ",2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeVacantPosition(){
        footballTeam = new FootballTeam("Team",-1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerWhitNoCapacityShouldThrow(){
        footballTeam = new FootballTeam("Team",1);
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(new Footballer("Tafty"));


    }

    @Test
    public void testRemoveFootballer(){
        footballTeam = new FootballTeam("Team",1);
        footballer = new Footballer("Player");
        footballTeam.addFootballer(footballer);

        footballTeam.removeFootballer("Player");
        assertEquals(0,footballTeam.getCount());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballPlayerWhitNullName(){
        footballTeam = new FootballTeam("Team",1);
        footballTeam.removeFootballer(null);
    }
    @Test
    public void testFootballerForSale(){
      FootballTeam footballTeam1 = new FootballTeam("Team",1);
      Footballer footballer1 = new Footballer("Player1");
      footballTeam1.addFootballer(footballer1);
      footballTeam1.footballerForSale("Player1");
      assertFalse(footballer1.isActive());



    }

    @Test
    public void testGetStatistics(){
        footballTeam.addFootballer(footballer);
        String expectedOutput ="The footballer Iliyan is in the team Liverpool.";

        assertEquals(expectedOutput,footballTeam.getStatistics());
    }







}
