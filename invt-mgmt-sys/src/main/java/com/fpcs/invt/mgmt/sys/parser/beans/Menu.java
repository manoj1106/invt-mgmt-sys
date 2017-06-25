package com.fpcs.invt.mgmt.sys.parser.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.fpcs.invt.mgmt.sys.constants.ParserConstants.*;;

@XmlRootElement(name = MENU)
public class Menu {

	@XmlElement(name = SUBMENU)
	private Submenu submenu;
	
	@XmlElement(name = LI)
	private Li li;
	
	@XmlElement(name = SPAN)
	private Span span;
	
	@XmlElement(name = I)
	private I i;
	
	@XmlElement(name = A)
	private Anchor anchor;
	
	@XmlAttribute(name = NAME)
	private String name;

	public Submenu getSubmenu() {
		return submenu;
	}
	
	public Li getLi() {
		return li;
	}

	public Span getSpan() {
		return span;
	}

	public I getI() {
		return i;
	}

	public Anchor getAnchor() {
		return anchor;
	}
	
	public String getName() {
		return name;
	}
	
}
