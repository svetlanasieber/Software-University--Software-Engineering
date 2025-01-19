package app.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class TransferRequest {

    private UUID fromWalletId;
    @NotNull
    private String toUsername;
    @NotNull
    @Positive
    private BigDecimal amount;
}
