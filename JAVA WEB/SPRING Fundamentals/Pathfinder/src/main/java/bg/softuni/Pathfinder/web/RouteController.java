package bg.softuni.Pathfinder.web;

import bg.softuni.Pathfinder.model.dto.RouteShortInfoDTO;
import bg.softuni.Pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String routes(Model model) {
        List<RouteShortInfoDTO> routes = routeService.getAllRoutes();

        model.addAttribute("allRoutes", routes);

        return "routes";
    }
}