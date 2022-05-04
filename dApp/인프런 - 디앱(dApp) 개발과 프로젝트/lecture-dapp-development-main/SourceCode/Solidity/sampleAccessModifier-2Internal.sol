// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleAccessModifier {
    function call_1() public {
        test();
    }

    function test() internal {
        // ...
    }
}


contract sampleAccessModifier_2 is sampleAccessModifier {
    function call_2() public {
        test();
    }
}