package com.fpcs.invt.mgmt.sys.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fpcs.invt.mgmt.sys.dao.RegistrationDAO;
import com.fpcs.invt.mgmt.sys.domain.shop_data.ShopDetails;
import com.fpcs.invt.mgmt.sys.domain.user_data.UserLogin;
import com.fpcs.invt.mgmt.sys.enums.ERROR_CODE;
import com.fpcs.invt.mgmt.sys.utils.exception.InvtMgmtSysException;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {
	
	private static Logger logger = LoggerFactory.getLogger(RegistrationDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long saveShopDetails(ShopDetails shopDetails) {
		Session session = entityManager.unwrap(Session.class);
		try {
			session.save(shopDetails);
		} catch(HibernateException e) {
			logger.error("exception occurred while saving shop details" , e);
			throw new InvtMgmtSysException(ERROR_CODE.HIBERNATE_EXCEPTION.getErrorCode(), e);
		}
		return shopDetails.getShopId();
	}

	@Override
	public boolean saveUserDetails(UserLogin userLogin) {
		Session session = entityManager.unwrap(Session.class);
		try {
			session.save(userLogin);
			return true;
		} catch(HibernateException e) {
			logger.error("exception occurred while saving user login details" , e);
			throw new InvtMgmtSysException(ERROR_CODE.HIBERNATE_EXCEPTION.getErrorCode(), e);
		}
	}
	
}
