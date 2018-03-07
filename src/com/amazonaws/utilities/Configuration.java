package com.amazonaws.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	private Configuration() {} // make nobody can instantiate this class
	private static Properties properties;
	
	static { // bc. we do only one time
		try {
			properties = new Properties();
			FileInputStream inputSteam = new FileInputStream("./configuration.properties");
			properties.load(inputSteam);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Method to return properties
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	

}
