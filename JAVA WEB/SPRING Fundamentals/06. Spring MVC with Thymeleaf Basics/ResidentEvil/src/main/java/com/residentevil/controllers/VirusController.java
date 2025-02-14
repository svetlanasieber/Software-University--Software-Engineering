package com.residentevil.controllers;

import com.residentevil.enums.Magnitude;
import com.residentevil.enums.Mutation;
import com.residentevil.models.VirusBindingModel;
import com.residentevil.services.CapitalService;
import com.residentevil.services.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VirusController {

    private final CapitalService capitalService;

    private final VirusService virurService;

    @Autowired
    public VirusController(CapitalService capitalService, VirusService virurService) {
        this.capitalService = capitalService;
        this.virurService = virurService;
    }

    @ModelAttribute(name = "mutations")
    public List<String> getMutations(){
        List<String> mutationList = new ArrayList<>();
        Mutation[] mutations = Mutation.values();
        for (Mutation mutation : mutations) {
            mutationList.add(mutation.toString());
        }

        return mutationList;
    }

    @ModelAttribute(name = "magnitudes")
    public List<String> getMagnitude(){
        List<String> magnitudeList = new ArrayList<>();
        Magnitude[] magnitudes = Magnitude.values();
        for (Magnitude magnitude : magnitudes) {
            magnitudeList.add(magnitude.toString());
        }

        return magnitudeList;
    }

    @ModelAttribute(name = "capitalList")
    public List<String> getCapitals(){
        return this.capitalService.getCapitals();
    }

    @GetMapping("/viruses")
    public String getAddVirus(@ModelAttribute VirusBindingModel virusBindingModel) {
        return "add-viruses";
    }

    @PostMapping("/viruses")
    public String postAddVirus(@Valid @ModelAttribute VirusBindingModel virusBindingModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-viruses";
        }

        this.virurService.create(virusBindingModel);
        return "redirect:/";
    }



}
