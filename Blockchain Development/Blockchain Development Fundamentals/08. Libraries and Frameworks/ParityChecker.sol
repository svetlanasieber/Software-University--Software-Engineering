// SPDX-License-Identifier: GPL-3.0
pragma solidity 0.8.28;

library NumLib {
    function isEven(uint256 self) internal pure returns (bool) {
        // "self" is the data/value on which the method will be called
        return self % 2 == 0;
    }
}

contract ParityChecker {
    using NumLib for uint256;

    function checkParity(uint256 num) public pure returns (bool) {
        return num.isEven();
    }
}
