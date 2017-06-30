package com.fpcs.invt.mgmt.sys.vo;

import java.util.Map;

public class DataGridVO {

	private String query;
	private Integer limit;
	private Integer offset;
	private Integer pageSize;
	private Integer totalPages;
	private Integer currentPage;
	private String gridId;
	private String dataRequestFor;
	private Map<String, Map<String, String>> criteriaMap;
	private Map<String, Object> queryParameter;
	private Long schId;
	private Long sclsId;
	private Long ssecId;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String getGridId() {
		return gridId;
	}

	public void setGridId(String gridId) {
		this.gridId = gridId;
	}

	public String getDataRequestFor() {
		return dataRequestFor;
	}

	public void setDataRequestFor(String dataRequestFor) {
		this.dataRequestFor = dataRequestFor;
	}

	public Map<String, Map<String, String>> getCriteriaMap() {
		return criteriaMap;
	}

	public void setCriteriaMap(Map<String, Map<String, String>> criteriaMap) {
		this.criteriaMap = criteriaMap;
	}

	public Map<String, Object> getQueryParameter() {
		return queryParameter;
	}

	public void setQueryParameter(Map<String, Object> queryParameter) {
		this.queryParameter = queryParameter;
	}

	public Long getSchId() {
		return schId;
	}

	public void setSchId(Long schId) {
		this.schId = schId;
	}

	public Long getSclsId() {
		return sclsId;
	}

	public void setSclsId(Long sclsId) {
		this.sclsId = sclsId;
	}

	public Long getSsecId() {
		return ssecId;
	}

	public void setSsecId(Long ssecId) {
		this.ssecId = ssecId;
	}

}
