// SPDX-License-Identifier: GPL-3.0
pragma solidity 0.8.28;

struct Card {
    uint256 id;
    uint256 power;
    string name;
}

library CollectionLab {
    function exists(
        Card[] memory cards,
        uint256 id
    ) internal pure returns (bool) {
        uint256 cardsLenght = cards.length;
        assert(cardsLenght < 1000);
        for (uint256 i = 0; i < cardsLenght; i++) {
            if (cards[i].id == id) {
                return true;
            }
        }
        return false;
    }
}

contract CollectibleCardLibrary {
    mapping(address => Card[]) collections;

    using CollectionLab for Card[];

    error AlreadyExists();

    function addCard(uint256 id, uint256 power, string calldata name) external {
        Card memory newCard = Card({id: id, power: power, name: name});
        if (collections[msg.sender].exists(id)) {
            revert AlreadyExists();
        }

        collections[msg.sender].push(newCard);
    }
}
