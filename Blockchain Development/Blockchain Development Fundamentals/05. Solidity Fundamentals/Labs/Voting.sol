// SPDX-License-Identifier: MIT
pragma solidity 0.8.28;

contract Voting {

    event VoterStatus(bool hasVoted, uint256 choise);

    struct Voter {
        bool hasVoted;
        uint256 choise;
    }

    mapping(address => Voter) votes;

    function registerVote(uint256 candidateId) external {
        votes[msg.sender] = Voter({
            hasVoted: true,
            choise: candidateId
        });
    }

    function getVoterStatus() external {
        emit VoterStatus(votes[msg.sender].hasVoted, votes[msg.sender].choise);
    }

}
