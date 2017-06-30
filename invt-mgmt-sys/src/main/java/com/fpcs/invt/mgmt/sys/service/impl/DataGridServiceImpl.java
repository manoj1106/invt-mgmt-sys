package com.fpcs.invt.mgmt.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.hql.internal.ast.SqlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpcs.invt.mgmt.sys.constants.DataGridConstants;
import com.fpcs.invt.mgmt.sys.dao.DataGridDAO;
import com.fpcs.invt.mgmt.sys.service.DataGridService;
import com.fpcs.invt.mgmt.sys.utils.DataGridUtil;
import com.fpcs.invt.mgmt.sys.utils.ResponseMessage;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.utils.exception.InvtMgmtSysException;
import com.fpcs.invt.mgmt.sys.vo.DataGridVO;

@Service
public class DataGridServiceImpl implements DataGridService {
	
	@Autowired
	private DataGridDAO dataGridDAO; 
	
	@Override
	@Transactional
	public ResponseMessage getDataGrid(DataGridVO dataGridVO,ErrorHandler errorHandler,Map<String,Object> contextMap) {
		ResponseMessage responseMessage = new ResponseMessage();
		Map<String,Object> dataMap = new HashMap<>();
		List<Object[]> dataList = null;
		String key = DataGridUtil.getKey(dataGridVO);
		try {
			DataGridUtil.setProperty(key, dataMap);
			DataGridUtil.setLimitOffset(dataGridVO);
			DataGridUtil.setQueryText(dataGridVO,errorHandler,contextMap);
			dataList = dataGridDAO.getDataGrid(dataGridVO);
			dataMap.put("dataList", dataList);
		} catch(InvtMgmtSysException e) {
			
		}
		responseMessage.setDataMap(dataMap);
		return responseMessage;
	}
	
	@Override
	@Transactional
	public ResponseMessage getTotalRecordsCount(DataGridVO dataGridVO,ErrorHandler errorHandler,Map<String,Object> contextMap) {
		ResponseMessage responseMessage = new ResponseMessage();
		Map<String,Object> dataMap = new HashMap<>();
		try {
			DataGridUtil.setQueryParameter(dataGridVO, errorHandler, contextMap);
			//dataGridVO.setQuery(SqlGenerator.getTotalRecordsQuery(dataGridVO, errorHandler, contextMap));
			Integer totalRecords = dataGridDAO.getTotalRecords(dataGridVO);
			dataMap.put(DataGridConstants.GUI_TOTAL_COUNT, totalRecords);
			dataMap.put(DataGridConstants.GUI_TOTAL_PAGES, DataGridUtil.calculateTotalPages(totalRecords, dataGridVO.getPageSize()));
		} catch(InvtMgmtSysException e) {
			
		}
		responseMessage.setDataMap(dataMap);
		return responseMessage;
	}
	
}
