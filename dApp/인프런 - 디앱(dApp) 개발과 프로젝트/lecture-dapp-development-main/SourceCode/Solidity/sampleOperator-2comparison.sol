// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleOperator {
    event checkBool(bool _value);

    function call() public {
        emit checkBool(1 <= 1);  // true
        emit checkBool(1 < 10);  // true
        emit checkBool(1 == 1);  // true
        emit checkBool(1 != 1);  // false
        emit checkBool(1 >= 1);  // true
        emit checkBool(1 > 10);  // false
    }
}
