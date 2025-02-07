// SPDX-License-Identifier: MIT
pragma solidity 0.8.26;


error RatingOutOfRange();

contract Payroll {
    // Adds a 10% bonus to the salary if the performance rating is above 8 (out of 10).
    function calculatePaycheck(uint256 salary, uint256 rating) external pure returns (uint paycheck) {
        require(salary > 0, "Salary should be positive number");

        if (rating > 10) {
            revert RatingOutOfRange();
        } else if (rating <= 8) {
            return salary;  // No bonus if rating is 8 or below
        } else {
            // Add a 10% bonus
            uint256 bonus = (salary * 10) / 100;
            return salary + bonus;
        }
    }
}
