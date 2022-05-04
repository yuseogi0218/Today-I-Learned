// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleA {
    uint public num = 5;

    function setNum(uint _num) public {
        num = _num;
    }
}

contract sampleB {
    sampleA instance = new sampleA();

    function getNum() public view returns(uint) {
        return instance.num();
    }

    function setNum(uint _num) public {
        instance.setNum(_num);
    }
}