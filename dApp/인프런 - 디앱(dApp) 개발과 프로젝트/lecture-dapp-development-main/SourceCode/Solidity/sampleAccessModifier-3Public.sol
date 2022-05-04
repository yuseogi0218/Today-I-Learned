// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleAccessModifier {
    // 동작, internal 함수 호출
    function call_1() public {
        test();
    }

    function test() public {
        // ...
    }
}


contract sampleAccessModifier_2 {
    // 동작, sampleAccessModifier 컨트랙 호출
    sampleAccessModifier SampleAccessModifier;

    // 동작, internal 함수 호출
    function call_2() public {
        SampleAccessModifier.test();
    }
}