package app.web;

import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.UserLoginDTO;
import app.web.dto.UserProfileDTO;
import app.web.dto.UserRegisterDTO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        if (!model.containsAttribute("userRegisterDTO")) {
            model.addAttribute("userRegisterDTO", new UserRegisterDTO());
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userRegisterDTO") UserRegisterDTO userRegisterDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
            return "redirect:/register";
        }

        boolean isRegistered = userService.register(userRegisterDTO);

        if (!isRegistered) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("userExists", true);
            return "redirect:/register";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        if (!model.containsAttribute("userLoginDTO")) {
            model.addAttribute("userLoginDTO", new UserLoginDTO());
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("userLoginDTO") UserLoginDTO userLoginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes,
                        HttpSession session) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult);
            return "redirect:/login";
        }

        User user = userService.login(userLoginDTO);

        if (user == null) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return "redirect:/login";
        }

        session.setAttribute("user_id", user.getId());

        return "redirect:/home";
    }

    @GetMapping("/users/{userId}/profile")
    public String getEditProfilePage(@PathVariable UUID userId, Model model) {
        User user = userService.findById(userId);

        if (user == null) {
            return "redirect:/";
        }

        if (!model.containsAttribute("userProfileDTO")) {
            UserProfileDTO userProfileDTO = new UserProfileDTO();
            userProfileDTO.setFirstName(user.getFirstName());
            userProfileDTO.setLastName(user.getLastName());
            userProfileDTO.setEmail(user.getEmail());
            userProfileDTO.setProfilePicture(user.getProfilePicture());

            model.addAttribute("userProfileDTO", userProfileDTO);
        }

        return "edit-profile";
    }

    @PostMapping("/users/{userId}/profile")
    public String updateProfile(@PathVariable UUID userId,
                               @Valid @ModelAttribute("userProfileDTO") UserProfileDTO userProfileDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userProfileDTO", userProfileDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userProfileDTO", bindingResult);
            return "redirect:/users/" + userId + "/profile";
        }

        userService.updateProfile(userId, userProfileDTO);

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
} 