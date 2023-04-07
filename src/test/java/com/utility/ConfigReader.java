package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties propertiesObject() throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\UI-API-Framework\\config-framework\\server.properties");
		Properties read = new Properties();
		read.load(file);
		return read;
	}
	
//	public static String getUrl() throws IOException
//	{
//		return ConfigReader.propertiesObject().getProperty("ENVIRONMENT_DEV_URL");
//	}

}
