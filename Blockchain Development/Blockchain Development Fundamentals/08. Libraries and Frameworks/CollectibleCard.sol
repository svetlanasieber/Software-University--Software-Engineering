// SPDX-License-Identifier: MIT
pragma solidity 0.8.27;

struct Card {
    uint256 id;
    uint256 power;
    string name;
}

library CollectionLib {
    function exists(
        Card[] memory cards,
        uint256 id
    ) internal pure returns (bool doesExists) {
        uint256 cardsLength = cards.length;
        assert(cardsLength < 1000);

        for (uint256 i = 0; i < cardsLength; i++) {
            if (cards[i].id == id) {
                return true;
            }
        }
    }
}

contract CollectibleCardLibrary {
    using CollectionLib for Card[];

    mapping(address => Card[]) public collections;

    error AlreadyExists();

    function addCard(uint256 id, uint256 power, string calldata name) external {
        if (collections[msg.sender].exists(id)) {
            revert AlreadyExists();
        }

        collections[msg.sender].push(Card({id: id, power: power, name: name}));
    }
}
