package com.example.coffeeshop.web;

import com.example.coffeeshop.model.binding.OrderAddBindingModel;
import com.example.coffeeshop.model.service.OrderServiceAddModel;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final ModelMapper modelMapper;
    private final OrderService orderService;
    private final CurrentUser currentUser;

    public OrderController(ModelMapper modelMapper, OrderService orderService, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.orderService = orderService;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public OrderAddBindingModel orderAddBindingModel() {
        return new OrderAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {
        return "order-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid OrderAddBindingModel orderAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderAddBindingModel", orderAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel", bindingResult);

            return "redirect:add";
        }

        if (currentUser.getId() == null) {
            return "redirect:/";
        }

        // save in DB
        OrderServiceAddModel orderServiceAddModel = modelMapper.map(orderAddBindingModel, OrderServiceAddModel.class);
        orderService.addOrder(orderServiceAddModel);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String ready(@PathVariable Long id) {

        orderService.readyOrder(id);

        return "redirect:/";
    }
}
