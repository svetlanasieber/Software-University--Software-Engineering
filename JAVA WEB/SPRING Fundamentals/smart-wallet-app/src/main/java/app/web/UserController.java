package app.web;

import app.security.RequireAdminRole;
import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.UserEditRequest;
import app.web.dto.UserInformation;
import app.web.mapper.DtoMapper;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

import static app.security.SessionInterceptor.USER_ID_SESSION_ATTRIBUTE;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping
    @RequireAdminRole
    public ModelAndView getAllUsers(HttpSession session) {

        UUID userId = (UUID) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);
        User loggedUser = userService.getById(userId);

        List<UserInformation> users = userService.getAllUsers().stream()
                .map(DtoMapper::toUserInformation)
                .toList();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", loggedUser);
        modelAndView.addObject("users", users);
        modelAndView.setViewName("users");

        return modelAndView;
    }

    @PutMapping("/{userId}/status")
    @RequireAdminRole
    public String switchUserStatus(@PathVariable UUID userId) {

        userService.switchStatus(userId);

        return "redirect:/users";
    }

    @GetMapping("/profile")
    public ModelAndView getProfile(HttpSession session) {

        UUID userId = (UUID) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);
        User user = userService.getById(userId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.addObject("userEditRequest", UserEditRequest.buildFromUser(user));
        modelAndView.setViewName("profile-menu");

        return modelAndView;
    }

    @PutMapping("/profile")
    public ModelAndView updateProfile(HttpSession session, @Valid UserEditRequest userEditRequest, BindingResult bindingResult) {

        UUID userId = (UUID) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);
        User user = userService.editUser(userId, userEditRequest);

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("user", user);
            modelAndView.addObject("userEditRequest", userEditRequest);
            modelAndView.setViewName("profile-menu");
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }
}