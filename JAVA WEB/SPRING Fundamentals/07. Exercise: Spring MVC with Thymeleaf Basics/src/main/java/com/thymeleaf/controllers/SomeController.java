package com.thymeleaf.controllers;

import com.thymeleaf.models.SomeModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

@Controller
public class SomeController {

    @GetMapping("/model")
    public String getModel(@Valid @ModelAttribute SomeModel someModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        }

        return "redirect:/home";
    }
}
