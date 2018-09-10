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
		
		System.out.println("Starting test session");
		
		EnergieAPI energieAPI = new EnergieAPI();
		energieAPI.connect("test", "test");
		
		String[] list_light = energieAPI.get_list_light_drivers();
	 
		 for (int i = 0; i < list_light.length; i++) {
			 System.out.println(list_light[i]);
		 }
		 
		 
		 int SA = 7;
		 int GROUP = 1;
		 
		 System.out.println(energieAPI.get_LED_percentage(SA));
		 
		 //System.out.println(energieAPI.set_LED_percentage(SA, 0));
		 
		 //System.out.println(energieAPI.set_LED_group_percentage(GROUP, 30));
		 		 		 
		 //System.out.println(energieAPI.get_LED_group_percentage(3));
		 
		 //System.out.println(energieAPI.set_LED_group_percentage(3, 20));
		 
		 //System.out.println(energieAPI.get_LED_group_percentage(3));
		
		 /*
		int[] array = new int[2];
		array[0] = 12;
		array[1] = 13;
		System.out.println(energieAPI.set_LED_groups_percentage(array, 10));
		 */
				
	}

}
