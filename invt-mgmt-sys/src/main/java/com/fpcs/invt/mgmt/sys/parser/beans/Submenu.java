package com.fpcs.invt.mgmt.sys.parser.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.fpcs.invt.mgmt.sys.constants.ParserConstants.*;;

@XmlRootElement(name = SUBMENU)
public class Submenu {

	@XmlElement(name = MENU)
	private List<Menu> menues;
	
	@XmlElement(name = UL)
	private Ul ul;
	
	@XmlElement(name = LI)
	private Li li;
	
	@XmlElement(name = SPAN)
	private Span span;
	
	@XmlElement(name = I)
	private List<I> ies;
	
	@XmlElement(name = A)
	private Anchor anchor;
	
	@XmlAttribute(name = NAME)
	private String name;
	
	public List<Menu> getMenues() {
		return menues;
	}
	
	public Ul getUl() {
		return ul;
	}

	public List<I> getIes() {
		return ies;
	}

	public Li getLi() {
		return li;
	}

	public Span getSpan() {
		return span;
	}

	public Anchor getAnchor() {
		return anchor;
	}
	
	public String getName() {
		return name;
	}
	
}
