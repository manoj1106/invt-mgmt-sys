package com.fpcs.invt.mgmt.sys.service;

import java.util.Map;

import com.fpcs.invt.mgmt.sys.utils.ResponseMessage;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.vo.DataGridVO;

public interface DataGridService {

	ResponseMessage getDataGrid(DataGridVO dataGridVO,ErrorHandler errorHandler,Map<String,Object> contextMap);
	
	ResponseMessage getTotalRecordsCount(DataGridVO dataGridVO,ErrorHandler errorHandler,Map<String,Object> contextMap);
}
