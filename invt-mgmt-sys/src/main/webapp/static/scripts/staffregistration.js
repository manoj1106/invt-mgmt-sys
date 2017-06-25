var staffregistrationfuctions = {
	genderselectFunction : function() {
		$('div.iradio_flat-green').click(function(){
			var parentDiv = $(this).parents('div.radio');
			$(parentDiv).find('div.iradio_flat-green').removeClass('checked');
			$(this).find('div.iradio_flat-green').addClass('checked');
			$(this).find('input').prop('checked',true);
		});	
	},
	yearsMonthSelection : function() {
		$('div.has-feedback a').bind('click',function(e){
			e.preventDefault();
			var years = 0;
			var months = 0;
			var yearUpdate = false;
			var monthUpdate = false;
			var input = $(this).parents('div.has-feedback').find('input');
			if($(this).hasClass('up-arrow')) {
				if($(input).hasClass('years')) {
					if($(input).val()) {
						years = parseInt($(input).val());
					}
					years = years + 1;
					yearUpdate = true;
				} else {
					if($(input).val()) {
						months = parseInt($(input).val());
					}
					if(months < 12) {
						months = months + 1;
						monthUpdate = true;
					}
				}
			} else {
				if($(input).hasClass('years')) {
					if($(input).val()) {
						years = parseInt($(input).val());
					}
					if(years > 0) {
						years = years - 1;
						yearUpdate = true;
					}
				} else {
					if($(input).val()) {
						months = parseInt($(input).val());
					}
					if(months > 0) {
						months = months - 1;
						monthUpdate = true;
					}
				}
			}
			if(yearUpdate) {
				$(input).val(years);
			}
			if(monthUpdate) {
				$(input).val(months);
			}
		});
	}
};

$(function(){
	
	schoolmanagementfunctions.datepicker();
	
	schoolmanagementfunctions.createWizardForm();
	
	invtmgmtsysutil.hideLoader();
	
	staffregistrationfuctions.genderselectFunction();
	
	staffregistrationfuctions.yearsMonthSelection();
	
	schoolmanagementfunctions.getStates();
	
	$('.btn').click(function(e) {
		e.preventDefault();
		var form = $(this).parents('div.form_wizard').find('form');
		if($(this).hasClass(classConstants.btnDefault) && formfieldvalidator.wizardformvalidate($(form))) {
			staffregistrationfuctions.registerStaffEmployee();
		}
	});
	
	autocompletefunctions.autocomplete();
	
});

staffregistrationfuctions.getJsonObj = function() {
	var sempExperience = 0;
	var sempAddress = $('#addressLineOne').val();
	
	if(invtmgmtsysutil.isNotBlank($('#addressLineTwo').val())) {
		sempAddress = sempAddress + ',' + $('#addressLineTwo').val();
	}
	if(invtmgmtsysutil.isNotBlank($('#addressLineThree').val())) {
		sempAddress = sempAddress + ',' + $('#addressLineThree').val();
	}
	
	if(invtmgmtsysutil.isNotBlank($('#years').val())) {
		sempExperience = parseInt($('#years').val()) * 12;
	}
	if(invtmgmtsysutil.isNotBlank($('#month').val())) {
		sempExperience = sempExperience + parseInt($('#month').val());
	}

	var jsonObj = {
		schId : $('#schId').val(),
		sempAddress : sempAddress,
		sempFirstname : $('#sempFirstname').val(),
		sempMiddlename : $('#sempMiddlename').val(),
		sempLastname : $('#sempLastname').val(),
		fatherName : $('#fatherName').val(),
		motherName : $('#motherName').val(),
		sempMailid : $('#sempMailid').val(),
		sempPhonenumber : $('#sempPhonenumber').val(),
		sempJoiningdate : $('#sempJoiningdate').val(),
		sempLeavingdate : $('#sempLeavingdate').val(),
		sempExperience : sempExperience,
		sempGender : $("input[name=sempGender]:checked").val(),
		sempBloodgroup : $('#sempBloodgroup').val(),
		sempDob : $('#sempDob').val(),
		sempHighestQualification : $('#sempHighestQualification').val(),
		sempRole : $("input[name=sempRole]:checked").val(),
		sempAadharcard : $('#sempAadharcard').val(),
		sempMaritalStatus : $("input[name=sempMaritalStatus]:checked").val(),
		sempSkills : $('#sempSkills').val(),
		sempCriminalRecord : $('#sempCriminalRecord').val()
	};
	
	return jsonObj;
}

staffregistrationfuctions.registerStaffEmployee = function() {
	var responseMessage = schoolmanagementfunctions.ajaxServerRequestResponse(URL.REGISTER_STAFF_EMPLOYEE, 
			staffregistrationfuctions.getJsonObj());
	if(invtmgmtsysutil.isNotEmptyObject(responseMessage)) {
		schoolmanagementfunctions.printSuccessErrorMessage(constants.MESSAGE, responseMessage);
	}
}




