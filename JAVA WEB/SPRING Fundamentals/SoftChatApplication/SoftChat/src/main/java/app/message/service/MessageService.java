package app.message.service;

import app.message.model.Message;
import app.user.model.User;
import app.web.dto.MessageSendDTO;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    
    Message sendMessage(UUID senderId, MessageSendDTO messageSendDTO);
    
    List<Message> findSentMessages(User sender);
    
    List<Message> findReceivedMessages(User receiver);
    
    void deleteSentMessage(UUID messageId, User sender);
    
    void deleteReceivedMessage(UUID messageId, User receiver);
} 