var g_selected_schoolId = null;
var classregistrationfunction = {
		getSchooldata : function(pageSize, currentPage, totalPages) {
			var paginationmap = datagridfunctions.getPaginationMap(pageSize, currentPage, totalPages);
			g_datagrid_map = {
				paginationmap : paginationmap,
				gridId : gridIdsMap.classregistration,
				gridElement : invtmgmtsysutil.getGridId(gridIdsMap.classregistration),
				dataRequestFor : dataRequestFor.schooldata
			};
			var jsonObj = datagridfunctions.getJsonObj();
			var responseData = datagridfunctions.getGridData(jsonObj);
			datagridfunctions.displayDataGrid(responseData);
			datagridfunctions.displayTitle(titles.SchoolList);
		},
		addClassRegistrationButton : function() {
			var table = $(g_datagrid_map.gridElement).find('table.schooldata');
			$(table).find('thead tr').append(datagridfunctions.getTh("Operations"));
			var tbodyTr = $(table).find('tbody tr');
			$(tbodyTr).each(function(){
				var button = '<a href="#" type="button" class="btn btn-info btn-flat tooltip-display listclass" title="" tooltip="" data-original-title="List Classes"><i class="fa fa-list"></i></a>';
				button += '&nbsp;<a href="#" type="button" class="btn btn-info btn-flat tooltip-display addclasses" title="" tooltip="" data-original-title="Add Classes"><i class="fa fa-pencil"></i></a>';
				$(this).append(datagridfunctions.getTd(button));
			});
			classregistrationfunction.bindClassRegistrationButton();
		},
		getTotalRecords : function() {
			var responseMessage = datagridfunctions.getTotalRecords(datagridfunctions.getJsonObj());
			datagridfunctions.updatePaginationMap(responseMessage);
			datagridfunctions.displayPagination();
		},
		bindClassRegistrationButton : function() {
			var a = $(g_datagrid_map.gridElement).find('table.'+g_datagrid_map.dataRequestFor+' tr a.btn');
			$(a).off('click');
			$(a).on('click',function(e) {
				e.preventDefault();
				var schId = $(this).closest('tr').find('td').eq(keyposArray['School ID']).text();
				g_selected_schoolId = schId;
				if($(this).hasClass('listclass')){
					classregistrationfunction.listClasses(schId,PAGINATION_DETAILS.DEFAULT_PAGE_SIZE,1,0);
					classregistrationfunction.getTotalRecords();
				} else if($(this).hasClass('addclasses')) {
					$('#schId').val(schId);
					$('#classModal').modal('show');
					classregistrationfunction.addClasses();
				}
			});
		},
		addClasses : function() {
			var a = $('#classModal a.addclass');
			$(a).off('click');
			$(a).on('click',function(e){
				e.preventDefault();
				var form = $(this).parents('div.classregistration').find('form');
				if(formfieldvalidator.validateform($(form))) {
					var jsonObj = {
							schId : $('#schId').val(),
							sclsName : $('#sclsName').val()
					};
					var responseMessage = schoolmanagementfunctions.ajaxServerRequestResponse(URL.REGISTER_CLASS, jsonObj);
					if(invtmgmtsysutil.isNotEmptyObject(responseMessage)) {
						schoolmanagementfunctions.printSuccessErrorMessage(constants.MESSAGE, responseMessage);
					}
				}
			});
		},
		listClasses : function(schId,pageSize, currentPage, totalPages) {
			var paginationmap = datagridfunctions.getPaginationMap(pageSize, currentPage, totalPages);
			g_datagrid_map = {};
			g_datagrid_map = {
				paginationmap : paginationmap,
				gridId : gridIdsMap.classregistration,
				gridElement : invtmgmtsysutil.getGridId(gridIdsMap.classregistration),
				dataRequestFor : dataRequestFor.allclassdata,
				schId : schId
			};
			$(g_datagrid_map.gridElement).find('table.schooldata').empty();
			var responseData = datagridfunctions.getGridData(datagridfunctions.getJsonObj());
			datagridfunctions.displayDataGrid(responseData);
			datagridfunctions.displayTitle(titles.ClassList);
			$(g_datagrid_map.gridElement).find('div.allclassdata').removeClass('display-none');
			$(g_datagrid_map.gridElement).find('div.schooldata').addClass('display-none');
		},
		bindReturnButton : function() {
			var a = $('a.return');
			$(a).off('click');
			$(a).on('click',function(e){
				e.preventDefault();
				if($(this).hasClass('allclassdata')) {
					g_selected_schoolId = null;
					$(g_datagrid_map.gridElement).find('table.allclassdata').empty();
					classregistrationfunction.getSchooldata(PAGINATION_DETAILS.DEFAULT_PAGE_SIZE,1,0);
					classregistrationfunction.getTotalRecords();
					$(g_datagrid_map.gridElement).find('div.schooldata').removeClass('display-none');
					$(g_datagrid_map.gridElement).find('div.allclassdata').addClass('display-none');
				} else if($(this).hasClass('allsectiondata')) {
					$(g_datagrid_map.gridElement).find('table.allsectiondata').empty();
					classregistrationfunction.listClasses(g_selected_schoolId,PAGINATION_DETAILS.DEFAULT_PAGE_SIZE,1,0);
					classregistrationfunction.getTotalRecords();
					$(g_datagrid_map.gridElement).find('div.allclassdata').removeClass('display-none');
					$(g_datagrid_map.gridElement).find('div.allsectiondata').addClass('display-none');
				}
			});
		},
		addSectionRegistrationButton : function() {
			var table = $(g_datagrid_map.gridElement).find('table.allclassdata');
			$(table).find('thead tr').append(datagridfunctions.getTh("Operations"));
			var tbodyTr = $(table).find('tbody tr');
			$(tbodyTr).each(function(){
				var button = '<a href="#" type="button" class="btn btn-info btn-flat tooltip-display listsections" title="" tooltip="" data-original-title="List Sections"><i class="fa fa-list"></i></a>';
				button += '&nbsp;<a href="#" type="button" class="btn btn-info btn-flat tooltip-display addsections" title="" tooltip="" data-original-title="Add Section"><i class="fa fa-pencil"></i></a>';
				button += '&nbsp;<a href="#" type="button" class="btn btn-danger btn-flat tooltip-display deleteClass" title="" tooltip="" data-original-title="Remove Class"><i class="fa fa-trash-o"></i></a>';
				$(this).append(datagridfunctions.getTd(button));
			});
			classregistrationfunction.bindSectionRegistrationButton();
		},
		bindSectionRegistrationButton : function() {
			var a = $(g_datagrid_map.gridElement).find('table.'+g_datagrid_map.dataRequestFor+' tr a.btn');
			$(a).off('click');
			$(a).on('click',function(e) {
				e.preventDefault();
				var sclsId = $(this).closest('tr').find('td').eq(keyposArray['Class ID']).text();
				if($(this).hasClass('listsections')) {
					classregistrationfunction.listSections(sclsId,PAGINATION_DETAILS.DEFAULT_PAGE_SIZE,1,0);
					classregistrationfunction.getTotalRecords();
				} else if($(this).hasClass('addsections')) {
					$('#sclsId').val(sclsId);
					$('#sectionModal').modal('show');
					classregistrationfunction.addLanguages();
					classregistrationfunction.addSections();
				}
			});
		},
		addSections : function() {
			var a = $('#sectionModal a.addsection');
			$(a).off('click');
			$(a).on('click',function(e){
				e.preventDefault();
				var form = $(this).parents('div.sectionregistration').find('form');
				if(formfieldvalidator.validateform($(form))) {
					var jsonObj = {
						sclsId : $('#sclsId').val(),
						ssecName : $('#ssecName').val(),
						medium : $('#medium').val()
					};
					var responseMessage = schoolmanagementfunctions.ajaxServerRequestResponse(URL.REGISTER_SECTION, jsonObj);
					if(invtmgmtsysutil.isNotEmptyObject(responseMessage)) {
						schoolmanagementfunctions.printSuccessErrorMessage(constants.MESSAGE, responseMessage);
					}
				}
			});
		}, 
		addLanguages : function() {
			var jsonObj = {
				schId : g_selected_schoolId	
			};
			var responseMessage = schoolmanagementfunctions.ajaxServerRequestResponse(URL.GET_SCHOOL_LANGUAGES, jsonObj);
			var languages = responseMessage.dataMap.languages;
			$('#medium').empty();
			var option = '<option value='+constants.SELECT+'>'+constants.SELECT_HIFEN+'</option>';
			$.each(languages,function(index,language){
				option += '<option value='+language+'>'+language+'</option>';
			});
			$('#medium').append(option);
		},
		listSections : function(sclsId,pageSize, currentPage, totalPages) {
			var paginationmap = datagridfunctions.getPaginationMap(pageSize, currentPage, totalPages);
			g_datagrid_map = {};
			g_datagrid_map = {
				paginationmap : paginationmap,
				gridId : gridIdsMap.classregistration,
				gridElement : invtmgmtsysutil.getGridId(gridIdsMap.classregistration),
				dataRequestFor : dataRequestFor.allsectiondata,
				sclsId : sclsId
			};
			datagridfunctions.displayTitle(titles.SectionList);
			$(g_datagrid_map.gridElement).find('table.allclassdata').empty();
			var responseData = datagridfunctions.getGridData(datagridfunctions.getJsonObj());
			datagridfunctions.displayDataGrid(responseData);
			$(g_datagrid_map.gridElement).find('div.allsectiondata').removeClass('display-none');
			$(g_datagrid_map.gridElement).find('div.allclassdata').addClass('display-none');
		}
};

$(function(){
	g_datagrid_map = {};
	classregistrationfunction.getSchooldata(PAGINATION_DETAILS.DEFAULT_PAGE_SIZE,1,0);
	datagridfunctions.getPaginationHtml();
	classregistrationfunction.getTotalRecords();
	datagridfunctions.setCustomPageSizes();
	classregistrationfunction.bindReturnButton();
	invtmgmtsysutil.hideLoader();
});

