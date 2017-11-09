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
		
		
	}

}
