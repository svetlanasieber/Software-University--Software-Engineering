// SPDX-License-Identifier: MIT
pragma solidity 0.8.28;

// A basic voting eligibility checker for an election, where only citizens aged 18 or older are eligible to vote. 

contract VotingEligibilityChecker {
    
    uint8 public votingEligibilityChecker = 18;

    function checkEligibility (uint8 voterAge) external view returns (bool isEligible) {
        if (voterAge < votingEligibilityChecker) {
            revert("Not eligible to vote");
        }
        isEligible = true;
    }
}
