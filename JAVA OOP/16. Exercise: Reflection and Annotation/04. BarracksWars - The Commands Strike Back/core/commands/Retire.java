package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Retire extends Command {
    protected Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        String result;
        try {
            this.getRepository().removeUnit(unitType);
            result = unitType + " retired!";
        } catch (IllegalArgumentException ex){
            result = ex.getMessage();
        }
        return result;
    }
}
