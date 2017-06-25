package com.fpcs.invt.mgmt.sys.utils;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class FileReaderWriter {

	private FileReaderWriter() {
		
	}
	
	public static InputStream getInputStream(String fileName) {
		return FileReaderWriter.class.getClassLoader()
                .getResourceAsStream(fileName);
	}
	
	public static InputStream getInputStream(File file) {
		try {
			return FileUtils.openInputStream(file);
		} catch(IOException e) {
			
		}
		return null;
	}
	
	
	public static File getFileFromURL(URL queriesURL) {
	    File file = null;
	    try {
	        file = new File(queriesURL.toURI());
	    } catch (URISyntaxException e) {
	        file = new File(queriesURL.getPath());
	    }
	    return file;
	}
	
}
