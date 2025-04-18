package app.message.repository;

import app.message.model.Message;
import app.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

    List<Message> findBySenderOrderBySentOnDesc(User sender);
    
    List<Message> findByReceiverOrderBySentOnDesc(User receiver);
    
    void deleteByIdAndSender(UUID id, User sender);
    
    void deleteByIdAndReceiver(UUID id, User receiver);
} 