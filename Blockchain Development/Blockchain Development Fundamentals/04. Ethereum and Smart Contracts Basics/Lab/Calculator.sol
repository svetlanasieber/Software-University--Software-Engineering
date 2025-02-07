// SPDX-License-Identifier: MIT
pragma solidity 0.8.28;

// This task involves building a simple arithmetic calculator that performs basic operations: 
// addition, subtraction, multiplication, and division. 

contract ArithmeticCalculator {

    function add(int256 a, int256 b) external pure returns (int256) {
        return a + b;
    }
    
    function substract(int256 a, int256 b) external pure returns (int256) {
        return a - b;
    }

    function miltiply(int256 a, int256 b) external pure returns (int256) {
        return a * b;
    }

    function divide(int256 a, int256 b) external pure returns (int256) {
        require(a != 0 && b != 0, "Zero division not allowed");
        // Scalling for better accuracy
        int256 factor = 1e18;
        int256 scaledNum = a * factor;
        return (scaledNum / b) / factor;
    }
}
