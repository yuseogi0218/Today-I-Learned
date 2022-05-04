// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleA {
    event info(string nickname);

    function setNickname(string memory _nickname) public {
        emit info(_nickname);
    }
}