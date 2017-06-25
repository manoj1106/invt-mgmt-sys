package com.fpcs.invt.mgmt.sys.service;

import java.util.Map;

import com.fpcs.invt.mgmt.sys.utils.ResponseMessage;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.vo.InvtMgmtSysVO;

public interface InvtMgmtSysService {

	public ResponseMessage getStatesByCountry(InvtMgmtSysVO invtMgmtSysVO , ErrorHandler errorHandler,
			Map<String,Object> contextMap);
	
	public ResponseMessage getCitiesByStates(InvtMgmtSysVO invtMgmtSysVO , ErrorHandler errorHandler,
			Map<String,Object> contextMap);
	
}
