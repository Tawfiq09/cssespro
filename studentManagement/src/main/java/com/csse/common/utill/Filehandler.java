package com.csse.common.utill;

import java.io.IOException;
import java.util.Properties;

public class Filehandler {
	
	public static Properties loadPropertiesFromFile(String filePath) throws IOException{
		Properties props = new Properties();
		props.load(ApplicationConfig.class.getClassLoader().getResourceAsStream(filePath));
		return props;
	}
}
