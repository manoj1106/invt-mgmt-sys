/**
 * 
 */
package com.fpcs.invt.mgmt.sys.dao.impl;

import static com.fpcs.invt.mgmt.sys.constants.DAOConstants.ROLE;
import static com.fpcs.invt.mgmt.sys.constants.DAOConstants.SHOP_ID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fpcs.invt.mgmt.sys.dao.MenuItemAccessDAO;
import com.fpcs.invt.mgmt.sys.domain.MenuItemAccess;
import com.fpcs.invt.mgmt.sys.enums.ERROR_CODE;
import com.fpcs.invt.mgmt.sys.utils.InvtMgmtUtil;
import com.fpcs.invt.mgmt.sys.utils.exception.InvtMgmtSysException;;

/**
 * @author Manoj Patel
 *
 */
@Repository
public class MenuItemAccessDAOImpl implements MenuItemAccessDAO {

	private static final Logger logger = LoggerFactory.getLogger(MenuItemAccessDAOImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean saveMenuItemAccess(MenuItemAccess menuItemAccess) {
		Session session = entityManager.unwrap(Session.class);
		try {
			session.saveOrUpdate(menuItemAccess);
			return true;
		} catch(HibernateException hibernateException) {
			logger.error("exception occured while saving menu items", hibernateException);
			throw new InvtMgmtSysException(ERROR_CODE.HIBERNATE_EXCEPTION.getErrorCode(), hibernateException);
		}
	}
	
	@Override
	public MenuItemAccess getMenuItemAccess(Long shopId,String role) {
		MenuItemAccess menuItemAccess = null;
		Session session = entityManager.unwrap(Session.class);
		Query<MenuItemAccess> query = null;
		StringBuilder queryString = new StringBuilder();
		try {
			queryString.append("from MenuItemAccess where  id.role=:role ");
			if(InvtMgmtUtil.isNotNull(shopId)) {
				queryString.append(" and shopId=:shopId");
			}
			query = session.createQuery(queryString.toString() , MenuItemAccess.class);
			if(InvtMgmtUtil.isNotNull(shopId)) {
				query.setParameter(SHOP_ID, shopId);
			}
			query.setParameter(ROLE, role);
			menuItemAccess = (MenuItemAccess)query.uniqueResult();
		} catch(HibernateException hibernateException) {
			logger.error("Error occured while fetching menu item access",hibernateException);
			throw new InvtMgmtSysException(ERROR_CODE.HIBERNATE_EXCEPTION.getErrorCode(), hibernateException);
		}
		return menuItemAccess;
	}
	
}
