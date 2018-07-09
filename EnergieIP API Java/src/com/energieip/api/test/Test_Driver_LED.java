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
		 
		 
		 int SA = 21;
		 
		 //System.out.println(energieAPI.get_LED_percentage(SA));
		 
		 //System.out.println(energieAPI.set_LED_percentage(SA, 70));
		 
		 //System.out.println(energieAPI.set_LED_group_percentage(3, 70));
		 		 		 
		 //System.out.println(energieAPI.get_LED_group_percentage(3));
		 
		 //System.out.println(energieAPI.set_LED_group_percentage(3, 20));
		 
		 System.out.println(energieAPI.get_LED_group_percentage(3));
		
				
	}

}
