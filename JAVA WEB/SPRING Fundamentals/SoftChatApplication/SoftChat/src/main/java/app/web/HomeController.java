package app.web;

import app.message.model.Message;
import app.message.service.MessageService;
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
    private final MessageService messageService;
    
    @Autowired
    public HomeController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        UUID userId = (UUID) session.getAttribute("user_id");
        User currentUser = userService.findById(userId);
        
        List<Message> sentMessages = messageService.findSentMessages(currentUser);
        List<Message> receivedMessages = messageService.findReceivedMessages(currentUser);
        
        model.addAttribute("user", currentUser);
        model.addAttribute("sentMessages", sentMessages);
        model.addAttribute("receivedMessages", receivedMessages);
        
        return "home";
    }
} 