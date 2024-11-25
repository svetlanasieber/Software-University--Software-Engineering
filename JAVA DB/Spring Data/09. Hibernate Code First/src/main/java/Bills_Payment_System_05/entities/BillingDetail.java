package Bills_Payment_System_05.entities;

import Bills_Payment_System_05.enums.BillingDetailType;

import javax.persistence.*;

@Entity(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public class BillingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int number;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    @Enumerated(EnumType.STRING)
    protected BillingDetailType type;

    public BillingDetail() {
    }
    public BillingDetail(int number, User owner, BillingDetailType type) {
        this.number = number;
        this.owner = owner;
        this.type = type;
    }

}
