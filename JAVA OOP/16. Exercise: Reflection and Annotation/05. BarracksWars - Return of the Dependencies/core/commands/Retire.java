package barracksWars.core.commands;

import barracksWars.core.anotations.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Retire extends Command {
    @Inject
    Repository repository;

    protected Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        String result;
        try {
            this.repository.removeUnit(unitType);
            result = unitType + " retired!";
        } catch (IllegalArgumentException ex){
            result = ex.getMessage();
        }
        return result;
    }
}
