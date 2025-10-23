package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Wizard;
import main.service.WizardService;
import main.web.dto.EditProfileDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

import static main.security.SessionInterceptor.USER_ID_FROM_SESSION;

@Controller
public class ProfileController {

    private final WizardService wizardService;

    public ProfileController(WizardService wizardService) {
        this.wizardService = wizardService;
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        UUID wizardId = UUID.fromString((String) session.getAttribute(USER_ID_FROM_SESSION));
        Wizard wizard = wizardService.findById(wizardId);


        EditProfileDto editProfileDto = new EditProfileDto();
        editProfileDto.setUsername(wizard.getUsername());
        editProfileDto.setAvatarUrl(wizard.getAvatarUrl());

        model.addAttribute("wizard", wizard);
        model.addAttribute("editProfileDto", editProfileDto);

        return "profile";
    }

    @PutMapping("/profile")
    public String updateProfile(@Valid @ModelAttribute EditProfileDto editProfileDto,
                               BindingResult bindingResult,
                               HttpSession session,
                               Model model) {
        UUID wizardId = UUID.fromString((String) session.getAttribute(USER_ID_FROM_SESSION));

        if (bindingResult.hasErrors()) {
            Wizard wizard = wizardService.findById(wizardId);
            model.addAttribute("wizard", wizard);
            return "profile";
        }

        wizardService.updateProfile(wizardId, editProfileDto);
        return "redirect:/profile";
    }

    @PatchMapping("/profile/alignment")
    public String changeAlignment(HttpSession session) {
        UUID wizardId = UUID.fromString((String) session.getAttribute(USER_ID_FROM_SESSION));
        wizardService.changeAlignmentToDark(wizardId);
        return "redirect:/profile";
    }
}

