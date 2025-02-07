// SPDX-License-Identifier: MIT
pragma solidity 0.8.28;

library PaymentLib {
    error PaymentLib__InsufficientBalance();
    error PaymentLib__CouldNotSendEthToZeroAddress();
    error PaymentLib__TransferFailed();

    function transferETH(address _to, uint256 _amount) internal {
        if (_to == address(0)) {
            revert PaymentLib__CouldNotSendEthToZeroAddress();
        }

        if (address(this).balance < _amount) {
            revert PaymentLib__InsufficientBalance();
        }

        (bool success, ) = _to.call{value: _amount}("");
        if (!success) {
            revert PaymentLib__TransferFailed();
        }
    }

    function isContract(address account) internal view returns (bool) {
        return !(account.code.length == 0);
    }
}
