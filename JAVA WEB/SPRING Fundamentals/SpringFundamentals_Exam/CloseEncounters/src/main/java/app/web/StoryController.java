package app.web;

import app.story.model.Story;
import app.story.service.StoryService;
import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.StoryAddDTO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
public class StoryController {

    private final StoryService storyService;
    private final UserService userService;

    @Autowired
    public StoryController(StoryService storyService, UserService userService) {
        this.storyService = storyService;
        this.userService = userService;
    }

    @GetMapping("/stories/new")
    public String getAddStoryPage(Model model) {
        if (!model.containsAttribute("storyAddDTO")) {
            model.addAttribute("storyAddDTO", new StoryAddDTO());
        }
        return "add-story";
    }

    @PostMapping("/stories/new")
    public String addStory(@Valid @ModelAttribute("storyAddDTO") StoryAddDTO storyAddDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          HttpSession session) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("storyAddDTO", storyAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.storyAddDTO", bindingResult);
            return "redirect:/stories/new";
        }

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.findById(userId);

        if (user == null) {
            return "redirect:/";
        }

        storyService.addStory(storyAddDTO, user);

        return "redirect:/home";
    }

    @GetMapping("/stories/{storyId}")
    public String getStoryPage(@PathVariable UUID storyId, Model model) {
        Story story = storyService.findById(storyId);

        if (story == null) {
            return "redirect:/home";
        }

        model.addAttribute("story", story);
        return "story";
    }

    @PostMapping("/stories/{storyId}")
    public String deleteStory(@PathVariable UUID storyId) {
        storyService.deleteStory(storyId);
        return "redirect:/home";
    }

    @PostMapping("/stories/{storyId}/visibility")
    public String toggleVisibility(@PathVariable UUID storyId) {
        storyService.toggleVisibility(storyId);
        return "redirect:/home";
    }
} 