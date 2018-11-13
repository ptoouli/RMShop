package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
 
public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "Files/config.properties";
 
	//Get Driver Folder Path from properties file
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		return driverPath;
	}
	
	//Get oms products file from properties fiel
	public String getOMSProducts() {
		String omsProducts = properties.getProperty("omsProducts");
		return omsProducts;
	}
	
	
	//Constructor
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
}