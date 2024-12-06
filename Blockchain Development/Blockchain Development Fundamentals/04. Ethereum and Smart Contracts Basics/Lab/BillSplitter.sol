// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BillSplitter {
    error UnevenSplit(string message);

    function splitExpense(uint256 totalAmount, uint256 numPeople) public pure returns (uint256) {
        require(totalAmount > 0, "Total amount must be positive");
        require(numPeople > 0, "Number of people must be greater than zero");

        if (totalAmount % numPeople != 0) {
            revert UnevenSplit("Total amount cannot be evenly split among people");
        }

        return totalAmount / numPeople;
    }
}
