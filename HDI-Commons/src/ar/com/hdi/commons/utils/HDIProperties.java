package ar.com.hdi.commons.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HDIProperties {
	private static Properties properties;
	public static String getPropiedad(String archivo, String key) {
		try {
			properties = new Properties();
			properties.load(new FileInputStream("/commons/config/properties/" + archivo));
			return properties.get(key).toString();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
