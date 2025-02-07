// SPDX-License-Identifier: MIT
pragma solidity 0.8.26;

// Building a savings account contract that automates compound interest calculations.
// The contract calculates the future balance of a principal amount after applying annual compounding interest over a specified number of years.
// Each year, interest is calculated based on the current balance and added for the next year’s calculation.
// Formula: A = P * (1 + r/100)^n.

contract InterestCalculator {
    function calculateCompoundInterest(
        uint256 principal,
        uint32 rate,
        uint32 num_of_years
    ) external pure returns (uint256 calculatedInterest) {
        require(principal != 0 && rate != 0, "Principal and rate must not be zero");

        uint256 factor = 1e18; // Scaling factor for precision
        uint256 scaledRate = (rate * factor) / 100; // Scale rate for precision
        uint256 compoundInterest = principal;

        for (uint32 i = 0; i < num_of_years; i++) {
            compoundInterest =
                (compoundInterest * (factor + scaledRate)) /
                factor;
        }

        return compoundInterest;
    }
}
