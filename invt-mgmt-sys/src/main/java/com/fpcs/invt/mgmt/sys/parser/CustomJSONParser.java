package com.fpcs.invt.mgmt.sys.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fpcs.invt.mgmt.sys.constants.JsonConstants;
import com.fpcs.invt.mgmt.sys.utils.FileReaderWriter;
import com.fpcs.invt.mgmt.sys.utils.InvtMgmtUtil;

@SuppressWarnings("unchecked")
public class CustomJSONParser {

	private JSONObject getJSONObject(String fileName) throws ParseException,IOException {
		JSONParser parser = new JSONParser();
		InputStream in = FileReaderWriter.getInputStream(fileName);
		String jsonText = IOUtils.toString(in);
		Object obj = parser.parse(jsonText);
		return (JSONObject)obj;
	}
	
	public String getMenuItem(String fileName) throws ParseException,IOException {
		JSONObject obj = this.getJSONObject(fileName);
		JSONObject jsonObj = (JSONObject)obj.get("AllMenues");
		return this.buildMenuItemAccess(true,jsonObj);
	}
	
	public Set<String> getAllowedMenuItems(String json) throws ParseException,IOException {
		String jsonString = (String)(getJsonObj(json).get("allowedMenues"));
		JSONObject jsonObj = getJsonObj(jsonString);
		return this.getMenuItem(jsonObj);
	}
	
	public String getAllowedMenuItem(String json) throws ParseException {
		StringBuilder menuItem = new StringBuilder();
		String jsonString = (String)(getJsonObj(json).get("allowedMenues"));
		JSONObject jsonObj = getJsonObj(jsonString);
		Iterator<String> iter = jsonObj.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String value = String.valueOf(jsonObj.get(key));
			if(InvtMgmtUtil.isNotBlank(value) &&
					value.startsWith(JsonConstants.JSON_START_TOKEN)) {
				menuItem.append(this.getLi(key, this.getJsonObj(value)));
			} else {
				menuItem.append(this.getLi(true,String.valueOf(jsonObj.get(key))));
			}
		}
		return menuItem.toString();
	}
	
	private JSONObject getJsonObj(String json) throws ParseException {
		JSONParser parser = new JSONParser();
		return (JSONObject)parser.parse(json);
	}
	
	
	private  Set<String> getMenuItem(JSONObject jsonObj) throws ParseException {
		Set<String> menuItems = new HashSet<>();
		this.getAllowedMenuItems(menuItems, jsonObj);
		return menuItems;
	}
	
	private Set<String> getAllowedMenuItems(Set<String> menuItems,JSONObject jsonObj) throws ParseException {
		Iterator<String> iter = jsonObj.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			if(jsonObj.get(key) instanceof String) {
				String value = String.valueOf(jsonObj.get(key));
				if(InvtMgmtUtil.isNotBlank(value) &&
						value.startsWith(JsonConstants.JSON_START_TOKEN)) {
					menuItems.add(key);
					this.getAllowedMenuItems(menuItems,this.getJsonObj(value));
				}
				menuItems.add(String.valueOf(value));
			} else if(jsonObj.get(key) instanceof JSONObject) {
				JSONObject object = (JSONObject)jsonObj.get(key);
				this.getMenuItem(object);
			}
		}
		return menuItems;
	}
	
	private String buildMenuItemAccess(boolean isParent,JSONObject obj) {
		StringBuilder menuItem = new StringBuilder();
		Iterator<String> iter = obj.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			if(obj.get(key) instanceof String) {
				menuItem.append(this.getLi(isParent,String.valueOf(obj.get(key))));
			} else if(obj.get(key) instanceof JSONObject) {
				JSONObject object = (JSONObject)obj.get(key);
				menuItem.append(this.getLi(key, object));
			}
		}
		return menuItem.toString();
	}
	
	private String getLi(String value,JSONObject obj) {
		StringBuilder menuItem = new StringBuilder();
		menuItem.append("<li class='parent'>").append(this.getCheckbox(value,"chkbxheader")).append(value);
		menuItem.append("<ul>");
		menuItem.append(this.buildMenuItemAccess(false,obj));
		menuItem.append("</ul>");
		menuItem.append("</li>");
		return menuItem.toString();
	}
	
	private String getCheckbox(String value,String classes) {
		StringBuilder menuItem = new StringBuilder();
		menuItem.append("<input type='checkbox' class='").append(classes).append("' value='").append(value).append("'>");
		return menuItem.toString();
	}
	
	private String getLi(boolean isParent,String value) {
		StringBuilder builder = new StringBuilder();
		String classes = "child";
		String chkboxClass = "chkbxcomp";
		if(isParent) {
			classes = "parent";
			chkboxClass = "chkbxheader";
		}
		builder.append("<li class='").append(classes).append("'>").append(this.getCheckbox(value,chkboxClass)).append(value).append("</li>");
		return builder.toString();
	}
}
