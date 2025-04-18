package app.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class MessageSendDTO {

    @NotNull(message = "You must select a receiver!")
    private UUID receiverId;

    @NotBlank
    @Size(min = 5, max = 15, message = "Subject length must be between 5 and 15 characters!")
    private String subject;

    @NotBlank
    @Size(min = 10, max = 100, message = "Content length must be between 10 and 100 characters!")
    private String content;

    public MessageSendDTO() {
    }

    public UUID getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(UUID receiverId) {
        this.receiverId = receiverId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
} 