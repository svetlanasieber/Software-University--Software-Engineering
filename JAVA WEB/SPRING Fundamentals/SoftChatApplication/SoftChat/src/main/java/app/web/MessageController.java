package app.web;

import app.message.model.Message;
import app.message.service.MessageService;
import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.MessageSendDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class MessageController {
    
    private final MessageService messageService;
    private final UserService userService;
    
    @Autowired
    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }
    
    @GetMapping("/messages/new-message")
    public String newMessage(Model model, HttpSession session) {
        UUID userId = (UUID) session.getAttribute("user_id");
        List<User> possibleReceivers = userService.findAllExceptCurrentUser(userId);
        model.addAttribute("receivers", possibleReceivers);
        return "new-message";
    }
    
    @PostMapping("/messages/new-message")
    public String sendMessage(@RequestParam(value = "receiverId", required = false) String receiverIdStr,
                             @RequestParam("subject") String subject,
                             @RequestParam("content") String content,
                             Model model,
                             HttpSession session) {
        
        UUID userId = (UUID) session.getAttribute("user_id");
        List<User> possibleReceivers = userService.findAllExceptCurrentUser(userId);
        model.addAttribute("receivers", possibleReceivers);
        

        boolean hasErrors = false;
        
        if (receiverIdStr == null || receiverIdStr.isEmpty()) {
            model.addAttribute("receiverError", "You must select a receiver!");
            hasErrors = true;
        }
        
        if (subject == null || subject.length() < 5 || subject.length() > 15) {
            model.addAttribute("subjectError", "Subject length must be between 5 and 15 characters!");
            hasErrors = true;
        }
        
        if (content == null || content.length() < 10 || content.length() > 100) {
            model.addAttribute("contentError", "Content length must be between 10 and 100 characters!");
            hasErrors = true;
        }
        
        if (hasErrors) {
            return "new-message";
        }
        
        try {

            UUID receiverId = UUID.fromString(receiverIdStr);
            

            MessageSendDTO dto = new MessageSendDTO();
            dto.setReceiverId(receiverId);
            dto.setSubject(subject);
            dto.setContent(content);
            
            messageService.sendMessage(userId, dto);
            return "redirect:/home";
        } catch (IllegalArgumentException e) {

            model.addAttribute("receiverError", "Invalid receiver selected!");
            return "new-message";
        } catch (Exception e) {

            model.addAttribute("error", "Error sending message: " + e.getMessage());
            return "new-message";
        }
    }
    
    @PostMapping("/messages/{messageId}")
    public String deleteSentMessage(@PathVariable("messageId") UUID messageId, HttpSession session) {
        UUID userId = (UUID) session.getAttribute("user_id");
        User sender = userService.findById(userId);
        
        messageService.deleteSentMessage(messageId, sender);
        
        return "redirect:/home";
    }
    
    @PostMapping("/messages/received/{messageId}")
    public String deleteReceivedMessage(@PathVariable("messageId") UUID messageId, HttpSession session) {
        UUID userId = (UUID) session.getAttribute("user_id");
        User receiver = userService.findById(userId);
        
        messageService.deleteReceivedMessage(messageId, receiver);
        
        return "redirect:/home";
    }
} 