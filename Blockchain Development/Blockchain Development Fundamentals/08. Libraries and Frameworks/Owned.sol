// SPDX-License-Identifier: MIT
pragma solidity 0.8.27;

import "@openzeppelin/contracts/access/Ownable.sol";

contract MyContract is Ownable {
    constructor() Ownable(msg.sender) {}

    function normalThing() public {
        // Anyone can call
    }

    function specialThing() public onlyOwner {
        // Only the owner can call
    }
}
