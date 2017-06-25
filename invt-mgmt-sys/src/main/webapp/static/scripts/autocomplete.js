var autocompletefunctions = {};

autocompletefunctions.autocomplete = function() {
	$('input.autocomplete').off('input');
	$('input.autocomplete').on('input',function() {
		var requestFor = $(this).attr('autocompleteText');
		var responseMessage = null;
		var result = [];
		$(this).autocomplete({
			minLength: 3,
			source: function( request, response ) {
		          responseMessage = schoolmanagementfunctions.ajaxServerRequestResponse(URL.AUTOCOMPLETE_TEXT_SEARCH, 
		        		  autocompletefunctions.getJsonObj(requestFor,request.term));
		          if(invtmgmtsysutil.isNotNullAndUndefined(responseMessage) && 
		        		  invtmgmtsysutil.isNotEmptyObject(responseMessage.dataMap)) {
		        	  result = autocompletefunctions.getResultArray(requestFor,responseMessage.dataMap.autocompleteResult);
		          }
		          response(result);
		    },
		    select: function (event, ui) {                    
		    	var selectedItemIndex = $.inArray(ui.item.value, result);
		    	autocompletefunctions.selectItem(selectedItemIndex,requestFor,responseMessage);
             }
		});
	});
};

autocompletefunctions.getJsonObj = function(requestFor,autoCompleteText) {
	var jsonObj = {
		requestFor : requestFor,
		autoCompleteText : autoCompleteText
	};
	return jsonObj;
}

autocompletefunctions.getResultArray = function(requestFor,autocompleteResult) {
	var result = [];
	if(requestFor === 'school_name') {
		$.each(autocompleteResult,function(index,value) {
  		  result.push(value[0]);
  	  });
	}
	return result;
}

autocompletefunctions.selectItem = function(selectedItemIndex,requestFor,responseMessage) {
	if(requestFor === 'school_name') {
		$.each(responseMessage.dataMap.autocompleteResult,function(index,value) {
  		  if(selectedItemIndex === index) {
  			  $('#schId').val(value[1]);
  		  }
  	  });
	}
}