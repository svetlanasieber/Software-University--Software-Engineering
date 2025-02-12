package com.paintingscollectors.web;

import com.paintingscollectors.painting.service.PaintingService;
import com.paintingscollectors.user.model.User;
import com.paintingscollectors.user.service.UserService;
import com.paintingscollectors.web.dto.CreatePaintingRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/paintings")
public class PaintingsController {

    private final UserService userService;
    private final PaintingService paintingService;

    @Autowired
    public PaintingsController(UserService userService, PaintingService paintingService) {
        this.userService = userService;
        this.paintingService = paintingService;
    }

    @GetMapping("/new")
    public ModelAndView getNewPainingPage(HttpSession session) {

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getById(userId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-painting");
        modelAndView.addObject("user", user);
        modelAndView.addObject("createPaintingRequest", new CreatePaintingRequest());

        return modelAndView;
    }

    @PostMapping
    public String createNewPainting(@Valid CreatePaintingRequest createPaintingRequest, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "new-painting";
        }

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getById(userId);

        paintingService.createNewPainting(createPaintingRequest, user);

        return "redirect:/home";
    }

    @DeleteMapping("/{id}")
    public String deletePainting(@PathVariable UUID id) {

        paintingService.deletePaintingById(id);

        return "redirect:/home";
    }

    // /paintings/favourites/{id}
    @PostMapping("/favourites/{id}")
    public String makeFavouritePainting(@PathVariable UUID id, HttpSession session) {

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getById(userId);

        paintingService.createFavouriteByPaintingId(id, user);

        return "redirect:/home";
    }

    // '/paintings/favourites/' + {id}
    @DeleteMapping("/favourites/{id}")
    public String deleteFavouritePainting(@PathVariable UUID id) {

        paintingService.deleteFavouriteById(id);

        return "redirect:/home";
    }

    @PutMapping("/{id}/votes")
    public String updateVotes(@PathVariable UUID id) {

        paintingService.incrementVotesByOne(id);

        return "redirect:/home";
    }


}
