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

import com.fpcs.invt.mgmt.sys.dao.CacheDAO;
import com.fpcs.invt.mgmt.sys.domain.Roles;

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
			Query<Roles> query = session.createQuery("from Roles", Roles.class);
			roles = query.getResultList();
		} catch (HibernateException e) {
			logger.error("error occurred while fetching roles " , e);
		} finally {
			session.flush();
			session.close();
		}
		return roles;
	}
	
}
