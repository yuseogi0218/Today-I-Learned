pragma solidity ^0.6.0;

contract RealEstate {
    struct Buyer {
        address buyerAddress;
        string name;
        uint age;
    }

    mapping (uint => Buyer) public buyerInfo;
    address public owner;
    address[10] public buyers; // 매입자의 계정 주소
    
    event LogBuyRealEstate(
        address _buyer,
        uint _id
    );

    constructor() public {
        owner = msg.sender;
    }

    // 매물 id, 구매자 이름, 구매자 나이
    function buyRealEstate(uint _id, string memory _name, uint _age) public payable {
        require(_id >= 0 && _id <= 9);
        buyers[_id] = msg.sender;
        buyerInfo[_id] = Buyer(msg.sender, _name, _age);

        // 해당 계정에게 이더리움 전송 - msg.value 는 wei만 허용하므로, front에서 ether를 wei로 변환 필요
        payable(owner).transfer(msg.value);
        emit LogBuyRealEstate(msg.sender, _id);
    }

    function getBuyerInfo(uint _id) public view returns (address, string memory, uint) {
        Buyer memory buyer = buyerInfo[_id];

        return (buyer.buyerAddress, buyer.name, buyer.age);
    }

    function getAllBuyers() public view returns (address[10] memory) {
        return buyers;
    }
}
