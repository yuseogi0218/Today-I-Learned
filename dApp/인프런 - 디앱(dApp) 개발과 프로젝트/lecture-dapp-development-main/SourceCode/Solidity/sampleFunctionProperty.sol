// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleFunctionProperty {
    uint public numGlobal = 10;

    function functionNone() public returns(uint) {
        numGlobal = 1;
        return numGlobal + 1;
    }

    function functionView() public view returns(uint) {
        return numGlobal + 1;
    }

    function functionPure() public pure returns(uint) {
        return 10 + 1;
    }
}
