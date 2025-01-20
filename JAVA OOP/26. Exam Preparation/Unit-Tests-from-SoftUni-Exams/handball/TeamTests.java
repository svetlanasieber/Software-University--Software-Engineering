package handball;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTests {

    private static final String NAME_OF_TEAM = "CSKA";
    private static final String NAME_OF_Player = "Iliyan";

    private static final int POSITION = 1;

    private Team team;
    private  HandballPlayer handballPlayer;
    @Before
    public void setUp(){
        team = new Team(NAME_OF_TEAM,POSITION);
        handballPlayer = new HandballPlayer(NAME_OF_Player);


    }
    @Test
    public void test_GetName (){
        assertEquals(NAME_OF_TEAM,team.getName());

    }

    @Test
    public void test_Set_TeamName(){
        team = new Team("Liverpool",1);
        assertEquals("Liverpool",team.getName());

    }
    @Test
    public void test_Get_Position_Of_The_Team(){
        assertEquals(1,team.getPosition());

    }
    @Test
    public void test_Set_Team_Valid_Position(){
        team = new Team("Everton",20);
        assertEquals(20,team.getPosition());


    }
    @Test
    public void test_get_Correct_Count(){
        team.add(handballPlayer);
        assertEquals(1,team.getCount());

    }
    @Test
    public void test_Adding_Player_To_Team(){
        team.add(handballPlayer);
        assertEquals(1,team.getCount());

    }
    @Test
    public void test_Add_Player_To_Team(){
        HandballPlayer handballPlayer =new HandballPlayer(NAME_OF_Player);
        team.add(handballPlayer);


    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Try_To_Add_Player_To_Full_Squad(){
        HandballPlayer second = new HandballPlayer("second");
        HandballPlayer third = new HandballPlayer("third");
        team.add(second);
        team.add(third);

    }
    @Test
    public void test_Trying_To_Remove_Player_From_Team(){

        team.add(handballPlayer);
        team.remove(NAME_OF_Player);
        assertEquals(0, team.getCount());

    }
    @Test (expected = IllegalArgumentException.class)
    public void test_Remove_Player_Who_Is_Not_In_The_Team() throws IllegalArgumentException{
        team.remove("Borislav");

    }

    @Test (expected = IllegalArgumentException.class)
    public void  test_Set_NegativeTeam_Position() throws IllegalArgumentException{
        team = new Team("Monka",-1);
        assertNotEquals(-1, team.getPosition());

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Player_For_Another_team_Whit_Invalid_Player() throws IllegalArgumentException{
        team.playerForAnotherTeam("Ivo");
    }

    @Test
    public void test_Player_Played_For_Other_Team ()  {
        team.add(handballPlayer);
team.playerForAnotherTeam(NAME_OF_Player);
assertFalse(handballPlayer.isActive());

    }



    @Test(expected = NullPointerException.class)
    public void test_Team_Name_Cant_Be_Null() throws NumberFormatException{
        team = new Team(null,1);



    }
    @Test(expected = NullPointerException.class)
    public void test_Team_Name_Cant_Be_Empty_Space() throws NullPointerException{
        team = new Team(" ",1);

    }
    @Test
    public void test_Get_Statistics(){
        team.add(handballPlayer);
        assertEquals("The player Iliyan is in the team CSKA.",team.getStatistics());
    }






}
