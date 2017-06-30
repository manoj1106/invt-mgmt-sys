var invtmgmtsysfunctions = {};

$(function() {
	
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
	
    $(".aj").click(function(event) {
    	event.preventDefault();
    	invtmgmtsysutil.showLoader();
    	$('#parentDBArea').empty();
    	$('#parentDBArea').load($(this).attr('data-href'));
    });

    $('a.logout').click(function(e) {
       e.preventDefault();
       invtmgmtsysfunctions.logout();
    });
    
    $("#chgAcademicYear").click(function() {
        $('#myModal').modal('show');
    });
    
    invtmgmtsysutil.hideLoader();
    
});

invtmgmtsysfunctions.datepicker = function() {
	var date = new Date();
	var currentYear = date.getFullYear();
	var range = constants.YEAR_LIMIT;
	var yearRange = (currentYear - range) +':'+(currentYear + range);
	$('.datepicker').datepicker({
		  changeMonth : true,
	      changeYear : true,
	      dateFormat : 'dd-mm-yy',
	      showWeek : true,
	      firstDay : 1,
	      yearRange: yearRange,
	      onSelect : function () {
	          this.focus();
	      }
	});
}

invtmgmtsysfunctions.ajaxServerRequestResponse = function(url,jsonObj,jsonString) {
	var json ;
	if(invtmgmtsysutil.isNullOrUndefined(jsonString)) {
		json = JSON.stringify(jsonObj);
	} else {
		json = jsonString;
	}
	var responseObj = null;
	$.ajax({
		url : url,
		data : json,
		method: ajaxParameter.postmethod,
		type : ajaxParameter.type,
		contentType : ajaxParameter.contentType,
		async : ajaxParameter.asynchfalse,
		success : function(response) {
			responseObj = response;
		},
		error : function() {
			invtmgmtsysfunctions.printNotificationMessage(notificationMsg.Error,msg.systemError,notificationMsg.error);
		}
	});
	return responseObj;
}

invtmgmtsysfunctions.ajaxServerRequestResponseWithoutJsonObj = function(url) {
	var responseObj = null;
	$.ajax({
		url : url,
		method: ajaxParameter.postmethod,
		async : ajaxParameter.asynchfalse,
		type : ajaxParameter.type,
		contentType : ajaxParameter.contentType,
		success : function(response) {
			responseObj = response;
		},
		error : function() {
			invtmgmtsysfunctions.printNotificationMessage(notificationMsg.Error,msg.systemError,notificationMsg.error);
		}
	});
	return responseObj;
}

invtmgmtsysfunctions.setElementColor = function(element,color) {
	$(element).css(constants.COLOR,color);
};

invtmgmtsysfunctions.printMessage = function(element,message) {
	$(element).text(message);
};

invtmgmtsysfunctions.setEmptyMessage = function(element) {
	$(element).text('');
};

invtmgmtsysfunctions.printSuccessErrorMessage = function(element,responseMessage) {
	$.each(responseMessage.message,function(key,value) {
		if(constants.SUCCESS === key) {
			invtmgmtsysfunctions.printNotificationMessage(notificationMsg.Success,value,notificationMsg.success);
		} else {
			invtmgmtsysfunctions.printNotificationMessage(notificationMsg.Error,value,notificationMsg.error);
		}
	});
};

invtmgmtsysfunctions.printNotificationMessage = function(title,message,type) {
	new PNotify({
        title : title,
        text : message,
        type : type
    });
};

invtmgmtsysfunctions.validate = function(element) {
	if(formfieldvalidator.validateform(element)) {
		return true;
	}
	return false;
}

invtmgmtsysfunctions.getStatesOnCountryChange = function(e) {
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

invtmgmtsysfunctions.getCitiesOnStatesChange = function(e) {
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

invtmgmtsysfunctions.getJsonObj = function(form) {
	var jsonObj = {};
	$(form).find('input , select').each(function() {
		if(invtmgmtsysutil.isNotBlank($(this).attr('name'))) {
			jsonObj[$(this).attr('name')] = $(this).val().toString();
		}
	});
	return jsonObj;
};

$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

invtmgmtsysfunctions.displayTooltip = function(element) {
	var id = 'tooltip'+invtmgmtsysfunctions.getRandomNumber();
	var tooltip = '<div class="tooltip fade bottom in" role="tooltip" id="'+id+'">';
	tooltip += '<div class="tooltip-arrow" style="left: 50%;"></div>';
	tooltip += '<div class="tooltip-inner">'+$(element).attr('data-original-title')+'</div>';
	tooltip += '</div>';
	var td = $(element).closest('td');
	var position = $(element).position();
	$(td).append(tooltip);
	$(element).attr("aria-describedby",id);
	var tooltipviv = $('div.tooltip');
	$(tooltipviv).css('top',position.top + $(td).height());
	$(tooltipviv).css('left',position.left - 20);
	$(tooltipviv).show();
};

invtmgmtsysfunctions.removeTooltip = function(element) {
	$(element).closest('td').find('div.tooltip').remove();
	$(element).removeAttr("aria-describedby");
};

invtmgmtsysfunctions.getRandomNumber = function() {
	return Math.floor(Math.random() * (randomNumber.max - randomNumber.min + 1)) + randomNumber.max;
};

invtmgmtsysfunctions.createWizardForm = function() {
	
	// Smart Wizard
    $('#wizard').smartWizard();

    // Smart Wizard
    $('#wizard_verticle').smartWizard({
        transitionEffect: 'slide'
    });
	
};

invtmgmtsysfunctions.logout = function() {
	$('#logoutform').submit();
} 

/*$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};*/

invtmgmtsysfunctions.getJsonForForm = function(form) {
	var json = $(form).serializeObject();
	return json;
};




