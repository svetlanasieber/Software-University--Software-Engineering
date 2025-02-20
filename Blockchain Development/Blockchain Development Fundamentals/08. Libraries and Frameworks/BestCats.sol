// SPDX-License-Identifier: MIT
pragma solidity 0.8.27;

import {ERC721} from "@openzeppelin/contracts/token/ERC721/ERC721.sol";

contract BestCats is ERC721 {
    constructor() ERC721("BestCats", "BS") {}

    uint256 public constant maxSupply = 12;
    uint256 constant price = 0.5 ether;
    uint256 nextToken;

    function _baseURI() internal pure override returns (string memory) {
        return "http://bestcats.com/cats/";
    }

    // DO NOT USE IN PRODUCTION - just a simple example
    function buyNFT() external payable {
        require(msg.value == price, "Insufficient value");

        _mint(msg.sender, nextToken);
        nextToken++;
    }

    function tokenURI(
        uint256 tokenId
    ) public view override returns (string memory) {
        return string.concat(super.tokenURI(tokenId), ".json");
    }
}
