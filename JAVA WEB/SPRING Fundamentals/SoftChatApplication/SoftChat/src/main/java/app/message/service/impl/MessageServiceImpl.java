package app.message.service.impl;

import app.message.model.Message;
import app.message.repository.MessageRepository;
import app.message.service.MessageService;
import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.MessageSendDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserService userService;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    @Override
    public Message sendMessage(UUID senderId, MessageSendDTO messageSendDTO) {
        User sender = userService.findById(senderId);
        User receiver = userService.findById(messageSendDTO.getReceiverId());

        Message message = new Message();
        message.setSubject(messageSendDTO.getSubject());
        message.setContent(messageSendDTO.getContent());
        message.setSentOn(LocalDateTime.now());
        message.setSender(sender);
        message.setReceiver(receiver);

        return messageRepository.save(message);
    }

    @Override
    public List<Message> findSentMessages(User sender) {
        return messageRepository.findBySenderOrderBySentOnDesc(sender);
    }

    @Override
    public List<Message> findReceivedMessages(User receiver) {
        return messageRepository.findByReceiverOrderBySentOnDesc(receiver);
    }

    @Override
    @Transactional
    public void deleteSentMessage(UUID messageId, User sender) {
        messageRepository.deleteByIdAndSender(messageId, sender);
    }

    @Override
    @Transactional
    public void deleteReceivedMessage(UUID messageId, User receiver) {
        messageRepository.deleteByIdAndReceiver(messageId, receiver);
    }
} 