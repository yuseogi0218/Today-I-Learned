// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleModifier {
    modifier checkMoney(uint _money) {
        require(_money > 100, "You have not a money");
        _;
    }

    function payment(uint _money) public checkMoney(_money) returns(string memory) {
        return "payment is succeeded";
    }
}
