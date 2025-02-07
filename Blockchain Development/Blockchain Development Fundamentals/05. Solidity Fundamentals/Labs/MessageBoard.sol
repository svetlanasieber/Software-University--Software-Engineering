// SPDX-License-Identifier: MIT
pragma solidity 0.8.28;

contract MessageBoard {

    mapping(address => string) messages;

    function storeMessage(string calldata message) external {
        messages[msg.sender] = message;
    }

    function previewMessage(string calldata message) external pure returns (string memory) {
        return string.concat("Draft: ", message); 
    }
}
