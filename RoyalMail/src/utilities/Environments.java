package utilities;

import java.util.Arrays;
import java.util.List;

public class Environments {
	
	public static List<String> setEnvironment(String environment) {
		String rmPage, rmShop;
		
		if (environment.equalsIgnoreCase("prod")) {
			rmPage = "https://www.royalmail.com/";
			rmShop = "https://shop.royalmail.com/";		

		}
		
		else if (environment.equalsIgnoreCase("stg2")) {
			rmPage = "https://www.royalmail.com/";
			rmShop = "https://stgfastmag.royalmail.com/";	

		}
		
		else {
			rmPage = "https://www.royalmail.com/";
			rmShop = "https://stgfastmag.royalmail.com/";

		}
		
		List<String> urls = Arrays.asList(rmPage, rmShop);
		return urls;

	}

}
