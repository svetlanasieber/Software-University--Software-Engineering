// SPDX-License-Identifier: MIT
pragma solidity 0.8.27;

// Unfinished examples. DO NOT USE IN PRODUCTION!!!

contract MessageBoard {
    mapping(address => string[]) public messages;

    function keepMessages(string calldata message) external {
        messages[msg.sender].push(message);
    }

    function previewMessage(
        string calldata message
    ) external pure returns (string memory) {
        return string(abi.encodePacked("Draft: ", message));
    }
}
