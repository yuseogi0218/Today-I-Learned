// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleAccountInteraction {
    event CurrentValue(address _msgSender, address _to, uint _value);

    function checkUserMoney(address _to) public {
        emit CurrentValue(msg.sender, _to, _to.balance);
    }
}
