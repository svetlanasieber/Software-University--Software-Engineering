package app.web.dto;

import lombok.*;

@Data
@Builder
public class UpgradeRequest {

    private String subscriptionType;

    private String subscriptionPeriod;

    private String walletId;
}
