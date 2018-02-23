package com.energieip.api.test;

import com.energieip.api.EnergieAPI;


public class TestCommands {

	public static void main(String[] args) {
		new TestCommands();
	}

	public TestCommands() {

		System.out.println("TEST ENERGIE API");

		EnergieAPI energieAPI = new EnergieAPI();
		
		energieAPI.connect("stef", "stef", 0);

		/*
		 * try { energieAPI.connect(); } catch (UnknownHostException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		// System.out.println("RackID=" + energieAPI.getRackID());

		System.out.println("Watchdog=" + energieAPI.get_Watchdog());

		/*
		 * String[] list = energieAPI.getList();
		 * 
		 * for (int i = 0; i < list.length; i++) { System.out.println(list[i]);
		 * } System.out.println("Total Drivers = " + list.length);
		 */

		/*
		 * String[] list_light = energieAPI.getList_Light_drivers();
		 * 
		 * for (int i = 0; i < list_light.length; i++) {
		 * System.out.println(list_light[i]);
		 * 
		 * }
		 */

		/*
		 * String[] list_shutter = energieAPI.getList_Shutter_drivers();
		 * 
		 * for (int i = 0; i < list_shutter.length; i++) {
		 * System.out.println(list_shutter[i]);
		 * 
		 * }
		 */

		/*
		 String[] list_group = energieAPI.getList_groups();
		 
		 for (int i = 0; i < list_group.length; i++) {
		 System.out.println(list_group[i]);
		 
		}
		*/
		 
		// System.out.println(energieAPI.setGroup(76, 3));
		
		//energieAPI.setShutterUp(105);
		//energieAPI.setShutterDown(105);
		//energieAPI.setShutterStop(105);

		// energieAPI.setGroupLightPercentage(2, 0);

		//energieAPI.setIndividualLightPercentage(16, 0);

		// energieAPI.setShutterDown(406);

		// energieAPI.setShutterStop(406);

		// energieAPI.setShutterUp(406);
	 
		//energieAPI.set_HVAC_auto(1, 0); // group 1,       0 = false
		
		//energieAPI.set_HVAC_output_valve2_0_10V(24, 50);
		
		
		
		

	}

}
