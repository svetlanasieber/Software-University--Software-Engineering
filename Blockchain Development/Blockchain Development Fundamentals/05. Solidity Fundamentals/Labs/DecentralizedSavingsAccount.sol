// SPDX-License-Identifier: MIT
pragma solidity 0.8.28;

contract DecentralizedSavingsAccount {

    struct SavingsAccount {
        uint256 balance;
        address owner;
        uint256 creationTime;
        uint256 lockPeriod;
    }
    
    mapping(address => SavingsAccount[]) public savings;

    event SavingsPlanCreated (uint256 balance, address owner, uint256 lockPeriod);
    event ViewSavingsPlan(
        uint256 balance,
        address owner,
        uint256 creationTime,
        uint256 lockPeriod
    );

    error LockAccountPeriodNotExpired();

    function createSavingsPlan(uint256 lockPeriod) external payable {
        require(msg.value >= 1 wei, "Minimum 1 wei required");

        SavingsAccount memory newAcc = SavingsAccount({
            balance: msg.value,
            owner: msg.sender,
            creationTime: block.timestamp,
            lockPeriod: lockPeriod
        });

        savings[msg.sender].push(newAcc);

        emit SavingsPlanCreated(newAcc.balance, newAcc.owner, newAcc.lockPeriod);
    }

    function viewSavingsPlan(uint256 savingsPlanIndex) external {
        require(savings[msg.sender].length != 0, "Not an owner of savings account");
        
        SavingsAccount memory acc = savings[msg.sender][savingsPlanIndex];

        emit ViewSavingsPlan(
            acc.balance,
            acc.owner,
            acc.creationTime,
            acc.lockPeriod);
    }

    function isLockPeriodExpired(uint256 savingsPlanIndex) internal view returns (bool) {
        require(savings[msg.sender].length != 0, "Not an owner of savings account");
        
        SavingsAccount memory acc = savings[msg.sender][savingsPlanIndex];

        return (acc.lockPeriod + acc.creationTime) >= block.timestamp;
    }

    function withdrawFunds(uint256 savingsPlanIndex, uint256 amount) external payable {
        require(savings[msg.sender].length != 0, "Not an owner of savings account");

        if (isLockPeriodExpired(savingsPlanIndex)) {
            revert LockAccountPeriodNotExpired();
        } else {
            require(savings[msg.sender][savingsPlanIndex].balance >= amount, "Insufficient balance");

            savings[msg.sender][savingsPlanIndex].balance -= amount;
            
            (bool success, ) = msg.sender.call{value: amount}("");
            require(success, "Transfer failed");
        }
    }
}
