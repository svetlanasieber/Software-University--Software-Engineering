// SPDX-License-Identifier: MIT
pragma solidity 0.8.28;

// simple loan interest calculator that calculates the total loan payment based on the principal, interest rate, and loan period.
// ● interestRate should be between 0 and 100.
// ● loanPeriod should be at least 1 year.
// Example: If a user inputs an interest rate above 100% or a loan period of less than 1 year,
// the contract reverts with the custom error.
// Uses the simple interest formula: Total = Principal + (Principal * Rate * Years / 100) to calculate the total amount payable.

contract LoanCalculator{

    error InterestRate(string message);
    error LoanPeriod(string message);

    function calculateTotalPayable(uint256 principal, uint8 interestRate, uint8 loanPeriod) external pure returns (uint256 amountPayable) {
        if (loanPeriod < 1) {
            revert LoanPeriod("Period should be at least 1 year");
        } else if (interestRate > 100) {
            revert InterestRate("Rate should be below 100");
        }
        uint256 factor = 1e18;
        uint256 scalledInterestPercentage = principal * interestRate * loanPeriod * factor / 100;
        amountPayable = principal + (scalledInterestPercentage / factor);
    }
}
