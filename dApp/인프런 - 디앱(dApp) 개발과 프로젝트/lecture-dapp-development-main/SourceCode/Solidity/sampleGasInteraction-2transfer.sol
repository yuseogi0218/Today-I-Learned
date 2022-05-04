// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleInteraction {
    event nowCost(uint _value);

    function transfer(address payable _to) public payable {
        _to.transfer(msg.value);
        emit nowCost(msg.value);
    }
}
