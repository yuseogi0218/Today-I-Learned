App = {
  web3Provider: null,
  contracts: {},
	
  init: function() {
   $.getJSON('../real-estate.json', function(data) {
     var list = $('#list');
     var template = $('#template');

     for (i = 0; i < data.length; i++) {
       template.find('img').attr('src', data[i].picture);
       template.find('.id').text(data[i].id);
       template.find('.type').text(data[i].type);
       template.find('.area').text(data[i].area);
       template.find('.price').text(data[i].price);

       list.append(template.html());
     }
   })

   return App.initWeb3();
  },

  initWeb3: async function() {
    if(window.ethereum) {
      App.web3Provider = window.ethereum;
      try {
        await window.ethereum.enable();
      } catch (error) {
        console.error("User denied account access");
      }
    }

    else if (window.web3) {
      App.web3Provider = window.web3.currentProvider;
    } else {
      App.web3Provider = new Web3.providers.HttpProvider('http://localhost:8545');
    }
    web3 = new Web3(App.web3Provider);
    // if (typeof web3 !== 'undefined') {
    //   App.web3Provider = web3.currentProvider;
    //   web3 = new Web3(web3.currentProvider);
    // } else {
    //   App.web3Provider = new web3.providers.HttpProvider('http://127.0.0.1:8545');
    //   web3 = new Web3(App.web3Provider);
    // }

    return App.initContract();
  },

  initContract: function() {
		$.getJSON('RealEstate.json', function(data) {
      App.contracts.RealEstate = TruffleContract(data);
      App.contracts.RealEstate.setProvider(App.web3Provider);
      App.listenToEvents();
    });
  },

  buyRealEstate: function() {	
    var id = $('#id').val();
    var name = $('#name').val();
    var price = $('#price').val();
    var age = $('#age').val();


    web3.eth.getAccounts(function(error, accounts) {
      if(error) {
        console.log(error);
      }
       
      var account = accounts[0];
      // var account = "0x20BB5789f444e47a88c366f0bfE41EcB3c75BD4C";
      App.contracts.RealEstate.deployed().then(function(instance) {
        var nameUtf8Encoded = utf8.encode(name);
        return instance.buyRealEstate(id, nameUtf8Encoded, age, {from: account, value: price});
      }).then(function(){
        $('#name').val('');
        $('#age').val('');
        $('#buyModal').modal('hide');
      }).catch(function(error) {
        console.log(error);
      });
    });

  },

  loadRealEstates: function() {
    App.contracts.RealEstate.deployed().then(function(instance) {
      return instance.getAllBuyers.call();
    }).then(function(buyers) {
      for (i = 0; i < buyers.length; i++) {
        if (buyers[i] !== '0x0000000000000000000000000000000000000000') {
          var imgType = $('.panel-body').eq(i).find('img').attr('src');
          imgType = imgType.substr(7);

          switch(imgType) {
            case 'apartment.jpg' :
              $('.panel-body').eq(i).find('img').attr('src', 'images/apartment_sold.jpg');
              break
            case 'townhouse.jpg' :
              $('.panel-body').eq(i).find('img').attr('src', 'images/townhouse_sold.jpg');
              break
            case 'house.jpg' :
            $('.panel-body').eq(i).find('img').attr('src', 'images/house_sold.jpg');
            break
          }

          $('.panel-body').eq(i).find('.btn-buy').text('매각').attr('disabled', true);
          $('.panel-body').eq(i).find('.btn-buyerInfo').removeAttr('style');
        }
      }
    }).catch(function(error){
      console.log(error);
    })
  },
	
  listenToEvents: function() {
    App.contracts.RealEstate.deployed().then(function(instance) {
      instance.LogBuyRealEstate({}, {fromBlock: 0, toBlock: 'latest'}).watch(function(error, event) {
        if (!error) {
          $('#events').append('<p>' + event.args._buyer + ' 계정에서 ' + event.args._id + ' 번 매물을 매입했습니다. ' + '</p>');
        } else {
          console.log(error);
        }

        App.loadRealEstates();
      })
    })
  }
};

$(function() {
  $(window).load(function() {
    App.init();
  });

  $('#buyModal').on('show.bs.modal', function(e) {
    var id = $(e.relatedTarget).parent().find('.id').text();
    var price = web3.toWei(parseFloat($(e.relatedTarget).parent().find('.price').text() || 0), "ether");

    $(e.currentTarget).find('#id').val(id);
    $(e.currentTarget).find('#price').val(price);
  });

  $('#buyerInfoModal').on('show.bs.modal', function(e) {
    var id = $(e.relatedTarget).parent().find('.id').text();
    
    App.contracts.RealEstate.deployed().then(function(instance) {
      return instance.getBuyerInfo.call(id);
    }).then(function(buyerInfo) {
      $(e.currentTarget).find('#buyerAddress').text(buyerInfo[0]);
      $(e.currentTarget).find('#buyerName').text(buyerInfo[1]);
      $(e.currentTarget).find('#buyerAge').text(buyerInfo[2]);
    }).catch(function(err) {
      console.log(err);
    })
  });
});
