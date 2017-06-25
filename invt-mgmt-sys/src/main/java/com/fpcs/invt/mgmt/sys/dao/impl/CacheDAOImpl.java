package com.fpcs.invt.mgmt.sys.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fpcs.invt.mgmt.sys.constants.DAOConstants;
import com.fpcs.invt.mgmt.sys.dao.CacheDAO;
import com.fpcs.invt.mgmt.sys.domain.static_data.City;
import com.fpcs.invt.mgmt.sys.domain.static_data.State;
import com.fpcs.invt.mgmt.sys.domain.user_data.Roles;
import com.fpcs.invt.mgmt.sys.enums.ERROR_CODE;
import com.fpcs.invt.mgmt.sys.utils.exception.InvtMgmtSysException;

@Repository
public class CacheDAOImpl implements CacheDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CacheDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Roles> getRoles() {
		logger.debug("fetching roles...");
		List<Roles> roles = null;
		Session session = entityManager.unwrap(Session.class);
		try {
			StringBuilder hql = new StringBuilder();
			hql.append("from Roles where ").append(DAOConstants.DETELED_DATE_CHECK_HQL);
			Query<Roles> query = session.createQuery(hql.toString(), Roles.class);
			roles = query.getResultList();
		} catch (HibernateException e) {
			logger.error("error occurred while fetching roles " , e);
			throw new InvtMgmtSysException(ERROR_CODE.HIBERNATE_EXCEPTION.getErrorCode(), e);
		} finally {
			session.flush();
			session.close();
		}
		return roles;
	}
	
	@Override
	@Transactional
	public List<String> getCountries() {
		logger.debug("fetching countries...");
		List<String> countries = null;
		Session session = entityManager.unwrap(Session.class);
		try {
			StringBuilder hql = new StringBuilder();
			hql.append("select country from Country where ").append(DAOConstants.DETELED_DATE_CHECK_HQL)
			.append(" order by country");
			Query<String> query = session.createQuery(hql.toString(), String.class);
			countries = query.getResultList();
		} catch (HibernateException e) {
			logger.error("error occurred while fetching countries..." , e);
			throw new InvtMgmtSysException(ERROR_CODE.HIBERNATE_EXCEPTION.getErrorCode(), e);
		} finally {
			session.flush();
			session.close();
		}
		return countries;
	}

	@Override
	@Transactional
	public List<State> getStates() {
		logger.debug("fetching states...");
		List<State> states = null;
		Session session = entityManager.unwrap(Session.class);
		try {
			StringBuilder hql = new StringBuilder();
			hql.append("from State where ").append(DAOConstants.DETELED_DATE_CHECK_HQL)
			.append(" order by state");
			Query<State> query = session.createQuery(hql.toString(), State.class);
			states = query.getResultList();
		} catch (HibernateException e) {
			logger.error("error occurred while fetching states..." , e);
			throw new InvtMgmtSysException(ERROR_CODE.HIBERNATE_EXCEPTION.getErrorCode(), e);
		} finally {
			session.flush();
			session.close();
		}
		return states;
	}

	@Override
	@Transactional
	public List<City> getCities() {
		logger.debug("fetching cities...");
		List<City> cities = null;
		Session session = entityManager.unwrap(Session.class);
		try {
			StringBuilder hql = new StringBuilder();
			hql.append("from City where ").append(DAOConstants.DETELED_DATE_CHECK_HQL)
			.append(" order by city");
			Query<City> query = session.createQuery(hql.toString(), City.class);
			cities = query.getResultList();
		} catch (HibernateException e) {
			logger.error("error occurred while fetching cities..." , e);
			throw new InvtMgmtSysException(ERROR_CODE.HIBERNATE_EXCEPTION.getErrorCode(), e);
		} finally {
			session.flush();
			session.close();
		}
		return cities;
	}
	
	
	
}
