// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract sampleFlowControl {
    function call() public view returns(string memory) {
        int num = 5;

        if(num == 0){
            return "num is 0";
        }

        return "num is not 0";
    }
}
