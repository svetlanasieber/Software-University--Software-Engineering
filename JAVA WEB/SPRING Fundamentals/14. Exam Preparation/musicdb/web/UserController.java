package com.example.musicdb.web;

import com.example.musicdb.model.binding.LoginUserBindingModel;
import com.example.musicdb.model.binding.RegisterUserBindingModel;
import com.example.musicdb.model.service.loginUserService;
import com.example.musicdb.model.service.registerUserService;
import com.example.musicdb.service.UserService;
import com.example.musicdb.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;


    public UserController(UserService userService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/logout")
    public String logoutUser() {
        userService.logout();
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        if (!model.containsAttribute("notExisting")) {
            model.addAttribute("notExisting", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid LoginUserBindingModel loginUserBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("loginUserBindingModel", loginUserBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginUserBindingModel", bindingResult);
            return "redirect:login";
        }

        if (userService.isExisting(loginUserBindingModel.getUsername(), loginUserBindingModel.getPassword())) {
            redirectAttributes.addFlashAttribute("notExisting", true);
            return "redirect:login";
        }
        userService.loginUser(modelMapper.map(loginUserBindingModel, loginUserService.class));

        return "redirect:/";

    }

    @PostMapping("/register")
    public String registerConfirm(@Valid RegisterUserBindingModel registerUserBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("registerUserBindingModel", registerUserBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUserBindingModel", bindingResult);
            return "redirect:register";
        }

        userService.registerUser(modelMapper.map(registerUserBindingModel, registerUserService.class));

        return "redirect:login";
    }


    @GetMapping("/register")
    public String regPage() {
        return "register";
    }

    @ModelAttribute("loginUserBindingModel")
    public LoginUserBindingModel loginUserBindingModel() {
        return new LoginUserBindingModel();
    }

    @ModelAttribute("registerUserBindingModel")
    public RegisterUserBindingModel registerUserBindingModel() {
        return new RegisterUserBindingModel();
    }
}
