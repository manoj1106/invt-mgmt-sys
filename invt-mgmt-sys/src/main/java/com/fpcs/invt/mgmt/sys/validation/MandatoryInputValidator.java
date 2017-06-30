package com.fpcs.invt.mgmt.sys.validation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MandatoryInputValidator {

	public boolean validateAllMandatoryFields(String[] mandatFields , Field[] fields , Object inputVO) {
		List<String> mandatFieldList = Arrays.asList(mandatFields);
		try {
			for (Field field : fields) {
				String fieldName = field.getName();
				field.setAccessible(true);
				if(mandatFieldList.contains(fieldName) && null == field.get(inputVO)) {
					return false;
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return true;
	}	
}
