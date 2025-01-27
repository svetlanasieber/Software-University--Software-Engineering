package bg.softuni.Pathfinder.web;


import bg.softuni.Pathfinder.model.dto.UserLoginDTO;
import bg.softuni.Pathfinder.model.dto.UserRegisterDTO;
import bg.softuni.Pathfinder.model.enums.Level;
import bg.softuni.Pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String openRegistrationPage(Model model) {
        model.addAttribute("registerData", new UserRegisterDTO());
        model.addAttribute("levels", Level.values());

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(UserRegisterDTO data,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData", bindingResult);
            return "register";
        }
        userService.register(data);

        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String openLoginpage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(UserLoginDTO loginData) {

        return "login";
    }


}
