package handball.entities.team;

public class Bulgaria extends BaseTeam{
    //I can only play Outdoor!
    public Bulgaria(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
     setAdvantage(super.getAdvantage() + 115);



    }
}
