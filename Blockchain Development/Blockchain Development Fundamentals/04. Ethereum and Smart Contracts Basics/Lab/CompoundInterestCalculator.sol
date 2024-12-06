// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract CompoundInterestCalculator {
    function calculateCompoundInterest(
        uint256 principal,
        uint256 rate,
        uint256 years
    ) public pure returns (uint256) {
        require(principal > 0, "Principal must be positive");
        require(rate > 0 && rate <= 100, "Rate must be between 0 and 100");
        require(years > 0, "Years must be positive");

        uint256 amount = principal;
        for (uint256 i = 0; i < years; i++) {
            amount += (amount * rate) / 100;
        }

        return amount;
    }
}
