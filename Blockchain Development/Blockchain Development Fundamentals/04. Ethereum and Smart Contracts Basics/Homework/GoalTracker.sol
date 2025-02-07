// SPDX-License-Identifier: MIT
pragma solidity 0.8.26;

contract GoalTracker {
    uint256 public goal = 1000;
    uint256 public reward = 20;
    uint8 public baseStepPointsForReward = 200;

    bool private isClaimed = false;

    error AlreadyClaimedReward();
    error UserHasNoSpending();

    mapping(address => uint256) userToSpending;
    mapping(address => bool) userToClaimedReward;

    function setGoalTrackerProperties(
        uint256 setGoal,
        uint256 setReward,
        uint8 setStepForRewardPoints
    ) external {
        require(
            setGoal > 0 && setReward > 0 && setStepForRewardPoints > 0,
            "Inputs should be above zero"
        );

        goal = setGoal;
        reward = setReward;
        baseStepPointsForReward = setStepForRewardPoints;
    }

    function AddSpending(uint256 sumSpent) external {
        userToSpending[msg.sender] += sumSpent;
    }

    function ClaimReward() external returns (uint256) {
        // Revert tx if reward is already claimed
        if (userToClaimedReward[msg.sender]) {
            revert AlreadyClaimedReward();
        // Revert tx if user has no spending
        } else if (userToSpending[msg.sender] == 0) {
            revert UserHasNoSpending();
        // Accrue reward
        } else {
            uint256 accumulatedReward;
            uint256 tempSpending = userToSpending[msg.sender];
            for (uint256 i; tempSpending > 0; i++) {
                if (tempSpending > 0) {
                    accumulatedReward += reward;
                    tempSpending -= baseStepPointsForReward;
                } else {
                    break;
                }
            }
            userToClaimedReward[msg.sender] = true;
            return accumulatedReward;
        }
    }
}
