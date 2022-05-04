// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleModifier {
    uint public num = 0;

    modifier setNum {
        _;
        num = 2;
    }

    function setNumFunc() public setNum {
        num = 4;
    }
}
