package com.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MyController {

    @GetMapping("/home")
    public String getHomePage(Model model) throws ParseException {
        Date myDate = new Date();
        model.addAttribute("myDate", myDate);

        Date[] dates = new Date[2];
        dates[0] = new SimpleDateFormat("yyyy-MM-dd").parse("2016-12-12");
        dates[1] = new SimpleDateFormat("yyyy-MM-dd").parse("2015-03-28");

        model.addAttribute("myDates", dates);

        String nullable = null;
        model.addAttribute("myString", nullable);

        String jackDaniels = "Jack Daniels";
        model.addAttribute("whiskey", jackDaniels);

        String[] whiskeys = new String[] { "Jack Daniels", "Jameson", "J&B"};
        model.addAttribute("whiskeys", whiskeys);


        String firstName = "george";
        model.addAttribute("firstName", firstName);

        double number = 3.14159;
        model.addAttribute("number", number);

        double[] numbers = new double[] { 29.23, 21.22,33.50 };
        model.addAttribute("numbers", numbers);



        return "home";
    }
}
