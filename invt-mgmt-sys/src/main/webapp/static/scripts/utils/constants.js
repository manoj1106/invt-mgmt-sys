/**
 * 
 * @author Manoj Patel
 * 
 */

var ajaxParameter = {
	getmethod : 'GET',
	postmethod : 'POST',
	contentType : 'application/json',
	type : 'json',
	asynchtrue : true,
	asynchfalse : false
};

var URL = {
	/***url mapping for utilities***/
	GET_STATES_BY_COUNTRY : 'invtmgmtsys/getStatesByCountry',
	GET_CITIES_BY_STATES : 'invtmgmtsys/getCitiesByStates',
	/*** url mapping for menu item access ***/
	MENU_ITEM_ACCESS : 'menuitemaccess/menuitemaccess',
	SAVE_MENU_ITEM_ACCESS : 'menuitemaccess/saveMenuItemAccess',
	GET_MENU_ITEMS : 'menuitemaccess/getMenuItems'
}

var PAGINATION_DETAILS = {
	DEFAULT_PAGE_SIZE : '10',
	ALL_PAGE_SIZES : '10,20,30,50,ALL',
}

var constants = {
	SELECT : 'select',
	SELECT_HIFEN : '--select--',
	SUCCESS : 'SUCCESS',
	ERROR : 'ERROR',
	RED : 'red',
	GREEN : 'green',
	COLOR : 'color',
	EMPTY_STRING : '',
	YELLOW : 'yellow',
	DEFAULT_MENU : 'Menu Item Access',
	MESSAGE : '.message',
	COMMA : ',',
	ALL : 'ALL',
	YEAR_LIMIT : 200,
};

var ROLES = {
	SYSTEM_ADMIN : 'SYSTEM_ADMIN'	
};

var classConstants = {
	btn : "btn",
	btnDefault : "btn-default",
	btnSuccess : "btn-success",
	btnPrimary : "btn-primary"
};

var attrconstants = {
	required : 'required'	
};

var formfields = {
	input : 'input',
	select : 'select',
	textarea : 'textarea',
};

var gridIdsMap = {
	sectionregistration : 'sectionregistration',
	classregistration : 'classregistration'
};

var dataRequestFor = {
	schooldata : 'schooldata',
	allclassdata : 'allclassdata',
	classdata : 'classdata',
	sectiondata : 'sectiondata',
	allsectiondata : 'allsectiondata'
};

var titles = {
	SchoolList : 'School List',
	ClassList : 'Class List',
	SectionList : 'Section List' 
}

var randomNumber = {
	max : 999999,
	min : 123456
};

var notificationMsg = {
	Success : 'Success',
	success : 'success',
	Error : 'Error',
	error : 'error'
}

var paginationIdsClasses = {
	first : 'first',
	previous : 'previous',
	next : 'next',
	last : 'last',
	totalrecords : 'totalrecords',
	pageNoLabel : 'pageNoLabel',
	pageNoLabelLast : 'pageNoLabelLast',
	totalrecords : 'totalrecords'
}