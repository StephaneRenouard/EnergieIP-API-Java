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
		
		energieAPI.connect("stef", "stef");
		
		System.out.println(energieAPI.get_connectionStatus());
		
		
	}

}
