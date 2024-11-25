package Bills_Payment_System_05.entities;

import Bills_Payment_System_05.enums.BillingDetailType;

import javax.persistence.*;

@Entity(name = "credit_card")
public class CreditCard extends BillingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_type", nullable = false)
    private String cardType;

    @Column(name = "expiration_month", nullable = false)
    private String expirationMonth;

    @Column(name = "expiration_year", nullable = false)
    private String expirationYear;

    public CreditCard() {}
    public CreditCard(int number, User owner, String cardType, String expirationMonth, String expirationYear) {
        super(number, owner, BillingDetailType.CREDIT_CARD);
        this.cardType = cardType;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }
}
