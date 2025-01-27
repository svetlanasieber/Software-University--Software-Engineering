package app.web.dto;

import app.subscription.model.SubscriptionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class UpgradeOption {

    private SubscriptionType type;
    private List<String> benefits;
    private BigDecimal monthlyPrice;
    private BigDecimal yearlyPrice;
    private boolean isChoosable;
}
