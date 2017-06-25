package com.fpcs.invt.mgmt.sys.parser.impl;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fpcs.invt.mgmt.sys.parser.MenuesUnmarshler;
import com.fpcs.invt.mgmt.sys.parser.beans.Menues;
import com.fpcs.invt.mgmt.sys.utils.FileReaderWriter;
import com.fpcs.invt.mgmt.sys.constants.ParserConstants;

@Component
public class MenuesUnmarshlerImpl implements MenuesUnmarshler {

	private static final Logger logger = LoggerFactory.getLogger(MenuesUnmarshlerImpl.class);
	
	@Override
	public Menues unmarshallMenues() throws JAXBException {
		logger.debug("unmarshallMenues() start building menues"); 
		InputStream in = FileReaderWriter.getInputStream(ParserConstants.MENUES_FILE);
		JAXBContext jaxbContext = JAXBContext.newInstance(Menues.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		return (Menues)unmarshaller.unmarshal(in);
	}
	
}
