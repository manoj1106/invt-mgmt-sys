/**
 * 
 * @author Manoj Patel
 * 
 */

var invtmgmtsysutil = {};

invtmgmtsysutil.isNotNullAndUndefined = function(value) {
	return (undefined !== value && null !== value) ? true : false; 
};

invtmgmtsysutil.isNullOrUndefined = function(value) {
	return (undefined === value || null === value) ? true : false; 
};

invtmgmtsysutil.isNotBlank = function(value) {
	return (invtmgmtsysutil.isNotNullAndUndefined(value) && "" !== value.trim()) ? true : false; 
};

invtmgmtsysutil.isBlank = function(value) {
	return (invtmgmtsysutil.isNullOrUndefined(value) || "" === value.trim()) ? true : false; 
};

invtmgmtsysutil.isNotEmptyObject = function(value) {
	return (!jQuery.isEmptyObject(value)) ? true : false; 
};

invtmgmtsysutil.isEmptyObject = function(value) {
	return (jQuery.isEmptyObject(value)) ? true : false; 
};

invtmgmtsysutil.showLoader = function() {
	invtmgmtsysutil.showHideLoad();
};

invtmgmtsysutil.hideLoader = function() {
	invtmgmtsysutil.showHideLoad("hide");
};

invtmgmtsysutil.isEquals = function(value1,value2) {
	return (value1 === value2) ? true : false; 
};

invtmgmtsysutil.getNodeName = function(element) {
	return $(element)[0].nodeName.toLowerCase(); 
};

invtmgmtsysutil.getValue = function(element) {
	return $(element).val(); 
};

invtmgmtsysutil.showHideLoad = function(hideIndicator) {
    if (invtmgmtsysutil.isNotBlank(hideIndicator)) {
        $('#overlay').hide();
    } else {
    	$('#overlay').show();
    }
}

invtmgmtsysutil.getGridId = function(gridId) {
	return '#' +  gridId;
};
