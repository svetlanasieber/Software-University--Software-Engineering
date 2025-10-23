package main.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public String handleInvalidCredentials(InvalidCredentialsException ex, Model model) {
        model.addAttribute("loginAttemptMessage", ex.getMessage());
        model.addAttribute("loginDto", new main.web.dto.LoginDto());
        return "login";
    }

    @ExceptionHandler(DuplicateUsernameException.class)
    public String handleDuplicateUsername(DuplicateUsernameException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        model.addAttribute("registerDto", new main.web.dto.RegisterDto());
        model.addAttribute("houses", main.model.House.values());
        model.addAttribute("alignments", main.model.WizardAlignment.values());
        return "register";
    }

    @ExceptionHandler(SpellAlreadyLearnedException.class)
    public String handleSpellAlreadyLearned(SpellAlreadyLearnedException ex) {
        return "redirect:/home";
    }

    @ExceptionHandler(InsufficientSpellsException.class)
    public String handleInsufficientSpells(InsufficientSpellsException ex) {
        return "redirect:/home";
    }
}



