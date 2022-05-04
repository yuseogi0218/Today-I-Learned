// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract C {
    // 상태변수의 기본 값 (name :: Storage)
    bytes[] names;

    function sampleDataLocation(bytes[] memory newNames) public {
        // 동작, newNames 배열을 names에 복사
        // 참조, names는 Storage 형태로 해당 변수에 들어간 모든 값은 블록체인으로 업로드
        names = newNames; 

        // 동작, 선언된 로컬 변수의 포인터 생성
        // 참조, editNames의 값을 변경하면 names의 값도 변경
        bytes[] storage editNames = names;

        // 동작, 로컬 변수에 admin 선언
        // 참조, 함수 종료 시 삭제되는 상태 변수
        bytes memory myName = "admin";

        
        // 동작, editNames의 0번을 myName 값으로 수정
        // 참조, names의 포인터 값인 editNames 수정 시 names의 값 변경
        editNames[0] = myName;
    }
}