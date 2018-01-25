package com.sag.fin.wealthmgmt.util;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class jsonHelper {
	
	public static String objtojson(Object data){
	        try {
	           ObjectMapper mapper = new ObjectMapper();
	            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	        } catch (IOException e){
	        	e.printStackTrace(System.out);
	        	throw new RuntimeException("IOException from a StringWriter?");
	        }
	}

}
