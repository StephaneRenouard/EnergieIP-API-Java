package com.energieip.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class gets propoerties from .properties files
 * 
 * @author stephane
 *
 */
public class PropertiesManager {

	public static void getProperties() {

		Properties properties = new Properties();
		FileInputStream input;

		try {
			input = new FileInputStream("resources/config.properties");
			properties.load(input);
			input.close();
			Parameters.CORE_IP = properties.getProperty("CORE_IP");
			Parameters.CORE_PORT = Integer.parseInt(properties.getProperty("CORE_PORT"));

		} catch (FileNotFoundException e) {
			System.err.println(("[PropertiesManager] FnF error - Properties file not found"));
			System.exit(0);
		} catch (IOException e) {
			System.err.println(("[PropertiesManager] IO error - Properties file not found"));
			System.exit(0);
		}

	}// end getProperties

} // end of class
