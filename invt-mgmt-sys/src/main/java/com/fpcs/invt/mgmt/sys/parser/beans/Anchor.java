package com.fpcs.invt.mgmt.sys.parser.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import static com.fpcs.invt.mgmt.sys.constants.ParserConstants.*;

@XmlRootElement(name=A)
public class Anchor {

	@XmlAttribute(name = NAME)
	private String name;
	
	@XmlAttribute(name = CLASSES)
	private String classes;
	
	@XmlAttribute(name = ID)
	private String id;
	
	@XmlAttribute(name = HREF)
	private String href;
	
	@XmlAttribute(name = DATA_HREF)
	private String dataHref;
	
	@XmlAttribute(name = DATA_REF)
	private String dataRef;

	public String getName() {
		return name;
	}

	public String getClasses() {
		return classes;
	}

	public String getId() {
		return id;
	}

	public String getHref() {
		return href;
	}

	public String getDataHref() {
		return dataHref;
	}

	public String getDataRef() {
		return dataRef;
	}
	
}
