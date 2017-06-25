var sectionregistrationfunction = {
		getSchooldata : function(pageSize, currentPage, totalPages) {
			var paginationmap = datagridfunctions.getPaginationMap(pageSize, currentPage, totalPages);
			g_datagrid_map = {
				paginationmap : paginationmap,
				gridId : gridIdsMap.sectionregistration,
				gridElement : invtmgmtsysutil.getGridId(gridIdsMap.sectionregistration),
				dataRequestFor : dataRequestFor.schooldata
			};
			var jsonObj = datagridfunctions.getJsonObj();
			var responseData = datagridfunctions.getGridData(jsonObj);
			datagridfunctions.displayDataGrid(responseData);
		},
		addSectionRegistrationButton : function() {
			var table = $(g_datagrid_map.gridElement).find('table.schooldata');
			$(table).find('thead tr').append(datagridfunctions.getTh("Operations"));
			var tbodyTr = $(table).find('tbody tr');
			$(tbodyTr).each(function(){
				var button = '<a href="#" type="button" class="btn btn-info btn-flat tooltip-display" title="" tooltip="" data-original-title="Add Section"><i class="fa fa-th-large"></i></a>';
				button += '&nbsp<a href="#" type="button" class="btn btn-danger btn-flat tooltip-display" title="" tooltip="" data-original-title="Remove"><i class="fa fa-trash-o"></i></a>';
				$(this).append(datagridfunctions.getTd(button));
			});
		},
		getSchoolTotalRecords : function() {
			var responseMessage = datagridfunctions.getTotalRecords(datagridfunctions.getJsonObj());
			datagridfunctions.updatePaginationMap(responseMessage);
			datagridfunctions.displayPagination();
		}
};

$(function(){
	g_datagrid_map = {};
	sectionregistrationfunction.getSchooldata(PAGINATION_DETAILS.DEFAULT_PAGE_SIZE,1,0);
	datagridfunctions.getPaginationHtml();
	sectionregistrationfunction.getSchoolTotalRecords();
	datagridfunctions.setCustomPageSizes();
	datagridfunctions.onmousehover();
	invtmgmtsysutil.hideLoader();
});



