// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleOperator {
    event checkUint(uint _value);

    function call() public {
        emit checkUint(1 & 1);
        emit checkUint(1 | 1);
        emit checkUint(1 ^ 1);
    }
}
