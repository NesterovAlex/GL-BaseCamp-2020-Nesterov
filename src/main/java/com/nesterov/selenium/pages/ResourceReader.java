package com.nesterov.selenium.pages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceReader {

	public static Properties readFile(String fileName) {
		Properties prop = new Properties();
		InputStream inputStream = ResourceReader.class.getClassLoader().getResourceAsStream(fileName);
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
