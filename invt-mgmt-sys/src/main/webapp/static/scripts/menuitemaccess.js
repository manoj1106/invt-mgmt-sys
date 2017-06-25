/***
 * 
 * @author Manoj Patel
 * 
 */
var defaultMenuAdded = false;
$(function() {
	
	defaultMenuAdded = false;
	getMenuItems();
	
	$('div.menuitemdiv li.parent input.chkbxheader').off('click');
	$('div.menuitemdiv li.parent input.chkbxheader').on('click',function() {
		if($(this).is(':checked')) {
			$(this).parents('li.parent').find('ul li input.chkbxcomp').prop('checked',true);
		} else {
			$(this).parents('li.parent').find('ul li input.chkbxcomp').prop('checked',false);
		}
	});

	$('div.menuitemdiv li.parent').draggable({
		appendTo: "body",
		helper: "clone"
	});
	
	$('div.allowedmenuitemdiv').droppable({
		activeClass: "ui-state-default",
		hoverClass: "ui-state-hover",
		accept: ":not(.ui-sortable-helper)",
		drop: function( event, ui ) {
			$( this ).find( ".placeholder" ).remove();
			$(this).append(ui.draggable);
			checkAllAllowedCheckboxes();
		}
	}).sortable({
		items: "li:not(.placeholder)",
		sort: function() {
			$(this).removeClass( "ui-state-default" );
		}
	});
	
	autocompletefunctions.autocomplete();
	
	invtmgmtsysutil.hideLoader();
});

function getMenuItems() {
	var responseMessage = invtmgmtsysfunctions.ajaxServerRequestResponseWithoutJsonObj(URL.GET_MENU_ITEMS);
	
	if(invtmgmtsysutil.isNotEmptyObject(responseMessage) && 
			invtmgmtsysutil.isNotEmptyObject(responseMessage.dataMap)) {
		$('div.menuitemdiv').append(responseMessage.dataMap.allmenues);
	}
	
	if(invtmgmtsysutil.isNotEmptyObject(responseMessage) && 
			invtmgmtsysutil.isNotEmptyObject(responseMessage.dataMap)) {
		$('div.allowedmenuitemdiv').append(responseMessage.dataMap.allowedmenues);
		checkAllAllowedCheckboxes();
		removeAllowedMenuesFromAllMenues();
	}
}

function checkAllAllowedCheckboxes() {
	$('div.allowedmenuitemdiv input:checkbox').prop('checked',true);
	allowedMenuSelecion();
}

function removeAllowedMenuesFromAllMenues() {
	var li = $('div.allowedmenuitemdiv li.parent');
	var allLi = $('div.menuitemdiv li.parent');
	$(li).each(function(){
		var text = $(this).find('input.chkbxheader').val();
		$(allLi).find('input.chkbxheader[value="'+text+'"]').closest('li').remove();
	});
}

function allowedMenuSelecion() {
	$('div.allowedmenuitemdiv li.parent').off('click');
	$('div.allowedmenuitemdiv li.parent').on('click',function() {
		if($(this).hasClass('libackgroundcolor')) {
			$('div.allowedmenuitemdiv li.parent').removeClass('libackgroundcolor');
			enableDisableRemoveButton(true);
		} else {
			$('div.allowedmenuitemdiv li.parent').removeClass('libackgroundcolor');
			$(this).addClass('libackgroundcolor');
			enableDisableRemoveButton(false);
		}
		
	});
}

function removeSelectedMenu() {
	if($('div.allowedmenuitemdiv li.libackgroundcolor').text() !== constants.DEFAULT_MENU ||
			$('div.allowedmenuitemdiv li.libackgroundcolor').text() === constants.DEFAULT_MENU
			&& $('#role').val() !== ROLES.SYSTEM_ADMIN ) {
		$('div.allowedmenuitemdiv li.libackgroundcolor').remove();
		enableDisableRemoveButton(true);
	} else {
		invtmgmtsysfunctions.printNotificationMessage(notificationMsg.Error,msg.defaultMenuRemoval,notificationMsg.error);
	}
}

function enableDisableRemoveButton(enableDisable) {
	$('.removemenuitems').prop('disabled',enableDisable);
}

function saveMenuItems() {
	var menuItem = getMenuItemJson();
	if(validateSaveMenuItem(constants.MESSAGE)) {
		var jsonObj = {
			shopId : $('#shopId').val(),
			role : $('#role').val(),
			menuItem : menuItem
		};
		var responseMessage = invtmgmtsysfunctions.ajaxServerRequestResponse(URL.SAVE_MENU_ITEM_ACCESS, jsonObj);
		if(invtmgmtsysutil.isNotEmptyObject(responseMessage)) {
			invtmgmtsysfunctions.printSuccessErrorMessage(constants.MESSAGE, responseMessage);
		}
	}
	invtmgmtsysutil.hideLoader();
}

function validateSaveMenuItem(element) {
	var isValid = true;
	invtmgmtsysfunctions.setEmptyMessage(element);
	if(invtmgmtsysutil.isNotBlank($('#role').val()) && constants.SELECT == $('#role').val()
			|| invtmgmtsysutil.isBlank($('#role').val())) {
		invtmgmtsysfunctions.printNotificationMessage(notificationMsg.Error,msg.provideRole,notificationMsg.error);
		isValid = false;
	} else if(invtmgmtsysutil.isBlank($('#shopId').val()) && ROLES.SYSTEM_ADMIN !== $('#role').val()) {
		invtmgmtsysfunctions.printNotificationMessage(notificationMsg.Error,msg.provideSchId,notificationMsg.error);
		isValid = false;
	} else if(!defaultMenuAdded && ROLES.SYSTEM_ADMIN == $('#role').val()) {
		invtmgmtsysfunctions.printNotificationMessage(notificationMsg.Error,msg.defaultMenuItemNotAdded,notificationMsg.error);
		isValid = false;
	}
	if(!isValid) {
		invtmgmtsysfunctions.setElementColor(element, constants.RED);
	}
	return isValid;
}

function getMenuItemJson() {
	var jsonObj = {
		allowedMenues : getAllowedMenuesJson()	
	};
	return JSON.stringify(jsonObj);
}

function getAllowedMenuesJson() {
	var li = $('div.allowedmenuitemdiv li.parent');
	var jsonObj = {};
	$.each(li,function() {
		var checkbox = $(this).find('input.chkbxheader');
		if($(checkbox).is(':checked')) {
			var ul = $(this).find('ul');
			if(invtmgmtsysutil.isNotNullAndUndefined(ul) && $(ul).length === 1) {
				var jsonString = getChildElementJson(ul);
				if(invtmgmtsysutil.isNotBlank(jsonString)) {
					jsonObj[$(checkbox).val()] = jsonString;
				}
			} else {
				jsonObj[$(checkbox).val()] = $(checkbox).val();
				if($(checkbox).val() === constants.DEFAULT_MENU) {
					defaultMenuAdded = true;
				}
			}
		}
	});
	return JSON.stringify(jsonObj);
}

function getChildElementJson(ul) {
	var jsonObj = {};
	var li = $(ul).find('li.child');
	$.each(li,function() {
		var checkbox = $(this).find('input.chkbxcomp');
		if($(checkbox).is(':checked')) {
			jsonObj[$(checkbox).val()] = $(checkbox).val();
		}
		
	});
	if(invtmgmtsysutil.isNotEmptyObject(jsonObj)) {
		return JSON.stringify(jsonObj);
	}
	else {
		return constants.EMPTY_STRING;
	}
}