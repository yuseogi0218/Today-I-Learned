// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleAccessModifier {
    function call_1() public {
        test();
    }

    function test() private {
        // ...
    }
}


contract sampleAccessModifier_2 is sampleAccessModifier {
    function call_2() public {
        // 실패, Private 함수를 불러올 수 없음
        // 참조, 호출한 컨트랙에서는 Private 미동작
        test();
    }
}

contract sampleAccessModifier_3 {
    sampleAccessModifier SampleAccessModifier;

    function call_3() public {
        // 동작, Private 함수 호출
        // 참조, 상속받은 컨트랙에서는 Private 동작
        SampleAccessModifier.test();
    }
}


