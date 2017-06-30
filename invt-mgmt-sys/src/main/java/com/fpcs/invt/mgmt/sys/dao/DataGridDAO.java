package com.fpcs.invt.mgmt.sys.dao;

import java.util.List;

import com.fpcs.invt.mgmt.sys.vo.DataGridVO;

public interface DataGridDAO {

	List<Object[]> getDataGrid(DataGridVO dataGridVO);
	
	Integer getTotalRecords(DataGridVO dataGridVO);
	
}
