// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract GoalTracker {
    uint256 public goal;
    uint256 public reward;
    uint256 public spending;
    bool public rewardClaimed;

    error GoalNotMet();
    error RewardAlreadyClaimed();

    constructor(uint256 _goal, uint256 _baseReward) {
        goal = _goal;
        reward = _baseReward;
        spending = 0;
        rewardClaimed = false;
    }

    function addSpending(uint256 amount) public {
        require(amount > 0, "Amount must be positive");
        spending += amount;
    }

    function claimReward() public {
        if (spending < goal) revert GoalNotMet();
        if (rewardClaimed) revert RewardAlreadyClaimed();

        for (uint256 i = 0; i < 5; i++) {
            reward += reward;
        }

        rewardClaimed = true;
    }
}
