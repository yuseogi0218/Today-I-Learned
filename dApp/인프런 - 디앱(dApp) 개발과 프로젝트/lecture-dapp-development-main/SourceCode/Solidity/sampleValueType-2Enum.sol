// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleEnum {
    enum PhoneStatus {
        TurnOn,
        TurnOff
    }

    PhoneStatus public myPhoneStatus;

    constructor() public {
        myPhoneStatus = PhoneStatus.TurnOff;
    }

    event phoneCurrentStatus(PhoneStatus _phoneStatus, uint _phoneStatusInInt);

    function trunOnPhone() public {
        require(myPhoneStatus == PhoneStatus(1), "turned on");
        myPhoneStatus = PhoneStatus(0);
        emit phoneCurrentStatus(myPhoneStatus, uint(myPhoneStatus));
    }

    function trunOffPhone() public {
        require(myPhoneStatus == PhoneStatus(0), "turned off");
        myPhoneStatus = PhoneStatus(1);
        emit phoneCurrentStatus(myPhoneStatus, uint(myPhoneStatus));
    }
}
