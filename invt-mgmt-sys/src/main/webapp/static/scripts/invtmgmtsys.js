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

invtmgmtsysfunctions.getStates = function() {
	 $('#state').off('change');
	    $('#state').on('change',function() {
	    	$('#city').empty();
	    	var options = '<option value="'+constants.SELECT+'">'+constants.SELECT_HIFEN+'</option>';
	    	if($(this).val() === constants.SELECT) {
	    		$('#city').append(options);
	    	} else {
	    		invtmgmtsysfunctions.getCities($(this).val(),options,$('#city'));
	    	}
	    });
};

invtmgmtsysfunctions.getCities = function(state,options,element) {
	var jsonObj = {
			state : state	
	};
	var response = invtmgmtsysfunctions.ajaxServerRequestResponse(URL.GET_CITIES, jsonObj);
	if(invtmgmtsysutil.isNotNullAndUndefined(response) && invtmgmtsysutil.isNotNullAndUndefined(response.dataMap)) {
		$.each(response.dataMap.cities,function(index,city){
			options += '<option value="'+city+'">'+city+'</option>';
		});
		$(element).append(options);
	}
};

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




