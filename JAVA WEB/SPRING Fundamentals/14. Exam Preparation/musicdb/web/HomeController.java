package com.example.musicdb.web;

import com.example.musicdb.service.AlbumService;
import com.example.musicdb.session.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final AlbumService albumService;

    public HomeController(CurrentUser currentUser, AlbumService albumService) {
        this.currentUser = currentUser;
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String indexPage() {
        if (currentUser.getId() != null) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String homePage(Model model){

        model.addAttribute("sumAllAlbums",albumService.countAllCopies());

        model.addAttribute("allAlbums",albumService.getAllAlbums());

        System.out.println();
        return "home";
    }
}
