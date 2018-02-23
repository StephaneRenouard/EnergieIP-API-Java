package com.energieip.api.test;

import com.energieip.api.EnergieAPI;

public class Test_Driver_LED {

	public static void main(String[] args) {
		
		new Test_Driver_LED();

	}
	
	/**
	 * Default constructor
	 */
	public Test_Driver_LED() {
		
		EnergieAPI energieAPI = new EnergieAPI();
		energieAPI.connect("stef", "stef");
		
		String[] list_light = energieAPI.get_list_light_drivers();
	 
		 for (int i = 0; i < list_light.length; i++) {
			 System.out.println(list_light[i]);
		 }
		 
		 System.out.println(energieAPI.get_LED_percentage(12));
		 
		// System.out.println(energieAPI.set_LED_per
		 
		
				
	}

}
