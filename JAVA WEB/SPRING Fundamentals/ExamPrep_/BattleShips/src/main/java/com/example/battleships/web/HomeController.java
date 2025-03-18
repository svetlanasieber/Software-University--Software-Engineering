package com.example.battleships.web;

import com.example.battleships.model.binding.BattleShipsBindingModel;
import com.example.battleships.service.ShipService;
import com.example.battleships.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;

    public HomeController(CurrentUser currentUser, ShipService shipService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
    }

    @GetMapping()
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("allUsersShips", shipService.findAllShipsByUser(currentUser.getId()));
        model.addAttribute("allOtherShips", shipService.findAllShipsByUserNot(currentUser.getId()));
        model.addAttribute("allShips", shipService.findAllShips());

        BattleShipsBindingModel ships = new BattleShipsBindingModel();
        model.addAttribute("ships", ships);

        return "home";
    }

}
