package com.energieip.api.test;

import com.energieip.api.EnergieAPI;

public class Test_Connection {

	public static void main(String[] args) {
		
		new Test_Connection();

	}
	
	/**
	 * default constructor
	 */
	public Test_Connection() {
		
		EnergieAPI energieAPI = new EnergieAPI();
		
		energieAPI.connect("test", "test");
		
		boolean status = energieAPI.get_connectionStatus();
		
		System.out.println("Connection status is " + status);
		
		status = energieAPI.get_testConnection();
		
		System.out.println("testConnection is " + status);
		
		
	}

}
