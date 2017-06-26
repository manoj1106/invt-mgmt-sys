var shopregistration = {};

$(function(e) {
	
	$('#country').off().on('change' , function(e){
		
		invtmgmtsysutil.showLoader();
		shopregistration.getStatesOnCountryChange(e);
	});
	
	$('#state').off().on('change' , function(e){
		invtmgmtsysutil.showLoader();
		shopregistration.getCitiesOnStatesChange(e);
	});
	
	$('#saveShopData').off().on('click' , function(e){
		shopregistration.saveShopData();
	});
	
	invtmgmtsysutil.hideLoader();
});


shopregistration.getStatesOnCountryChange = function(e) {
	var country = $('#country').val();
	$('#state').empty();
	$('#city').empty();
	var select = '<option value="select">' + constants.SELECT_HIFEN + '</option>';
	if(invtmgmtsysutil.isNotBlank(country) && constants.SELECT != country) {
		var jsonObj = {
			"country" : country
		}
		var responseMessage = invtmgmtsysfunctions.ajaxServerRequestResponse(URL.GET_STATES_BY_COUNTRY, jsonObj , null);
		var dataMap = responseMessage.dataMap;
		var message = responseMessage.message;
		if(invtmgmtsysutil.isEmptyObject(message) 
				&& invtmgmtsysutil.isNotEmptyObject(dataMap)) {
			var states = dataMap.states;
			$('#state').removeAttr('disabled');
			if(invtmgmtsysutil.isNotEmptyObject(states)) {
				for(var i = 0; i < states.length; i++) {
					select = select + '<option value="' + states[i] + '">' + states[i] + '</option>';
				}
			} 
		} else {
			invtmgmtsysfunctions.printSuccessErrorMessage(responseMessage);
		}
	} else {
		$('#state').attr('disabled','disabled');
		$('#city').attr('disabled','disabled');
	}
	$('#state').append(select);
	$('#city').append(select);
	invtmgmtsysutil.hideLoader();
}

shopregistration.getCitiesOnStatesChange = function(e) {
	var state = $('#state').val();
	$('#city').empty();
	var select = '<option value="select">' + constants.SELECT_HIFEN + '</option>';
	if(invtmgmtsysutil.isNotBlank(state) && constants.SELECT != state) {
		var jsonObj = {
			"state" : state
		}
		var responseMessage = invtmgmtsysfunctions.ajaxServerRequestResponse(URL.GET_CITIES_BY_STATES, jsonObj , null);
		var dataMap = responseMessage.dataMap;
		var message = responseMessage.message;
		if(invtmgmtsysutil.isEmptyObject(message) 
				&& invtmgmtsysutil.isNotEmptyObject(dataMap)) {
			var cities = dataMap.cities;
			$('#city').removeAttr('disabled');
			if(invtmgmtsysutil.isNotEmptyObject(cities)) {
				for(var i = 0; i < cities.length; i++) {
					select = select + '<option value="' + cities[i] + '">' + cities[i] + '</option>';
				}
			} 
		} else {
			invtmgmtsysfunctions.printSuccessErrorMessage(null , responseMessage);
		}
	} else {
		$('#city').attr('disabled','disabled');
	}
	$('#city').append(select);
	invtmgmtsysutil.hideLoader();
}

shopregistration.saveShopData = function() {
	var form = $('#shopDataForm');
	if(invtmgmtsysfunctions.validate(form)) {
		var json = invtmgmtsysfunctions.getJsonForForm(form);
		var responseMessage = invtmgmtsysfunctions.ajaxServerRequestResponse(URL.SAVE_SHOP_DETAILS , null , json);
		invtmgmtsysfunctions.printSuccessErrorMessage(null , responseMessage);
	} else {
		console.log("form validation failed....");
	}
}
