package app.web.dto;

import app.subscription.model.SubscriptionPeriod;
import app.subscription.model.SubscriptionStatus;
import app.subscription.model.SubscriptionType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubscriptionHistory {

    private UUID id;
    private SubscriptionType type;
    private SubscriptionStatus status;
    private SubscriptionPeriod period;
    private BigDecimal price;
    private LocalDateTime start;
    private LocalDateTime end;
}
