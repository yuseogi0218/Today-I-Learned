// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleModifier {
    modifier checkMoney {
        revert("You have not a money");
        _;
    }

    function payment() public checkMoney returns(string memory) {
        return "payment is succeeded";
    }
}
