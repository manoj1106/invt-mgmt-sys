package com.fpcs.invt.mgmt.sys.constants;

public class SchemaDetails {

	public static final String REFERENCE_DATA =  "reference_data";
	public static final String RESULT_DATA = "result_data"; 
	public static final String SYSTEM_DATA = "system_data";
	public static final String SHOP_DATA = "shop_data";
	public static final String USER_DATA = "user_data";
	
	/*** menu item sequence ***/
	public static final String DB_MENU_ITEM_SEQ_NAME = "menu_item_access_menu_item_access_id_seq";
	public static final String MENU_ITEM_SEQ_NAME = "menu_item_access_id_seq";
	
	/*** school id sequence BEGIN ***/
	public static final String DB_SEQ_SHOP_ID_NAME = "shop_details_shop_id_seq";
	public static final String SEQ_SHOP_ID_NAME = "shop_id_seq";
	/*** school id sequence END ***/
	
	/*** section id sequence BEGIN ***/
	public static final String DB_SEQ_SECTION_ID_NAME = "section_details_section_id_seq";
	public static final String SEQ_SECTION_ID_NAME = "section_id_seq";
	/*** section id sequence END ***/
	
	/*** class id sequence BEGIN ***/
	public static final String SCH_CLS_ID_SEQ_NAME = "class_id_seq";
	public static final String DB_SCH_CLS_ID_SEQ_NAME = "class_details_class_id_seq";
	/*** class id sequence BEGIN ***/
	
	/*** staff details id sequence BEGIN ***/
	public static final String SEQ_STAFF_DETAILS_ID_SEQ_NAME = "staff_details_id_seq";
	public static final String DB_SEQ_STAFF_DETAILS_ID_NAME = "staff_details_staff_details_id_seq";
	/*** staff details id sequence BEGIN ***/
	
	
	public static final int INITIAL_VALUE = 123456;
	public static final int DEFLT_ALLOC_SIZE = 1;
	
	
	
	private SchemaDetails() {
		
	}
	
}
