// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleAccessModifier {
    // 실패, 상태 변수 (count :: external)
    // 참조, 상태 변수에는 external 사용 불가능
    uint external count;

    // 동작, 상태 변수 (count :: internal)
    // 참조, 상태 변수에는 기본 값 internal
    uint count;
}
