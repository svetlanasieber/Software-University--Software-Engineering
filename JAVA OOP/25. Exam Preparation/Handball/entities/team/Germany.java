package handball.entities.team;

public class Germany extends BaseTeam{

//    I can only play Indoor!
    public Germany(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        setAdvantage(super.getAdvantage() + 145);

    }
}
