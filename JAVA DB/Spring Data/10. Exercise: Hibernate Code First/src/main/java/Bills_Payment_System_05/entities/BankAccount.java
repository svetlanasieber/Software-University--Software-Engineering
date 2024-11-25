package Bills_Payment_System_05.entities;

import Bills_Payment_System_05.enums.BillingDetailType;

import javax.persistence.*;

@Entity(name = "bank_account")
public class BankAccount extends BillingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "swift_code", nullable = false)
    private String swiftCode;

    public BankAccount() {}
    public BankAccount(int number, User owner, String bankName, String swiftCode) {
        super(number, owner, BillingDetailType.BANK_ACCOUNT);
        this.bankName = bankName;
        this.swiftCode = swiftCode;
    }
}
