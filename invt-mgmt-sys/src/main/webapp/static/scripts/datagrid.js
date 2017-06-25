var g_datagrid_map = new Object();
var paginationmap = {};
var datagridfunctions = {};
var keyposArray = [];

		
datagridfunctions.getGridData = function(jsonObj) {
	var responseMessage = schoolmanagementfunctions.ajaxServerRequestResponse(URL.GET_DATA_GRID, jsonObj);
	return responseMessage;
};

datagridfunctions.getTotalRecords = function(jsonObj) {
	var responseMessage = schoolmanagementfunctions.ajaxServerRequestResponse(URL.GET_TOTAL_RECORDS_COUNT, jsonObj);
	return responseMessage;
};

datagridfunctions.bindpagination = function() {
	if(invtmgmtsysutil.isNotEmptyObject(g_datagrid_map)) {
		var button = $(g_datagrid_map.gridElement).find('button.custompagination');
		$(button).off('click');
		$(button).on('click',function() {
			var currentPage = g_datagrid_map.paginationmap.currentPage;
			if($(this).hasClass(paginationIdsClasses.first)) {
				g_datagrid_map.paginationmap.currentPage = 1;
			} else if($(this).hasClass(paginationIdsClasses.previous)) {
				g_datagrid_map.paginationmap.currentPage = currentPage - 1;
			} else if($(this).hasClass(paginationIdsClasses.next)) {
				g_datagrid_map.paginationmap.currentPage = currentPage + 1;
			} else if($(this).hasClass(paginationIdsClasses.last)) {
				g_datagrid_map.paginationmap.currentPage = g_datagrid_map.paginationmap.totalPages;
			}
			datagridfunctions.displayGridData();
		});
	}
};

datagridfunctions.buttonEnableDisable = function() {
	if(g_datagrid_map.paginationmap.totalCount > 0) {
		$(g_datagrid_map.gridElement).find('button.first').prop("disabled",false);
		$(g_datagrid_map.gridElement).find('button.previous').prop("disabled",false);
		$(g_datagrid_map.gridElement).find('button.next').prop("disabled",false);
		$(g_datagrid_map.gridElement).find('button.last').prop("disabled",false);
		if(g_datagrid_map.paginationmap.currentPage === 1) {
			$(g_datagrid_map.gridElement).find('button.first').prop("disabled",true);
			$(g_datagrid_map.gridElement).find('button.previous').prop("disabled",true);
		}
		if(g_datagrid_map.paginationmap.currentPage === g_datagrid_map.paginationmap.totalPages) {
			$(g_datagrid_map.gridElement).find('button.next').prop("disabled",true);
			$(g_datagrid_map.gridElement).find('button.last').prop("disabled",true);
		}
	} else {
		$(g_datagrid_map.gridElement).find('button.first').prop("disabled",true);
		$(g_datagrid_map.gridElement).find('button.previous').prop("disabled",true);
		$(g_datagrid_map.gridElement).find('button.next').prop("disabled",true);
		$(g_datagrid_map.gridElement).find('button.last').prop("disabled",true);
	}
}

datagridfunctions.getHeaders = function(responseMessage) {
	keyposArray = [];
	var headerText = '<thead>';
	var headers = responseMessage.dataMap.headers;
	$.each(headers,function(index,header){
		keyposArray[header] = index;
		headerText += datagridfunctions.getTh(header);
	});	
	headerText += '</thead>';
	return headerText;
};

datagridfunctions.getData = function(responseMessage) {
	var headersSize = responseMessage.dataMap.headers.length;
	var dataText = '<tbody>';
	var dataList = responseMessage.dataMap.dataList;
	$.each(dataList,function(index,dataArray) {
		dataText += '<tr>';
		$.each(dataArray,function(dataIndex,data) {
			if(dataIndex < headersSize ) {
				dataText += datagridfunctions.getTd(data);
			}
		});
		dataText += '</tr>';
	});	
	dataText += '</tbody>';
	return dataText;
};

datagridfunctions.getPaginationMap = function(pageSize,currentPage,totalPages) {
	paginationmap = {};
	paginationmap = {
		pageSize : pageSize,
		currentPage : currentPage,
		totalPages : totalPages
	};
	return paginationmap;
};

datagridfunctions.setCustomPageSizes = function() {
	$('#custompagesize').empty();
	var option = constants.EMPTY_STRING;
	var pageSizes = PAGINATION_DETAILS.ALL_PAGE_SIZES.split(constants.COMMA);
	$.each(pageSizes,function(index,pageSize){
		option += '<option value"'+pageSize+'">'+pageSize+'</option>'
	});
	$('#custompagesize').append(option);
	datagridfunctions.getCustomPageData();
};

datagridfunctions.displayDataGrid = function(responseMessage) {
	var headers = datagridfunctions.getHeaders(responseMessage);
	var dataText = datagridfunctions.getData(responseMessage);
	var table = $(g_datagrid_map.gridElement).find('table.'+g_datagrid_map.dataRequestFor);
	$(table).empty();
	$(table).append(headers);
	$(table).append(dataText);
	datagridfunctions.setDataGridSpecificValues(responseMessage);
	datagridfunctions.onmousehover();
};

datagridfunctions.displayTitle = function(title) {
	$(g_datagrid_map.gridElement).find('h3.box-title').text(title);
}

datagridfunctions.setDataGridSpecificValues = function() {
	switch(g_datagrid_map.gridId) {
		
		case gridIdsMap.sectionregistration :
			sectionregistrationfunction.addSectionRegistrationButton();
			break;
		
		case gridIdsMap.classregistration :
			if(g_datagrid_map.dataRequestFor == dataRequestFor.schooldata) {
				classregistrationfunction.addClassRegistrationButton();
			} else if(g_datagrid_map.dataRequestFor == dataRequestFor.allclassdata) {
				classregistrationfunction.addSectionRegistrationButton();
			} 
			break;
		
		default :
			break;
	}
};

datagridfunctions.emptyTh = function() {
	return '<th></th>';
};

datagridfunctions.emptyTd = function() {
	return '<td></td>';
};

datagridfunctions.getTd = function(data) {
	return '<td>'+data+'</td>';
};

datagridfunctions.getTh = function(data) {
	return '<th>'+data+'</th>';
};

datagridfunctions.emptyTr = function() {
	return '<tr></tr>';
};

datagridfunctions.onmousehover = function() {
	$('a.tooltip-display')
	  .hover(function(e) {
		  e.preventDefault();
		  schoolmanagementfunctions.displayTooltip(this);
	  })
	  .mouseleave(function(e) {
		  e.preventDefault();
		  schoolmanagementfunctions.removeTooltip(this);
	  });
};

datagridfunctions.updatePaginationMap = function(responseMessage) {
	g_datagrid_map.paginationmap['totalPages'] = responseMessage.dataMap.totalpages;
	g_datagrid_map.paginationmap['totalCount'] = responseMessage.dataMap.totalcount;
}

datagridfunctions.displayPagination = function() {
	var pageNoLabel = invtmgmtsysutil.getGridId(paginationIdsClasses.pageNoLabel);
	var pageNoLabelLast = invtmgmtsysutil.getGridId(paginationIdsClasses.pageNoLabelLast);
	if(g_datagrid_map.paginationmap.totalCount > 0) {
		$(pageNoLabel).text(g_datagrid_map.paginationmap.currentPage);
	} else {
		$(pageNoLabel).text(0);
	}
	$(pageNoLabelLast).text(g_datagrid_map.paginationmap.totalPages);
	$(invtmgmtsysutil.getGridId(paginationIdsClasses.totalrecords)).text(g_datagrid_map.paginationmap.totalCount);
	datagridfunctions.buttonEnableDisable();
};

datagridfunctions.getCustomPageData = function() {
	if(invtmgmtsysutil.isNotEmptyObject(g_datagrid_map)) {
		$(g_datagrid_map.gridElement).find('select.custompagesize').off('change');
		$(g_datagrid_map.gridElement).find('select.custompagesize').on('change',function() {
			var pageSize = $(this).val();
			if($(this).val() === constants.ALL) {
				pageSize = g_datagrid_map.paginationmap.totalCount;
			}
			g_datagrid_map.paginationmap.pageSize = pageSize;
			g_datagrid_map.paginationmap.currentPage = 1;
			datagridfunctions.updateTotalPages();
			datagridfunctions.displayGridData();
		});
	}
}

datagridfunctions.displayGridData = function() {
	var responseMessage = datagridfunctions.getGridData(datagridfunctions.getJsonObj());
	datagridfunctions.displayDataGrid(responseMessage);
	datagridfunctions.displayPagination();
}

datagridfunctions.getJsonObj = function() {
	var jsonObj = {
		gridId : g_datagrid_map.gridId,
		dataRequestFor : g_datagrid_map.dataRequestFor,
		pageSize : g_datagrid_map.paginationmap.pageSize,
		currentPage : g_datagrid_map.paginationmap.currentPage
	};
	if(invtmgmtsysutil.isNotNullAndUndefined(g_datagrid_map.schId)) {
		jsonObj['schId'] = g_datagrid_map.schId;
	}
	if(invtmgmtsysutil.isNotNullAndUndefined(g_datagrid_map.sclsId)) {
		jsonObj['sclsId'] = g_datagrid_map.sclsId;
	}
		
	return jsonObj;
}

datagridfunctions.getPaginationHtml = function() {
	var div = $(g_datagrid_map.gridElement).find('div.bottom');
	$(div).empty();
	var paginationhtml = 'Total Records&nbsp;<span id="totalrecords"></span><span> Showing page </span>';
	paginationhtml += '<span id="pageNoLabel"></span><span> of </span><span id="pageNoLabelLast"></span>';
	paginationhtml += '<button type="button" class="btn btn-default btn-xs custompagination first">First</button>';
	paginationhtml += '<button type="button" class="btn btn-default btn-xs custompagination previous">Previous</button>';
	paginationhtml += '<button type="button" class="btn btn-default btn-xs custompagination next">Next</button>';
	paginationhtml += '<button type="button" class="btn btn-default btn-xs custompagination last">Last</button>';
	$(div).append(paginationhtml);
	datagridfunctions.bindpagination();
}

datagridfunctions.updateTotalPages = function() {
	var totalRecords = parseInt(g_datagrid_map.paginationmap.totalCount);
	var pageSize = parseInt(g_datagrid_map.paginationmap.pageSize);
	var totalPages;
	if(totalRecords%pageSize === 0) {
		totalPages =  totalRecords/pageSize;
	} else {
		totalPages = (totalRecords/pageSize) + 1;
	}
	g_datagrid_map.paginationmap.totalPages = parseInt(totalPages);
}

