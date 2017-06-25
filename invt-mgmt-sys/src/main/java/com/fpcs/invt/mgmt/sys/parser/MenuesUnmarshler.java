package com.fpcs.invt.mgmt.sys.parser;
/**
 * @author Manoj Patel
 */
import javax.xml.bind.JAXBException;

import com.fpcs.invt.mgmt.sys.parser.beans.Menues;

@FunctionalInterface
public interface MenuesUnmarshler {

	Menues unmarshallMenues() throws JAXBException;
	
}
