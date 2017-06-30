package com.fpcs.invt.mgmt.sys.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fpcs.invt.mgmt.sys.dao.DataGridDAO;
import com.fpcs.invt.mgmt.sys.enums.ERROR_CODE;
import com.fpcs.invt.mgmt.sys.utils.exception.InvtMgmtSysException;
import com.fpcs.invt.mgmt.sys.vo.DataGridVO;

@SuppressWarnings("unchecked")
@Repository
public class DataGridDAOImpl implements DataGridDAO {

	private static final Logger logger = LoggerFactory.getLogger(DataGridDAOImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Object[]> getDataGrid(DataGridVO dataGridVO) {
		List<Object[]> dataGrids = null;
		Session session = entityManager.unwrap(Session.class);
		Query<Object[]> query = null;
		try {
			query = session.createNativeQuery(dataGridVO.getQuery());
			query.setFirstResult(dataGridVO.getOffset());
			query.setMaxResults(dataGridVO.getLimit());
			dataGrids = query.getResultList();
		} catch(HibernateException exception) {
			logger.error("error occured while fetching data grid" , exception);
			throw new InvtMgmtSysException(ERROR_CODE.HIBERNATE_EXCEPTION.getErrorCode(), exception);
		} finally {
			query = null;
			session.flush();
		}
		return dataGrids;
	}
	
	@Override
	public Integer getTotalRecords(DataGridVO dataGridVO) {
		Session session = entityManager.unwrap(Session.class);
		Query<BigInteger> query = null;
		BigInteger totalRecords = null;
		try {
			query = session.createNativeQuery(dataGridVO.getQuery() , BigInteger.class);
			totalRecords = (BigInteger)query.uniqueResult();
			boolean isFetched = (null == totalRecords) ? true : false; 
			if(isFetched) {
				return 0;
			} else {
				return totalRecords.intValue();
			}
		} catch(HibernateException exception) {
			logger.error("error occured while fetching total records." , exception);
			throw new InvtMgmtSysException(ERROR_CODE.HIBERNATE_EXCEPTION.getErrorCode(), exception);
		} finally {
			query = null;
			session.flush();
		}
	}
	
}
