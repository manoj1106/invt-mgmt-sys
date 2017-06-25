var schoolRegistrationFunctions = {};

$(function(){
	
	schoolmanagementfunctions.datepicker();
	
	$(".select2_single").select2({
        placeholder: "Select a state",
        allowClear: true
    });
    $(".select2_group").select2({});
    $(".select2_multiple").select2({
        maximumSelectionLength: 10,
        placeholder: "Max Selection limit 10",
        allowClear: true
    });
     
    schoolmanagementfunctions.createWizardForm();
    
    $('.btn').click(function(e) {
		e.preventDefault();
		var form = $(this).parents('div.form_wizard').find('form');
		if($(this).hasClass(classConstants.btnDefault) && formfieldvalidator.wizardformvalidate($(form))) {
			schoolRegistrationFunctions.registerSchool();
		}
	});
    
    schoolmanagementfunctions.getStates();
    
    invtmgmtsysutil.hideLoader();
});

schoolRegistrationFunctions.registerSchool = function() {
	var jsonObj = schoolmanagementfunctions.getJsonObj($('form'));
	var responseMessage = schoolmanagementfunctions.ajaxServerRequestResponse(URL.REGISTER_SCHOOL, jsonObj);
	if(invtmgmtsysutil.isNotEmptyObject(responseMessage)) {
		schoolmanagementfunctions.printSuccessErrorMessage(constants.MESSAGE, responseMessage);
	}
};



