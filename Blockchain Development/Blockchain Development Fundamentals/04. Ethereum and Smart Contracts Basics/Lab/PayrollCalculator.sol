// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract PayrollCalculator {
    error InvalidInput(string message);

    function calculatePaycheck(uint256 salary, uint256 rating) public pure returns (uint256) {
        if (salary <= 0) revert InvalidInput("Salary must be positive");
        if (rating < 0 || rating > 10) revert InvalidInput("Rating must be between 0 and 10");

        uint256 paycheck = salary;
        if (rating > 8) {
            paycheck += (salary * 10) / 100;
        }

        return paycheck;
    }
}
