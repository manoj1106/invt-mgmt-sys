/**
 * 
 */
package com.fpcs.invt.mgmt.sys.constants;

/**
 * @author Manoj Patel
 *
 */
public class ControllerConstants {

	public static final String USER_ROLE = "userrole";
	public static final String MENUES = "menues";
	public static final String ROLES = "roles";
	public static final String COUNTRIES = "countries";
	
	public static final String MESSAGES = "messages";
	public static final String RESPONSE_MESSAGE = "ResponseMessage";
	
	public static final String BASE_URL_GENERIC = "/invtmgmtsys";
	public static final String GET_STATES_BY_COUNTRY = "/getStatesByCountry";
	public static final String GET_CITIES_BY_STATES = "/getCitiesByStates";
	
	
	//user login controller uri constants
	public static final String BASE_URL = "/";
	public static final String INDEX = "/index";
	public static final String LOGIN = "/login";
	public static final String LOGOUT = "logout";
	public static final String ERROR = "error";
	public static final String ERROR_PAGE = "/403";
	
	//menu item access uri constants
	public static final String MENU_ITEM_ACCESS_BASE_URL = "/menuitemaccess";
	public static final String MENU_ITEM_ACCESS = "/menuitemaccess";
	public static final String SAVE_MENU_ITEM_ACCESS = "/saveMenuItemAccess";
	public static final String GET_MENU_ITEMS = "/getMenuItems";
	
	//registration uri constants
	public static final String REGISTRATION_BASE_URL = "/registration";
	public static final String SHOP_REGISTRATION = "/shopregistration";
	public static final String USER_REGISTRATION = "/userregistration";
	public static final String SAVE_SHOP_DETAILS = "/saveShopDetails";
	
	private ControllerConstants() {
		
	}
	
}
