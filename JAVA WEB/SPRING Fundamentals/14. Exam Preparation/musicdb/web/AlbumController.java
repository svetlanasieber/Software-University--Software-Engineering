package com.example.musicdb.web;

import com.example.musicdb.model.binding.AlbumAddBindingModel;
import com.example.musicdb.model.service.AlbumAddService;
import com.example.musicdb.service.AlbumService;
import com.example.musicdb.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("album")
public class AlbumController {

    private final ArtistService artistService;
    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(ArtistService artistService, AlbumService albumService, ModelMapper modelMapper) {
        this.artistService = artistService;
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String albumAddPage(Model model) {
        model.addAttribute("allArtists", artistService.findAllArtists());
        return "add-album";
    }

    @PostMapping("/add")
    public String albumAddConfirm(@Valid AlbumAddBindingModel albumAddBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);
            return "redirect:add";
        }

        albumService.addAlbum(modelMapper.map(albumAddBindingModel, AlbumAddService.class));

        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteAlbum(@PathVariable Long id){
        albumService.deleteAlbum(id);
        return "redirect:/home";
    }

    @ModelAttribute("albumAddBindingModel")
    public AlbumAddBindingModel albumAddBindingModel() {
        return new AlbumAddBindingModel();
    }
}
