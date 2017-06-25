package com.fpcs.invt.mgmt.sys.parser.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.fpcs.invt.mgmt.sys.constants.ParserConstants.*;;

@XmlRootElement(name = MENUES)
public class Menues {

	@XmlElement(name = UL)
	private Ul ul;
	
	@XmlElement(name = MENU)
	public List<Menu> menues;

	public List<Menu> getMenues() {
		return menues;
	}
	
	public Ul getUl() {
		return ul;
	}
	
}
