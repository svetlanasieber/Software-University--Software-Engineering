// SPDX-License-Identifier: MIT
pragma solidity 0.8.27;

import {ERC20} from "@openzeppelin/contracts/token/ERC20/ERC20.sol";

contract Crowdfunding is ERC20 {
    uint256 public immutable price;

    error InsuficientAmount();

    constructor(uint256 newPrice) ERC20("CrowdFund", "CF") {
        price = newPrice; // 1 part/share = 2 wei => 1 share => 2 ether
    }

    function buyShares() external payable {
        uint256 sharesToReceive = msg.value / price;
        _mint(msg.sender, sharesToReceive);
    }
}
