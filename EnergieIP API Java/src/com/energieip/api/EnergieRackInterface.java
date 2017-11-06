package com.energieip.api;

public interface EnergieRackInterface {

	boolean connect(String IP, int port);

	boolean connect(String IP);

	boolean connect();

	boolean disconnect();

	void getRackID();

	void getList();
	
	void getTemperature();

}