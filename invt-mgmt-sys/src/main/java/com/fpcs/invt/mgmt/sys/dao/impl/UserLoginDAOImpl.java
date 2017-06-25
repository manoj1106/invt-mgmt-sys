package com.fpcs.invt.mgmt.sys.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fpcs.invt.mgmt.sys.dao.UserLoginDAO;
import com.fpcs.invt.mgmt.sys.domain.UserLogin;

@Repository
public class UserLoginDAOImpl implements UserLoginDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserLoginDAOImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserLogin getUserLogin(String username) {
		logger.debug("fetching user login details for username {} " , username);
		UserLogin userLogin = null;
		Session session = entityManager.unwrap(Session.class);
		try {
			Query<UserLogin> query = session.createQuery("from UserLogin where userName=:username" , UserLogin.class);
			query.setParameter("username", username);
			userLogin = query.getSingleResult();
			if(null != userLogin) {
				Hibernate.initialize(userLogin.getRoles());
				Hibernate.initialize(userLogin.getShopDetails());
			}
		} catch(HibernateException e) {
			logger.error("error occurred while fetching user login details");
		}
		return userLogin;
	}
	
	
	
}
