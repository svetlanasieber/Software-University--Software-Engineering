package main.web;

import jakarta.servlet.http.HttpSession;
import main.model.Spell;
import main.model.Wizard;
import main.property.SpellsProperties;
import main.service.SpellService;
import main.service.WizardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

import static main.security.SessionInterceptor.USER_ID_FROM_SESSION;

@Controller
public class HomeController {

    private final WizardService wizardService;
    private final SpellService spellService;

    public HomeController(WizardService wizardService, SpellService spellService) {
        this.wizardService = wizardService;
        this.spellService = spellService;
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        UUID wizardId = UUID.fromString((String) session.getAttribute(USER_ID_FROM_SESSION));
        Wizard wizard = wizardService.findById(wizardId);


        List<Spell> learnedSpells = spellService.getLearnedSpells(wizard);


        List<SpellsProperties.SpellData> availableSpells = spellService.getAvailableSpells(wizard);


        int currentLearnedCount = wizard.getSpells().size();
        
        List<SpellsProperties.SpellData> eligibleSpells = availableSpells.stream()
                .filter(spell -> spell.getMinLearned() <= currentLearnedCount)
                .toList();

        List<SpellsProperties.SpellData> lockedSpells = availableSpells.stream()
                .filter(spell -> spell.getMinLearned() > currentLearnedCount)
                .toList();

        model.addAttribute("wizard", wizard);
        model.addAttribute("learnedSpells", learnedSpells);
        model.addAttribute("eligibleSpells", eligibleSpells);
        model.addAttribute("lockedSpells", lockedSpells);

        return "home";
    }

    @PostMapping("/spells")
    public String learnSpell(@RequestParam("spell-code") String spellCode, HttpSession session) {
        UUID wizardId = UUID.fromString((String) session.getAttribute(USER_ID_FROM_SESSION));
        Wizard wizard = wizardService.findById(wizardId);

        spellService.learnSpell(wizard, spellCode);

        return "redirect:/home";
    }
}

