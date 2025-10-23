package main.web;

import main.model.House;
import main.model.Wizard;
import main.service.WizardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class ArenaController {

    private final WizardService wizardService;

    public ArenaController(WizardService wizardService) {
        this.wizardService = wizardService;
    }

    @GetMapping("/arena")
    public String arena(Model model) {

        List<Wizard> gryffindorWizards = getSortedWizardsByHouse(House.GRYFFINDOR);
        List<Wizard> slytherinWizards = getSortedWizardsByHouse(House.SLYTHERIN);
        List<Wizard> ravenclawWizards = getSortedWizardsByHouse(House.RAVENCLAW);
        List<Wizard> hufflepuffWizards = getSortedWizardsByHouse(House.HUFFLEPUFF);

        model.addAttribute("gryffindorWizards", gryffindorWizards);
        model.addAttribute("slytherinWizards", slytherinWizards);
        model.addAttribute("ravenclawWizards", ravenclawWizards);
        model.addAttribute("hufflepuffWizards", hufflepuffWizards);

        return "arena";
    }

    private List<Wizard> getSortedWizardsByHouse(House house) {
        List<Wizard> wizards = wizardService.findAllByHouse(house);
        

        wizards.sort(
            Comparator.comparingInt((Wizard w) -> wizardService.getTotalPower(w))
                .reversed()
                .thenComparing(Wizard::getUsername)
        );
        
        return wizards;
    }
}



