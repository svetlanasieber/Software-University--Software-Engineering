package app.wallet.property;

import app.wallet.model.WalletStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "domain.wallet.properties")
public class WalletProperties {

    @Valid
    @NotNull
    private DefaultWalletProperty defaultWalletProperties;

    @Data
    public static class DefaultWalletProperty {

        @NotNull
        @Min(0)
        private BigDecimal initialBalance;

        @NotNull
        private WalletStatus defaultStatus;
    }
}
