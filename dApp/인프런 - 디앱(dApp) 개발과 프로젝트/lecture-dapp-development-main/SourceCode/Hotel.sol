// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0; // solidity 버전 명시

contract HotelRoom {
    // 방의 예약 상태
    enum Status {
        Vacant,  // 예약 X
        Occupied // 예약 O
    }

    Status currentStatus; // 방의 예약 상태 저장 변수

    // 방 예약 정보 확인 (예약자 지갑 주소, 예약 금액)
    event Occupy(address _occupant, uint _value);

    // 방 주인(배포자)의 지갑의 주소
    address public owner;

    
    constructor() public {
        // 방 예약 상태 초기화
        currentStatus = Status.Vacant; 
        
        // 방 주인 초기화 - 해당 contract 를 배포하는 배포자의 주소
        owner = msg.sender;
    }

    // 해당 방이 예약 되어있는지 확인하는 modifier
    // receive() 이전에 실행
    modifier checkVacant {
        // 예약X가 아니라면 예외 발생 - msg : "currently occupied"
        require(currentStatus == Status.Vacant, "currently occupied");
        _;
    }

    // 방 예약 금액 확인 및 최소 금액 설정
    modifier checkCost(uint _amount) {
        // 최소 금액 설정
        require(msg.value >= _amount, "Not enough Ether provided");
        _;
    }

    // 방 예약 기능
    // external : 외부에서만 접근 가능
    // payable : 이더리움 전송 기능
    receive() external payable checkVacant checkCost(1 ether){
        currentStatus = Status.Occupied; // 방 예약 상태 변경
        
        // 예약자가 owner에게 이더리움 전송
        // call 사용 이유 - 가변적인 Gas 비용 사용
        // value - 금액 설정
        (bool result, ) = owner.call{value: msg.value}("");

        // 이더리움 전송 결과 예외 처리
        require(result, "failed to book");

        emit Occupy(msg.sender, msg.value);
    }
}