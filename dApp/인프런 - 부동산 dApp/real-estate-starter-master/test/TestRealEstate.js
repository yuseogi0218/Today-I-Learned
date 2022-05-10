var RealEstate = artifacts.require("./RealEstate.sol");

contract('RealEstate', function(accounts) {
    var realEstateInstance;

    it("컨트랙트의 소유자 초기화 테스팅", function() {
        return RealEstate.deployed().then(function(instance) {
            realEstateInstance = instance;
            return realEstateInstance.owner.call();
        }).then(function(owner) {
            assert.equal(owner.toUpperCase(), accounts[0].toUpperCase(), "owner가 가나슈 첫번째 계정과 동일하지 않습니다.");
        });
    });

    it("가나슈 두번재 계정으로 매물 아이디 0번 매입 후 이벤트 생성 및 매입자 정보와 buyers 배열 테스팅", function() {
        return RealEstate.deployed().then(function(instance) {
            realEstateInstance = instance;
            return realEstateInstance.buyRealEstate(0, "sejong", 13, {from : accounts[1], value : "1500000000000000000"});
        }).then(function(receipt) {
            assert.equal(receipt.logs.length, 1, "이벤트 하나가 생성되지 않았습니다.");
            assert.equal(receipt.logs[0].event, "LogBuyRealEstate", "이벤트가 LogBuyRealEstate가 아닙니다.");
            assert.equal(receipt.logs[0].args._buyer, accounts[1], "매입자가 가나슈 두번째 계정이 아닙니다.");
            assert.equal(receipt.logs[0].args._id, 0, "매물 아이디가 0이 아닙니다.");
            return realEstateInstance.getBuyerInfo(0);
        }).then(function(buyerInfo) {
            assert.equal(buyerInfo[0].toUpperCase(), accounts[1].toUpperCase(), "매입자의 계정이 가나슈 두번째 계정과 일치하지 않습니다.");
            assert.equal(buyerInfo[1], "sejong", "매입자의 이름이 sejong이 아닙니다.");
            assert.equal(buyerInfo[2], 13, "매입자의 나이가 13살이 아닙니다.");
            return realEstateInstance.getAllBuyers();
        }).then(function(buyers) {
            assert.equal(buyers[0].toUpperCase(), accounts[1].toUpperCase(), "Buyers 배열 첫번째 인덱스의 계정이 가나슈의 두번째 계정과 일치하지 않습니다.")
        })
    })
});