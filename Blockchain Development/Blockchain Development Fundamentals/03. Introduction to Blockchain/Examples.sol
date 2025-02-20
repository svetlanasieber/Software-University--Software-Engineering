// SPDX-License-Identifier: MIT
pragma solidity 0.8.27;

// Unfinished examples. DO NOT USE IN PRODUCTION!!!

struct Vote {
    address shareholder;
    uint256 shares;
    uint256 timestamp;
}

error InsuficientAmount();

contract Crowdfunding {
    mapping(address => uint256) public shares;
    Vote[] public votes;
    uint256 public a;
    uint256 public sharePrice;
    uint256 public totalShares;

    constructor(uint256 _initialSharePrice) {
        sharePrice = _initialSharePrice; // Set initial share price
    }

    function buyShares() external payable {
        if (msg.value < sharePrice) {
            revert InsuficientAmount();
        }

        if (msg.value % sharePrice > 0) {
            revert InsuficientAmount();
        }

        uint256 sharesToReceive = msg.value / sharePrice;
        totalShares += sharesToReceive;
        shares[msg.sender] += sharesToReceive;
    }

    function vote(address holder) external {
        votes.push(
            Vote({
                shareholder: holder,
                shares: shares[holder],
                timestamp: block.timestamp
            })
        );
    }
}

struct Dog {
    uint256 weight;
    uint256 age;
}

contract Test {
    uint256[] public arr = [1];
    uint256 a = 5;

    Dog public bark;

    mapping(uint256 => uint256) map;
    string public stringOne = "Hello world";

    function checkRes() external view returns (uint256 x) {
        uint256[] memory arrRef = arr;
        arrRef[0] = 2;

        return arr[0];
    }

    function checkArr(uint256[] calldata _arr) external returns (uint256) {
        arr = _arr;

        return _arr[0];
    }

    function calculateResult(
        uint256[] calldata inputs
    ) external pure returns (uint256 result) {
        for (uint256 i = 0; i < inputs.length; i++) {
            result += inputs[i];
        }
    }

    function dynamicArr() external pure {
        uint256[] memory test1;

        test1[0];
    }

    function testString() external pure returns (string memory) {
        string memory hello = "Hello world!";
        return hello;
    }
}
