var shopregistration = {};

$(function(e) {
	
	$('#country').off().on('change' , function(e){
		
		invtmgmtsysutil.showLoader();
		invtmgmtsysfunctions.getStatesOnCountryChange(e);
	});
	
	$('#state').off().on('change' , function(e){
		invtmgmtsysutil.showLoader();
		invtmgmtsysfunctions.getCitiesOnStatesChange(e);
	});
	
	$('#saveShopData').off().on('click' , function(e){
		shopregistration.saveShopData();
	});
	
	invtmgmtsysutil.hideLoader();
});

shopregistration.saveShopData = function() {
	var form = $('#shopDataForm');
	var jsonObj = invtmgmtsysfunctions.getJsonObj(form);
	if(invtmgmtsysfunctions.validate(form)) {
		var responseMessage = invtmgmtsysfunctions.ajaxServerRequestResponse(URL.SAVE_SHOP_DETAILS , jsonObj);
		invtmgmtsysfunctions.printSuccessErrorMessage(null , responseMessage);
	} else {
		console.log("form validation failed....");
	}
}
