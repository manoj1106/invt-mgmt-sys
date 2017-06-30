var userregistration = {};

$(function(e) {
	
	$('#country').off().on('change' , function(e){
		
		invtmgmtsysutil.showLoader();
		invtmgmtsysfunctions.getStatesOnCountryChange(e);
	});
	
	$('#state').off().on('change' , function(e){
		invtmgmtsysutil.showLoader();
		invtmgmtsysfunctions.getCitiesOnStatesChange(e);
	});
	
	$('#saveUserData').off().on('click' , function(e){
		userregistration.saveUserData();
	});
	
	invtmgmtsysutil.hideLoader();
});

userregistration.saveUserData = function() {
	var form = $('#userDataForm');
	var jsonObj = invtmgmtsysfunctions.getJsonObj(form);
	if(invtmgmtsysfunctions.validate(form)) {
		var responseMessage = invtmgmtsysfunctions.ajaxServerRequestResponse(URL.SAVE_USER_DETAILS , jsonObj);
		invtmgmtsysfunctions.printSuccessErrorMessage(null , responseMessage);
	} else {
		console.log("form validation failed....");
	}
}
