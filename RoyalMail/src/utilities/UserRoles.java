package utilities;

import java.util.Arrays;
import java.util.List;

public class UserRoles {
	
	public static List<String> loginDetails(String role) {
		
		String email, password;
		
		//Normal User
		if(role.equalsIgnoreCase("normal")) {
		email = "paul.toouli@outlook.com";
		password = "password1";
		}
		//OMS User
		else if (role.equalsIgnoreCase("oms")) {
		email = "daniel.weisman@royalmail.com";
		password = "thur5day";
		}
		else {
			email = "paul.toouli@outlook.com";
			password = "password1";
		}
		List<String> loginDetails = Arrays.asList(email, password);
		return loginDetails;
		
	}

}
