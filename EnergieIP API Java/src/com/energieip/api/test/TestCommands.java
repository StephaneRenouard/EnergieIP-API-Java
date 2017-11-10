package com.energieip.api.test;

import com.energieip.api.EnergieAPI;

public class TestCommands {

	public static void main(String[] args) {
		new TestCommands();
	}
	
	public TestCommands() {
		
		System.out.println("TEST ENERGIE API");
		
		EnergieAPI energieAPI = new EnergieAPI();
		
		System.out.println("RackID=" + energieAPI.getRackID());
	
		System.out.println("Watchdog=" + energieAPI.getWatchdog());
		
		
		 String[] list = energieAPI.getList();
		
		 for (int i = 0; i < list.length; i++) {
			System.out.println( list[i]);
		}
		System.out.println("Total Drivers = " + list.length);
	}
		
		
}
