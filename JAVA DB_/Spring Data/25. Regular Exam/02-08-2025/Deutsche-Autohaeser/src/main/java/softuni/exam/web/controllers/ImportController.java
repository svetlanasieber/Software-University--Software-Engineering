package softuni.exam.web.controllers;

import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.CarService;
import softuni.exam.service.DealerService;
import softuni.exam.service.DealershipService;

import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {

    private final CarService carService;
    private final DealerService dealerService;
    private final DealershipService dealershipService;

    @Autowired
    public ImportController(CarService carService, DealershipService dealershipService, DealerService dealerService) {
        this.carService = carService;
        this.dealerService = dealerService;
        this.dealershipService = dealershipService;
    }


    @GetMapping("/json")
    public ModelAndView importJson() {

        boolean[] areImported = new boolean[]{
                this.dealershipService.areImported(),
                this.carService.areImported()
        };

        return super.view("json/import-json", "areImported", areImported);
    }


    @GetMapping("/xml")
    public ModelAndView importXml() {
        boolean[] areImported = new boolean[]{
                this.dealerService.areImported()
        };

        return super.view("xml/import-xml", "areImported", areImported);
    }


    @GetMapping("/dealerships")
    public ModelAndView importConstellations() throws IOException {
        String fileContent = this.dealershipService.readDealershipsFromFile();

        return super.view("json/import-dealerships", "dealerships", fileContent);
    }

    @PostMapping("/dealerships")
    public ModelAndView importConstellationsConfirm() throws IOException {
        this.dealershipService.importDealerships();
        return super.redirect("/import/json");
    }

    @GetMapping("/cars")
    public ModelAndView importStars() throws IOException {
        String fileContent = this.carService.readCarsFileContent();

        return super.view("json/import-cars", "cars", fileContent);
    }

    @PostMapping("/cars")
    public ModelAndView importStarsConfirm() throws IOException, JAXBException {
        this.carService.importCars();
        return super.redirect("/import/json");
    }


    @GetMapping("/dealers")
    public ModelAndView importDealers() throws IOException {
        String dealersXmlFileContent = this.dealerService.readDealersFromFile();

        return super.view("xml/import-dealers", "dealers", dealersXmlFileContent);
    }

    @PostMapping("/dealers")
    public ModelAndView importDealersConfirm() throws JAXBException, IOException {
        this.dealerService.importDealers();


        return super.redirect("/");
    }
}
