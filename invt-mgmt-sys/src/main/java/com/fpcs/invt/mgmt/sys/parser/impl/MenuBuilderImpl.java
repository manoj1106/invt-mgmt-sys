package com.fpcs.invt.mgmt.sys.parser.impl;

import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fpcs.invt.mgmt.sys.enums.ERROR_CODE;
import com.fpcs.invt.mgmt.sys.parser.MenuBuilder;
import com.fpcs.invt.mgmt.sys.parser.MenuesUnmarshler;
import com.fpcs.invt.mgmt.sys.parser.beans.Anchor;
import com.fpcs.invt.mgmt.sys.parser.beans.I;
import com.fpcs.invt.mgmt.sys.parser.beans.Li;
import com.fpcs.invt.mgmt.sys.parser.beans.Menu;
import com.fpcs.invt.mgmt.sys.parser.beans.Menues;
import com.fpcs.invt.mgmt.sys.parser.beans.Span;
import com.fpcs.invt.mgmt.sys.parser.beans.Submenu;
import com.fpcs.invt.mgmt.sys.parser.beans.Ul;
import com.fpcs.invt.mgmt.sys.utils.InvtMgmtUtil;
import com.fpcs.invt.mgmt.sys.utils.exception.InvtMgmtSysException;
import com.fpcs.invt.mgmt.sys.constants.ParserConstants;

@Component
public class MenuBuilderImpl implements MenuBuilder {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuBuilderImpl.class);
	
	@Autowired
	private MenuesUnmarshler menuesUnmarshler;
	
	private Set<String> allowedMenues;
	
	@Override
	public String getMenues(Set<String> allowedMenues) {
		try {
			Menues menues = menuesUnmarshler.unmarshallMenues();
			this.allowedMenues = allowedMenues;
			return buildMenu(menues);
		} catch (JAXBException jaxbException) {
			logger.error("error occured while forming menu.",jaxbException);
			throw new InvtMgmtSysException(ERROR_CODE.JAXB_EXCEPTION.getErrorCode(), jaxbException);
		}
	}
	
	private String buildMenu(Menues menues) {
		StringBuilder builder = new StringBuilder();
		if(this.hasMenu(menues)) {
			builder.append(this.getUlStartTag(menues.getUl()));
			builder.append(this.getMenues(menues.getMenues()));
			builder.append(this.getUlEndTag());
		}
		return builder.toString();
	}
	
	private String getUlStartTag(Ul ul) {
		return this.getStartTag(ParserConstants.UL, ul);
	}
	
	private String getUlEndTag() {
		return this.getEndTag(ParserConstants.UL);
	}
	
	private String getMenues(List<Menu> menues) {
		StringBuilder menuBuilder = new StringBuilder();
		for(Menu menu : menues) {
			menuBuilder.append(this.getMenu(menu));
		}
		return menuBuilder.toString();
	}
	
	private String getMenu(Menu menu) {
		StringBuilder menuBuilder = new StringBuilder();
		if(this.isMenuAccessible(menu)) {
			if(this.hasSubmenu(menu)) {
				menuBuilder.append(this.getSubMenu(menu.getSubmenu()));
			} else {
				menuBuilder.append(this.getMenuTag(menu));
			}
		}
		return menuBuilder.toString();
	}
	
	private String getMenuTag(Menu menu) {
		StringBuilder menuBuilder = new StringBuilder();
		menuBuilder.append(this.getLiStartTag(menu.getLi())).append(this.getAnchorStartTag(menu.getAnchor()))
		.append(this.getIStartTag(menu.getI())).append(this.getIEndTag())
		.append(this.getSpanStartTag(menu.getSpan())).append(this.getSpanEndTag())
		.append(this.getAnchorEndTag()).append(this.getLiEndTag());
		return menuBuilder.toString();
	}

	private String getSubMenu(Submenu submenu) {
		StringBuilder submenuBuilder = new StringBuilder();
		submenuBuilder.append(this.getLiStartTag(submenu.getLi()));
		submenuBuilder.append(this.getAnchorStartTag(submenu.getAnchor()));
		for(I i : submenu.getIes()) {
			submenuBuilder.append(this.getIStartTag(i));
			submenuBuilder.append(this.getIEndTag());
			if(i.getPlace().compareTo(1) == 0) {
				submenuBuilder.append(this.getSpanStartTag(submenu.getSpan()));
				submenuBuilder.append(this.getSpanEndTag());
			}
		}
		submenuBuilder.append(this.getAnchorEndTag());
		submenuBuilder.append(this.getUlStartTag(submenu.getUl()));
		if(this.hasMenu(submenu)) {
			submenuBuilder.append(this.getMenues(submenu.getMenues()));
		}
		submenuBuilder.append(this.getUlEndTag());
		submenuBuilder.append(this.getLiEndTag());
		return submenuBuilder.toString();
	}
	
	private String getLiStartTag(Li li) {
		return this.getStartTag(ParserConstants.LI, li);
	}
	
	private String getLiEndTag() {
		return this.getEndTag(ParserConstants.LI);
	}
	
	private String getAnchorStartTag(Anchor a) {
		return this.getStartTag(ParserConstants.A,a);
	}
	
	private String getAnchorEndTag() {
		return this.getEndTag(ParserConstants.A);
	}
	
	private String getIStartTag(I i) {
		return this.getStartTag(ParserConstants.I,i);
	}
	
	private String getIEndTag() {
		return this.getEndTag(ParserConstants.I);
	}
	
	private String getSpanStartTag(Span span) {
		return this.getStartTag(ParserConstants.SPAN,span);
	}
	
	private String getSpanEndTag() {
		return this.getEndTag(ParserConstants.SPAN);
	}
	
	private String getStartTag(String tagName,Object tag) {
		StringBuilder startTag = new StringBuilder();
		startTag.append(ParserConstants.TAG_START).append(tagName);
		this.getTagSpecificContent(startTag, tag);
		startTag.append(ParserConstants.LINE_BREAK);
		return startTag.toString();
	}
	
	private String getEndTag(String tagName) {
		StringBuilder tag = new StringBuilder();
		tag.append(ParserConstants.TAG_START).append(ParserConstants.SLASH).append(tagName).append(ParserConstants.TAG_END)
		.append(ParserConstants.LINE_BREAK);
		return tag.toString();
	}
	
	private void getTagSpecificContent(StringBuilder startTag,Object tag) {

		if(tag instanceof Span) {
			Span span = (Span)tag;
			startTag.append(ParserConstants.TAG_END).append(span.getName());
		} else {
			if(tag instanceof Anchor) {
				Anchor a = (Anchor)tag;
				this.getClasses(a.getClasses(), startTag);
				if(InvtMgmtUtil.isNotBlank(a.getHref())) {
					startTag.append(ParserConstants.SPACE).append(ParserConstants.HREF).append(ParserConstants.EQUAL)
					.append(ParserConstants.SINGLE_QUOTE).append(a.getHref()).append(ParserConstants.SINGLE_QUOTE);
				}
				if(InvtMgmtUtil.isNotBlank(a.getDataHref())) {
					startTag.append(ParserConstants.SPACE).append(ParserConstants.DATA_HREF).append(ParserConstants.EQUAL)
					.append(ParserConstants.SINGLE_QUOTE).append(a.getDataHref()).append(ParserConstants.SINGLE_QUOTE);
				}
				if(InvtMgmtUtil.isNotBlank(a.getDataRef())) {
					startTag.append(ParserConstants.SPACE).append(ParserConstants.DATA_REF).append(ParserConstants.EQUAL)
					.append(ParserConstants.SINGLE_QUOTE).append(a.getDataRef()).append(ParserConstants.SINGLE_QUOTE);
				}
			} else if(tag instanceof I) {
				I i = (I)tag;
				this.getClasses(i.getClasses(), startTag);
			} else if(tag instanceof Ul) {
				Ul ul = (Ul)tag;
				this.getClasses(ul.getClasses(), startTag);
			} else if(tag instanceof Li) {
				Li li = (Li)tag;
				this.getClasses(li.getClasses(), startTag);
			}
			startTag.append(ParserConstants.TAG_END);
		}
		
	}
	
	private void getClasses(String classes,StringBuilder startTag) {
		if(InvtMgmtUtil.isNotBlank(classes)) {
			startTag.append(ParserConstants.SPACE).append(ParserConstants.CLASS).append(ParserConstants.EQUAL)
			.append(ParserConstants.SINGLE_QUOTE).append(classes).append(ParserConstants.SINGLE_QUOTE);;
		}
	}
	
	private boolean hasMenu(Object menu) {
		if(null != menu) {
			if(menu instanceof Menues) {
				Menues menues = (Menues)menu;
				if(null != menues.getMenues() && !menues.getMenues().isEmpty()) {
					return true;
				}
			} else if(menu instanceof Submenu) {
				Submenu submenu = (Submenu)menu;
				if(null != submenu.getMenues() && !submenu.getMenues().isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean hasSubmenu(Menu menu) {
		if(null != menu && null != menu.getSubmenu()) {
			return true;
		}
		return false;
	}
	
	private boolean isMenuAccessible(Menu menu) {
		if(allowedMenues.contains(menu.getName())) {
			return true;
		}
		return false;
	}
}
