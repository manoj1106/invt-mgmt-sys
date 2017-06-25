var formfieldvalidator = {};

formfieldvalidator.validateform = function(form) {
	return formfieldvalidator.validaterequiredfield(form);
};


formfieldvalidator.wizardformvalidate = function(form) {
	//formfieldvalidator.removewizardformerrors(form);
	//var element = $(form).find('div[style*="block"]');
	//return formfieldvalidator.validaterequiredfield(element);
	return true;
};

formfieldvalidator.validaterequiredfield = function(element) {
	var requiredfields = $(element).find('input[required*="required"],select[required*="required"]');
	var noerror = true;
	$(requiredfields).each(function() {
		
		var nodename = invtmgmtsysutil.getNodeName(this);
		
		if((nodename === formfields.input || nodename === formfields.select
				|| nodename === formfields.textarea) && invtmgmtsysutil.isEmptyObject(invtmgmtsysutil.getValue(this))) {
			noerror = false;
		}
		if(nodename === formfields.select && invtmgmtsysutil.isNotEmptyObject(invtmgmtsysutil.getValue(this)) 
				&& invtmgmtsysutil.getValue(this) === constants.SELECT) {
			noerror = false;
		}
		
		if(!noerror) {
			formfieldvalidator.notifyerror();
			return noerror;
		}
		
	});
	
	if(noerror) {
		requiredfields = $(element).find('input[any-one-radio*="true"]');
		var total = requiredfields.length;
		var uncheckedCount = 0;
		$(requiredfields).each(function() {
			if(!$(this).is(':checked')) {
				uncheckedCount++;
			}
			
			if(total === uncheckedCount) {
				noerror = false;
			}
			
			if(!noerror) {
				formfieldvalidator.notifyerror();
				return noerror;
			}
		});
	}
	
	return noerror;
}

formfieldvalidator.removewizardformerrors = function(form) {
	$(form).find('div.item').removeClass('bad');
	$(form).find('div.alert').remove();
};

formfieldvalidator.printwizardformerrors = function(element) {
	var parentdiv = $(element).parents('div.item');
	$(parentdiv).addClass('bad');
	$(parentdiv).append('<div class="alert">please put something here.</div>');
};

formfieldvalidator.notifyerror = function() {
	new PNotify({
        title: 'Oh No!',
        text: 'All mandatory fields are not filled.',
        type: 'error'
    });
};