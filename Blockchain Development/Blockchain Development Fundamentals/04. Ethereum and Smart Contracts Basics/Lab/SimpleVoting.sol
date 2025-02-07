// SPDX-License-Identifier: MIT
pragma solidity 0.8.26;

enum VotingOption { 
    CandidateOne,
    CandidateTwo
}

error InvalidCandidate();

contract SimpleVoting {
    // Here we delcare the storage variables which are persistent and are saved
    // in the node
    bool public votingEnded = false;

    address public candidate1;
    address public candidate2;

    uint256 public votesCandidateOne;
    uint256 public votesCandidateTwo;

    function vote(address candidate) public {
        
        require(!votingEnded, "Voting has already ended!");

        if (candidate == candidate1) {
            votesCandidateOne += 1;
        } else if (candidate ==  candidate2 ) {
            votesCandidateTwo++;
        } else {
            revert InvalidCandidate();
        }
    }
}
