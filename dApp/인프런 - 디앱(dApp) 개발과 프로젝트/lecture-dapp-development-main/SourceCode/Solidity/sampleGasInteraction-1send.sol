// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleInteraction {
    event nowCost(uint _value);

    function send(address payable _to) public payable {
        bool result = _to.send(msg.value);
        require(result, "failed to send");
        emit nowCost(msg.value);
    }
}
