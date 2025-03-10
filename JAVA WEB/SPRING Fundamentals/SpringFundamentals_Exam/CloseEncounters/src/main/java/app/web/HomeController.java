package app.web;

import app.story.model.Story;
import app.story.service.StoryService;
import app.user.model.User;
import app.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class HomeController {

    private final UserService userService;
    private final StoryService storyService;

    @Autowired
    public HomeController(UserService userService, StoryService storyService) {
        this.userService = userService;
        this.storyService = storyService;
    }

    @GetMapping("/home")
    public String getHomePage(HttpSession session, Model model) {
        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.findById(userId);

        if (user == null) {
            return "redirect:/";
        }

        List<Story> userStories = storyService.getAllStoriesByUser(user);
        List<Story> visibleStories = storyService.getAllVisibleStories();

        model.addAttribute("user", user);
        model.addAttribute("userStories", userStories);
        model.addAttribute("visibleStories", visibleStories);

        return "home";
    }
} 