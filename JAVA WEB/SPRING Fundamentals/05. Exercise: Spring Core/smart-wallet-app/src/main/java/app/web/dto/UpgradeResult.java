package app.web.dto;

import app.subscription.model.Subscription;
import app.transaction.model.Transaction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpgradeResult {

    private Transaction transaction;
    private Subscription oldSubscription;
    private Subscription newSubscription;
}
