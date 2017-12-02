package com.energieip.api.test;

import com.energieip.api.EnergieAPI;

public class TestCommands {

	public static void main(String[] args) {
		new TestCommands();
	}

	public TestCommands() {

		System.out.println("TEST ENERGIE API");

		EnergieAPI energieAPI = new EnergieAPI();

		/*
		 * try { energieAPI.connect(); } catch (UnknownHostException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		// System.out.println("RackID=" + energieAPI.getRackID());

		System.out.println("Watchdog=" + energieAPI.getWatchdog());

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
		 * String[] list_group = energieAPI.getList_groups();
		 * 
		 * for (int i = 0; i < list_group.length; i++) {
		 * System.out.println(list_group[i]);
		 * 
		 * }
		 */

		// System.out.println(energieAPI.setGroup(406, 10));

		energieAPI.setGroupLightPercentage(5, 100);

		// energieAPI.setIndividualLightPercentage(56, 011);

		// energieAPI.setShutterDown(406);

		// energieAPI.setShutterStop(406);

		// energieAPI.setShutterUp(406);

	}

}
