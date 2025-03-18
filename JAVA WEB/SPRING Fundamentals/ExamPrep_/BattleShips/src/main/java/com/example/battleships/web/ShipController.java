package com.example.battleships.web;

import com.example.battleships.model.binding.BattleShipsBindingModel;
import com.example.battleships.model.binding.ShipsAddBindingModel;
import com.example.battleships.model.service.ShipAddServiceModel;
import com.example.battleships.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ModelMapper modelMapper;
    private final ShipService shipService;

    public ShipController(ModelMapper modelMapper, ShipService shipService) {
        this.modelMapper = modelMapper;
        this.shipService = shipService;
    }

    @ModelAttribute
    public ShipsAddBindingModel shipsAddBindingModel() {
        return new ShipsAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {
        return "ship-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ShipsAddBindingModel shipsAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipsAddBindingModel", shipsAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipsAddBindingModel", bindingResult);

            return "redirect:add";
        }

        // save in DB
        ShipAddServiceModel shipAddServiceModel = modelMapper.map(shipsAddBindingModel, ShipAddServiceModel.class);
        shipService.addShip(shipAddServiceModel);

        return "redirect:/";
    }

    @PostMapping("/fire")
    public String fire(BattleShipsBindingModel battleShips) {

        shipService.fire(battleShips.getAttackerShip(), battleShips.getDefenderShip());

        return "redirect:/";
    }

}
