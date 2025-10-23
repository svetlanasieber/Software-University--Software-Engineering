package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.CarService;
import softuni.exam.service.DealerService;
import softuni.exam.service.DealershipService;

@Controller
public class HomeController extends BaseController {

    private final CarService carService;
    private final DealerService dealerService;
    private final DealershipService dealershipService;

    @Autowired
    public HomeController(CarService carService, DealershipService dealershipService, DealerService dealerService) {
        this.carService = carService;
        this.dealerService = dealerService;
        this.dealershipService = dealershipService;
    }


    @GetMapping("/")
    public ModelAndView index() {
        boolean areImported = this.carService.areImported() &&
                this.dealershipService.areImported() &&
                this.carService.areImported()  &&
                this.dealerService.areImported();

        return super.view("index", "areImported", areImported);
    }
}
