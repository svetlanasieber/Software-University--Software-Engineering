// SPDX-License-Identifier: MIT
pragma solidity 0.8.27;

error InsufficientBalance();
error InsufficientApproval();

import "hardhat/console.sol";

contract ERC20 {
    string public name;
    string public symbol;
    uint8 public decimals = 3; // 1000 => 1 token; 1500 / 10**decimals => 1.5 tokens
    uint256 public totalSupply;
    mapping(address => uint256) public balanceOf;
    // approver => spender => amount
    mapping(address => mapping(address => uint256)) public allowance;

    address public owner;

    constructor(string memory newName, string memory newSymbol) {
        console.log("name");
        console.log(newName);

        name = newName;
        symbol = newSymbol;

        uint256 supply = 1000 * 10 ** decimals;
        balanceOf[msg.sender] = supply;
        totalSupply = supply;
        owner = msg.sender;
    }

    event Transfer(address indexed _from, address indexed _to, uint256 _value);
    event Approval(
        address indexed _owner,
        address indexed _spender,
        uint256 _value
    );

    function transfer(
        address _to,
        uint256 _value
    ) public returns (bool success) {
        if (balanceOf[msg.sender] < _value) {
            revert InsufficientBalance();
        }

        balanceOf[msg.sender] -= _value;
        balanceOf[_to] += _value;

        emit Transfer(msg.sender, _to, _value);

        return true;
    }

    function transferFrom(
        address _from,
        address _to,
        uint256 _value
    ) public returns (bool success) {
        if (allowance[_from][msg.sender] < _value) {
            revert InsufficientApproval(); // return false
        }

        allowance[_from][msg.sender] -= _value;

        if (balanceOf[_from] < _value) {
            revert InsufficientBalance(); // return false
        }

        balanceOf[_from] -= _value;
        balanceOf[_to] += _value;

        emit Transfer(_from, _to, _value);

        return true;
    }

    function approve(
        address _spender,
        uint256 _value
    ) public returns (bool success) {
        allowance[msg.sender][_spender] = _value;

        emit Approval(msg.sender, _spender, _value);

        return true;
    }

    function mint(address _to, uint256 _value) external {
        if (msg.sender != owner) {
            revert("Not owner");
        }

        balanceOf[_to] += _value;
        totalSupply += _value;

        emit Transfer(address(0), _to, _value);
    }

    function burn(uint256 _value) external {
        if (balanceOf[msg.sender] > _value) {
            revert InsufficientBalance();
        }

        balanceOf[msg.sender] -= _value;
        totalSupply -= _value;

        emit Transfer(msg.sender, address(0), _value);
    }
}
