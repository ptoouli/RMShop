package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
 
public class ConfigFileReader {
	
	private static Properties properties;
	private final String propertyFilePath= "Files/config.properties";
 
	//Get Driver Folder Path from properties file
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		return driverPath;
	}
	
	//Get oms products file from properties file
	public String getOMSProducts() {
		String omsProducts = properties.getProperty("omsProducts");
		return omsProducts;
	}
	
	//Get defect screenshot location from properties file
	public String getDefectScreenshot() {
		String omsProducts = properties.getProperty("defectScreenshotPath");
		return omsProducts;
	}
	
	//Get the url for the environment
	public static String getEnvironmentURL(String environment) {
		String envURL = properties.getProperty(environment);
		return envURL;
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