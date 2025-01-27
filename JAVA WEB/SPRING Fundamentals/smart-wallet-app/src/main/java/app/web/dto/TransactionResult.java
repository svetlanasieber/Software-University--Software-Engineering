package app.web.dto;

import app.transaction.model.TransactionStatus;
import app.transaction.model.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

@Data
@Builder
public class TransactionResult {

    private UUID id;
    private TransactionStatus status;
    private String description;
    private BigDecimal amount;
    private BigDecimal balanceLeft;
    private Currency currency;
    private TransactionType type;
    private String failureReason;
    private LocalDateTime createdOn;
}
