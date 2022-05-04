// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleOperator {
    event checkBool(bool _value);

    function call() public {
        emit checkBool(true);           // true
        emit checkBool(!true);          // false
        emit checkBool(true && false);  // false
        emit checkBool(true || false);  // true
    }
}
