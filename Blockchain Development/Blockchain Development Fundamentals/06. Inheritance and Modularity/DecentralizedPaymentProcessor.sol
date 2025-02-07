// SPDX-License-Identifier: GPL-3.0
pragma solidity 0.8.28;

contract PaymentProcessor {
    struct Transaction {
        address sender;
        address receiver;
        uint256 amount;
        bool isRefunded;
    }

    uint256 private txnId;

    // User to balance
    mapping(address => uint256) public balances;
    // Payment ID to specific transaction
    mapping(uint256 => Transaction) transactions;

    event PaymentSuccess(
        uint256 txnId,
        address sender,
        address receiver,
        uint256 amount
    );
    event RefundSuccess(address receiver, uint256 amount);

    function transfer(
        address _receiver
    )
        public
        payable
        nonZeroAmount(msg.value)
        isSelfPayment(_receiver)
        returns (uint256)
    {
        txnId += 1;

        transactions[txnId] = Transaction({
            sender: msg.sender,
            receiver: _receiver,
            amount: msg.value,
            isRefunded: false
        });

        balances[_receiver] += msg.value;

        emit PaymentSuccess(txnId, msg.sender, _receiver, msg.value);
        return txnId;
    }

    function checkBalance() public view returns (uint256 currentBalance) {
        currentBalance = balances[msg.sender];
    }

    // Possible refund only if the amount is still available at the receiver
    function refundPayment(
        uint256 _txnId
    )
        public
        payable
        virtual
        isTxn(_txnId)
        isEligible(_txnId)
        isDuplicateRefund(_txnId)
        userHasAmount(
            transactions[_txnId].amount,
            transactions[_txnId].receiver
        )
    {
        Transaction memory _txn = transactions[_txnId];

        balances[_txn.receiver] -= _txn.amount;
        balances[_txn.sender] += _txn.amount;
        transactions[_txnId].isRefunded = true;

        emit RefundSuccess(msg.sender, _txn.amount);
    }

    // Txn with zero amount is invalid, thus, no such txn exist
    modifier isTxn(uint256 _txnId) {
        require(transactions[_txnId].amount != 0, "Invalid txn");
        _;
    }

    modifier isSelfPayment(address _receiver) {
        require(_receiver != msg.sender, "Selfpayment is impossible");
        _;
    }

    modifier isEligible(uint256 _txnId) {
        require(transactions[_txnId].sender == msg.sender, "Not authorized");
        _;
    }

    modifier isDuplicateRefund(uint256 _txnId) {
        require(transactions[_txnId].isRefunded == false, "Duplicate refund");
        _;
    }

    modifier userHasAmount(uint256 _amount, address _user) {
        require(balances[_user] >= _amount, "Not enough balance");
        _;
    }

    modifier nonZeroAmount(uint256 _amount) {
        require(_amount != 0, "Zero transfer");
        _;
    }
}

contract Merchant is PaymentProcessor {
    address public owner;

    constructor() {
        owner = msg.sender;
    }

    uint8 public loyaltyBonus;
    mapping(address => bool) public loyality;

    event NewLoyalCustomerSuccess();

    function setLoyal(address _customer) public onlyOwner {
        loyality[_customer] = true;

        emit NewLoyalCustomerSuccess();
    }

    function setLoyaltyBonus(
        uint8 percentage
    ) public nonZeroAmount(percentage) maxPercentage(percentage) onlyOwner {
        loyaltyBonus = percentage;
    }

    function refundPayment(
        uint256 _txnId
    )
        public
        payable
        override
        isTxn(_txnId)
        isEligible(_txnId)
        isDuplicateRefund(_txnId)
        userHasAmount(
            transactions[_txnId].amount,
            transactions[_txnId].receiver
        )
    {
        Transaction memory _txn = transactions[_txnId];

        balances[_txn.receiver] -= _txn.amount;

        if (loyality[msg.sender]) {
            balances[_txn.sender] += getRefundAmountWithBonus(_txn.amount);
        } else {
            balances[_txn.sender] += _txn.amount;
        }

        transactions[_txnId].isRefunded = true;

        emit RefundSuccess(msg.sender, _txn.amount);
    }

    function getRefundAmountWithBonus(
        uint256 _amount
    ) internal view returns (uint256) {
        uint256 factor = 1e18;
        uint256 scalledPercentage = (_amount * loyaltyBonus * factor) / 100;
        return _amount + (scalledPercentage / factor);
    }

    modifier onlyOwner() {
        require(msg.sender == owner, "Only owner can set loyalty");
        _;
    }

    modifier maxPercentage(uint8 _percentage) {
        require(_percentage <= 100, "Invalid percentage");
        _;
    }
}
