package com.fpcs.invt.mgmt.sys.parser.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import static com.fpcs.invt.mgmt.sys.constants.ParserConstants.*;;
@XmlRootElement(name = LI)
public class Li {

	@XmlAttribute(name = NAME)
	private String name;
	
	@XmlAttribute(name = CLASSES)
	private String classes;
	
	@XmlAttribute(name =ID)
	private String id;

	public String getName() {
		return name;
	}

	public String getClasses() {
		return classes;
	}

	public String getId() {
		return id;
	}
	
}
