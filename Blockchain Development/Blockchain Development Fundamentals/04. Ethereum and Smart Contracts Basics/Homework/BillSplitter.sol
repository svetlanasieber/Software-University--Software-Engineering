// SPDX-License-Identifier: MIT
pragma solidity 0.8.26;

error NotPossibleToSplitEvenly();

contract BillSplitter {

    function splitExpense(uint256 totalAmount, uint256 numPeople) external pure returns (uint256 billShare) {
        require(numPeople > 0 && totalAmount > 0, "Inputs should be above zero");
        uint256 factor = 1e18;
        uint256 scalledBillPerPerson = (totalAmount * factor) / numPeople;
    
        if (scalledBillPerPerson % factor == 0) {
            return scalledBillPerPerson / factor;
        } else {
            revert NotPossibleToSplitEvenly();
        }
    }
}
