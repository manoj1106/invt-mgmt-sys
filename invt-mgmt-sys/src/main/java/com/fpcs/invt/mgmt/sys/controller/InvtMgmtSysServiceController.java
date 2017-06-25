package com.fpcs.invt.mgmt.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpcs.invt.mgmt.sys.constants.ControllerConstants;
import com.fpcs.invt.mgmt.sys.service.InvtMgmtSysService;
import com.fpcs.invt.mgmt.sys.utils.ResponseMessage;
import com.fpcs.invt.mgmt.sys.vo.InvtMgmtSysVO;

@Controller
@RequestMapping(value = ControllerConstants.BASE_URL_GENERIC)
public class InvtMgmtSysServiceController {
	
	private static Logger logger = LoggerFactory.getLogger(InvtMgmtSysServiceController.class);
	
	@Autowired
	private InvtMgmtSysService invtMgmtSysService;

	@ResponseBody
	@RequestMapping(value = ControllerConstants.GET_STATES_BY_COUNTRY , method = RequestMethod.POST)
	public ResponseMessage getStatesByCountry(@RequestBody InvtMgmtSysVO invtMgmtSysVO,HttpServletRequest request) {
		return invtMgmtSysService.getStatesByCountry(invtMgmtSysVO, null, null);
	}
	
	@ResponseBody
	@RequestMapping(value = ControllerConstants.GET_CITIES_BY_STATES , method = RequestMethod.POST)
	public ResponseMessage getCitiesByStates(@RequestBody InvtMgmtSysVO invtMgmtSysVO,HttpServletRequest request) {
		return invtMgmtSysService.getCitiesByStates(invtMgmtSysVO, null, null);
	}
	
}
