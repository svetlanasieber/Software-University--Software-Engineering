package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.House;
import main.model.Wizard;
import main.model.WizardAlignment;
import main.service.WizardService;
import main.web.dto.LoginDto;
import main.web.dto.RegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static main.security.SessionInterceptor.USER_ID_FROM_SESSION;

@Controller
public class AuthController {

    private final WizardService wizardService;

    public AuthController(WizardService wizardService) {
        this.wizardService = wizardService;
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        model.addAttribute("houses", House.values());
        model.addAttribute("alignments", WizardAlignment.values());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute RegisterDto registerDto,
                          BindingResult bindingResult,
                          Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("houses", House.values());
            model.addAttribute("alignments", WizardAlignment.values());
            return "register";
        }

        wizardService.register(registerDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto,
                       HttpSession session) {
        Wizard wizard = wizardService.login(loginDto);
        session.setAttribute(USER_ID_FROM_SESSION, wizard.getId().toString());
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

