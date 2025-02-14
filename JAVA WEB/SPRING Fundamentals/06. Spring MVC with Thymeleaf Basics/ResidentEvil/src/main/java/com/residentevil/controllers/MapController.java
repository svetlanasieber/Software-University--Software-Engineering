package com.residentevil.controllers;

import com.residentevil.services.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    private final VirusService virusService;

    @Autowired
    public MapController(VirusService virusService) {
        this.virusService = virusService;
    }

    @GetMapping("/map")
    public String getMapPage(Model model) {
        String geoJson = this.virusService.getGeoData();

        System.out.println(geoJson);
        model.addAttribute("geoJson", geoJson);
        return "map";
    }
}
