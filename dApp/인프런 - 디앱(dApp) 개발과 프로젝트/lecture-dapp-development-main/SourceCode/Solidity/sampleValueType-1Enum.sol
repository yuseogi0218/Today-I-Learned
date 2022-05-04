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
        require(myPhoneStatus == PhoneStatus.TurnOff, "turned on");
        myPhoneStatus = PhoneStatus.TurnOn;
        emit phoneCurrentStatus(myPhoneStatus, uint(myPhoneStatus));
    }

    function trunOffPhone() public {
        require(myPhoneStatus == PhoneStatus.TurnOn, "turned off");
        myPhoneStatus = PhoneStatus.TurnOff;
        emit phoneCurrentStatus(myPhoneStatus, uint(myPhoneStatus));
    }
}
