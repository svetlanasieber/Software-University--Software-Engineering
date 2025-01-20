package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizards = magicians.stream().filter(magician -> magician.getClass().getSimpleName().equals("Wizard")).collect(Collectors.toList());
        List<Magician> blackWidowList = magicians.stream().filter(magician -> magician.getClass().getSimpleName().equals("BlackWidow")).collect(Collectors.toList());

        Magician wizard;
        Magician blackWidow;

        while (!wizards.isEmpty() && !blackWidowList.isEmpty()) {
            wizard = wizards.get(0);
            blackWidow = blackWidowList.get(0);


            int wizardPoints = wizard.getMagic().fire();
            blackWidow.takeDamage(wizardPoints);
            if (!blackWidow.isAlive()) {
                blackWidowList.remove(blackWidow);
            }

            int blackWidowPoints = blackWidow.getMagic().fire();
            wizard.takeDamage(blackWidowPoints);
            if (!wizard.isAlive()) {
                wizards.remove(wizard);
            }


        }
        String output = "";
        if (blackWidowList.isEmpty()) {
            output = "Wizards win!";

        } else {
            output = "Black widows win!";

        }
        return output;
    }

}
