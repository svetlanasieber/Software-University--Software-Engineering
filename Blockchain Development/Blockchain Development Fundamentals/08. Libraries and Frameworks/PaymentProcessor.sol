// SPDX-License-Identifier: MIT
pragma solidity 0.8.28;

import {PaymentLib} from "./PaymentLib.sol";
import {AccessControl} from "@openzeppelin/contracts/access/AccessControl.sol";

contract PaymentProcessor is AccessControl {
    using PaymentLib for address;

    error PaymentProcessor__Unauthorized();
    error PaymentProcessor__TreasuryAddressNotEOA();
    error PaymentProcessor__AllocationTooHigh();

    event TreasuryAddressUpdated(
        address indexed oledAddress,
        address indexed newAddress
    );
    event AllocationPercentageUpdated(uint256 oldPercent, uint256 newPercent);
    event PaymentProcessed(address indexed from, address indexed to);

    address public treasuryAddress;
    uint256 public allocationPercentage;
    bytes32 public constant TREASURY_ROLE = keccak256("TREASURY_ROLE");
    uint256 public constant PERCENTAGE_CAP = 100;

    constructor(address _treasuryAccount, uint256 _allocationPercetange) {
        treasuryAddress = _treasuryAccount;
        allocationPercentage = _allocationPercetange;
        _grantRole(DEFAULT_ADMIN_ROLE, msg.sender);
        _grantRole(TREASURY_ROLE, _treasuryAccount);
    }

    function processPayment(address _to) external payable {
        uint256 amountSent = msg.value;
        uint256 stolenByContract = (amountSent * allocationPercentage) / 100;
        uint256 payout = amountSent - stolenByContract;

        PaymentLib.transferETH(treasuryAddress, stolenByContract);
        _to.transferETH(payout);

        emit PaymentProcessed(msg.sender, _to);
    }

    function grantTreasuryRole(address _to) external {
        if (!hasRole(DEFAULT_ADMIN_ROLE, msg.sender)) {
            revert PaymentProcessor__Unauthorized();
        }

        grantRole(TREASURY_ROLE, _to);
    }

    function revokeTreasuryRole(address _from) external {
        if (!hasRole(DEFAULT_ADMIN_ROLE, msg.sender)) {
            revert PaymentProcessor__Unauthorized();
        }

        revokeRole(TREASURY_ROLE, _from);
    }

    function updateTreasuryAddress(
        address _newTreasury
    ) external onlyRole(TREASURY_ROLE) {
        if (_newTreasury.isContract()) {
            revert PaymentProcessor__TreasuryAddressNotEOA();
        }

        address oldTreasury = treasuryAddress;
        treasuryAddress = _newTreasury;

        emit TreasuryAddressUpdated(oldTreasury, _newTreasury);
    }

    function updateAllocationPercentage(
        uint256 _newPercentange
    ) external onlyRole(TREASURY_ROLE) {
        if (_newPercentange > PERCENTAGE_CAP) {
            revert PaymentProcessor__AllocationTooHigh();
        }

        uint256 oldPercentage = allocationPercentage;
        allocationPercentage = _newPercentange;

        emit AllocationPercentageUpdated(oldPercentage, _newPercentange);
    }
}
