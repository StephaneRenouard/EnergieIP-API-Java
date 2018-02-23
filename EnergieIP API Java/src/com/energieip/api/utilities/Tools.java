package com.energieip.api.utilities;

public class Tools {
	
	/**
	 * String to boolean 
	 * @param string
	 * @return boolean
	 */
	public static boolean String2Boolean(String string){
		
		Boolean result = false;
		string = string.trim();
		
		if(string.contains("true")){
			result = true;
		}else if(string.contains("false")) {
			result = false;
		}else{
			System.err.println("[TOOLS - String2Boolean] content is: " + string);
			System.err.println("[TOOLS - String2Boolean] bad syntax");
		}
		
		return result;
		
	}
	
	/**
	 * String to int 
	 * @param string
	 * @return int
	 */
	public static int String2int(String string){
		
		
		int result = -1;
		string = string.trim();
		
		try{
			result = Integer.parseInt(string);
		}catch(Exception e){
			System.err.println("[TOOLS - String2int] content is: " + string);
			System.err.println("[TOOLS - String2int] bad syntax");
		}
		
		return result;
		
	}


}
