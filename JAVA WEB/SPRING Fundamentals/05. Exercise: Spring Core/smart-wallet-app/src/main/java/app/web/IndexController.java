package app.web;

import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.LoginRequest;
import app.web.dto.RegisterRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

import static app.security.SessionInterceptor.USER_ID_SESSION_ATTRIBUTE;

@Controller
public class IndexController {

    private final UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getIndexPage() {

        return "index";
    }

    @GetMapping("/home")
    public ModelAndView getHomePage(HttpSession session) {

        UUID userId = (UUID) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);
        User user = userService.getById(userId);

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("loginRequest", new LoginRequest());

        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage() {

        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("registerRequest", new RegisterRequest());

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid LoginRequest loginRequest, BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            return new ModelAndView("login");
        }

        User loggedUser = userService.login(loginRequest);
        activateUserSession(session, loggedUser.getId());

        return redirectToHomeEndpoint();
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid RegisterRequest registerRequest, BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            return new ModelAndView("register");
        }

        User registeredUser = userService.register(registerRequest);
        activateUserSession(session, registeredUser.getId());

        return redirectToHomeEndpoint();
    }

    @GetMapping("/logout")
    public String getLogout(HttpSession session) {

        session.invalidate();
        return "redirect:/";
    }

    private void activateUserSession(HttpSession session, UUID userId) {

        session.setAttribute(USER_ID_SESSION_ATTRIBUTE, userId);
        session.setMaxInactiveInterval(30*60);
    }

    private static ModelAndView redirectToHomeEndpoint() {

        return new ModelAndView("redirect:/home");
    }
}
