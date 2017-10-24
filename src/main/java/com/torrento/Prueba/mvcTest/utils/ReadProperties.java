package com.torrento.Prueba.mvcTest.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadProperties {
	private final static Logger logger = LoggerFactory.getLogger(ReadProperties.class);

	public static Properties readProperties() {
		Properties prop = new Properties();
		try {
			logger.debug("Load properties...");
			prop.load(ReadProperties.class.getResourceAsStream("/config.properties"));
			logger.debug("Properties Loaded.");
		} catch (FileNotFoundException e) {
			logger.debug("Error, The File Do not Exist.");
		} catch (IOException e) {
			logger.debug("Error di I/O");
		}
		return prop;
	}
}
