package bg.softuni.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public class Transfer {
    private User sender;
    private User receiver;

    private BigDecimal amount;
    private LocalDate createdAt;
    private Instant updatedAt;

    public Transfer() {}

    public Transfer(User sender, User receiver, BigDecimal amount, LocalDate createdAt, Instant updatedAt) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
