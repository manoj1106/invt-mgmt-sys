package com.fpcs.invt.mgmt.sys.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.hql.internal.ast.SqlGenerator;

import com.fpcs.invt.mgmt.sys.constants.CommonConstants;
import com.fpcs.invt.mgmt.sys.constants.DataGridConstants;
import com.fpcs.invt.mgmt.sys.security.UserContext;
import com.fpcs.invt.mgmt.sys.security.UserContext.UserDetail;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.vo.DataGridVO;

public class DataGridUtil {

	private DataGridUtil() {
		
	}
	
	public static String getKey(DataGridVO dataGridVO) {
		StringBuilder key = new StringBuilder(dataGridVO.getGridId());
		key.append(DataGridConstants.UNDERSCORE_SEPERATOR).append(dataGridVO.getDataRequestFor());
		return key.toString();
	}
	
	public static String getKey(String key,String lastKey) {
		return key.concat(lastKey);
	}
	
	public static void setLimitOffset(DataGridVO dataGridVO) {
		dataGridVO.setLimit(dataGridVO.getPageSize());
		dataGridVO.setOffset((dataGridVO.getCurrentPage() - 1) * dataGridVO.getPageSize());
	}
	
	public static void setProperty(String key,Map<String,Object> dataMap) {
		/*dataMap.put(DataGridConstants.GUI_HTML_COLUMN, Arrays.asList(
				DataGridReader.getDataGridValue(DataGridUtil.getKey(key, DataGridConstants.HTML_COLUMN))
				.split(DataGridConstants.COMMA)));
		dataMap.put(DataGridConstants.GUI_HEADERS, Arrays.asList(
				DataGridReader.getDataGridValue(DataGridUtil.getKey(key, DataGridConstants.HEADERS))
				.split(DataGridConstants.COMMA)));
		dataMap.put(DataGridConstants.GUI_SORT_COLUMN, Arrays.asList(
				DataGridReader.getDataGridValue(DataGridUtil.getKey(key, DataGridConstants.SORT_COLUMN))
				.split(DataGridConstants.COMMA)));
		dataMap.put(DataGridConstants.GUI_FILTER_COLUMN, Arrays.asList(
				DataGridReader.getDataGridValue(DataGridUtil.getKey(key, DataGridConstants.FILTER_COLUMN))
				.split(DataGridConstants.COMMA)));*/
	}
	
	public static void setQueryText(DataGridVO dataGridVO,ErrorHandler errorHandler,Map<String,Object> contextMap) {
		/*String key = DataGridUtil.getKey(dataGridVO);
		DataGridUtil.setQueryParameter(dataGridVO, errorHandler, contextMap);
		switch(key) {
			case DataGridConstants.SECTION_REGISTRATION_SCHOOLDATA :
				dataGridVO.setQuery(SqlGenerator.getQueryText(dataGridVO, errorHandler, contextMap));
				break;
			case DataGridConstants.CLASS_REGISTRATION_SCHOOLDATA :
				dataGridVO.setQuery(SqlGenerator.getQueryText(dataGridVO, errorHandler, contextMap));
				break;
			case DataGridConstants.CLASS_REGISTRATION_ALLCLASSDATA :
				dataGridVO.setQuery(SqlGenerator.getQueryText(dataGridVO, errorHandler, contextMap));
				break;
			case DataGridConstants.CLASS_REGISTRATION_ALLSECTIONDATA :
				dataGridVO.setQuery(SqlGenerator.getQueryText(dataGridVO, errorHandler, contextMap));
				break;
			default :
				break;
		}*/
	}
	
	public static void setQueryParameter(DataGridVO dataGridVO,ErrorHandler errorHandler,Map<String,Object> contextMap) {
		/*Map<String,Object> queryParameter = new HashMap<>();
		String key = DataGridUtil.getKey(dataGridVO);
		UserContext userContext = (UserContext)contextMap.get(CommonConstants.USER_CONTEXT);
		UserDetail userDetail = userContext.getUserDetail();
		queryParameter.put(DataGridConstants.DB_COLUMN_NAMES, DataGridReader.getDataGridValue(DataGridUtil.getKey(key, DataGridConstants.DB_COLUMN)));
		queryParameter.put(DataGridConstants.DB_TABLE_NAME, DataGridReader.getDataGridValue(DataGridUtil.getKey(key, DataGridConstants.TABLE_NAME)));
		queryParameter.put(DataGridConstants.USER_ROLE, userDetail.getRole());
		if(SchoolManagementUtil.isNotNull(userDetail.getSchId())) {
			queryParameter.put(DataGridConstants.SCHOOL_ID, userDetail.getSchId());
		} else if(SchoolManagementUtil.isNotNull(dataGridVO.getSchId())) {
			queryParameter.put(DataGridConstants.SCHOOL_ID, dataGridVO.getSchId());
		} else {
			queryParameter.put(DataGridConstants.SCHOOL_ID, null);
		}
		queryParameter.put(DataGridConstants.SCLS_ID, dataGridVO.getSclsId());
		dataGridVO.setQueryParameter(queryParameter);*/
	}
	
	public static Integer calculateTotalPages(Integer totalRecords,Integer pageSize) {
		if(totalRecords%pageSize == 0) {
			return totalRecords/pageSize;
		} else {
			return totalRecords/pageSize + 1;
		}
	}
}
