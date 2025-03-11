package bg.softuni._17_springjson.controllers;

import bg.softuni._17_springjson.entities.dtos.PersonDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

//    private final PersonService personService;
//
//    public HomeController(PersonService personService) {
//        this.personService = personService;
//    }

    @GetMapping("/alabala")
    public void handleAlabala() {
        System.out.println("Handled");
    }

    @GetMapping(value = "/person")
    public PersonDTO getPerson() {
        return new PersonDTO("First", "Last", 120);
    }

    public void updatePerson(PersonDTO person) {

    }
}
