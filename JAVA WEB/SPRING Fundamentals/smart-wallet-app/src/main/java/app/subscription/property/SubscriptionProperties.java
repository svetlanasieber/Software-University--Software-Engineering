package app.subscription.property;

import app.subscription.model.SubscriptionPeriod;
import app.subscription.model.SubscriptionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "domain.subscription.properties")
public class SubscriptionProperties {

    @NotNull
    private SubscriptionPeriod defaultPeriod;

    @NotNull
    private Map<SubscriptionType, UpgradeOption> upgradeOptions;

    @Data
    public static class UpgradeOption {

        @NotNull
        @Size(min = 1)
        private List<String> benefits;

        @NotNull
        private BigDecimal monthlyPrice;

        @NotNull
        private BigDecimal yearlyPrice;
    }
}
