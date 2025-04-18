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

import java.util.Optional;
import java.util.UUID;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterDTO")) {
            model.addAttribute("userRegisterDTO", new UserRegisterDTO());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterDTO userRegisterDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
            return "redirect:/register";
        }

        userService.registerUser(userRegisterDTO);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("userLoginDTO")) {
            model.addAttribute("userLoginDTO", new UserLoginDTO());
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginDTO userLoginDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              HttpSession session) {
        
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult);
            return "redirect:/login";
        }

        Optional<UUID> userId = userService.loginUser(userLoginDTO);
        if (userId.isEmpty()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return "redirect:/login";
        }

        session.setAttribute("user_id", userId.get());
        return "redirect:/home";
    }

    @GetMapping("/users/{userId}/profile")
    public String editProfile(@PathVariable("userId") UUID userId, Model model) {
        User user = userService.findById(userId);
        
        if (!model.containsAttribute("userProfileDTO")) {
            UserProfileDTO userProfileDTO = new UserProfileDTO();
            userProfileDTO.setEmail(user.getEmail());
            userProfileDTO.setFirstName(user.getFirstName());
            userProfileDTO.setLastName(user.getLastName());
            userProfileDTO.setProfilePicture(user.getProfilePicture());
            
            model.addAttribute("userProfileDTO", userProfileDTO);
        }
        
        return "edit-profile";
    }

    @PostMapping("/users/{userId}/profile")
    public String editProfileConfirm(@PathVariable("userId") UUID userId,
                                     @RequestParam(value = "firstName", required = false) String firstName,
                                     @RequestParam(value = "lastName", required = false) String lastName,
                                     @RequestParam(value = "email", required = false) String email,
                                     @RequestParam(value = "password", required = false) String password,
                                     @RequestParam(value = "profilePicture", required = false) String profilePicture) {
        
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setFirstName(firstName);
        userProfileDTO.setLastName(lastName);
        userProfileDTO.setEmail(email);
        userProfileDTO.setPassword(password);
        userProfileDTO.setProfilePicture(profilePicture);
        
        userService.updateUserProfile(userId, userProfileDTO);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
} 