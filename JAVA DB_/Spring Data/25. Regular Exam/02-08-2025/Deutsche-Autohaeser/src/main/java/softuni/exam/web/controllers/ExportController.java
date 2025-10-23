package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.CarService;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

    private final CarService carService;

    @Autowired
    public ExportController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/cars")
    public ModelAndView exportCarsByType() {
        String exportedCars = this.carService.exportCars();

        return super.view("export/export-cars.html", "exportedCars", exportedCars);
    }
}
