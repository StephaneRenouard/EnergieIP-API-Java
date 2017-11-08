package com.energieip.api;

import java.util.List;

public interface EnergieAPIInterface {

	boolean connect(String IP, int port);

	boolean connect(String IP);

	boolean connect();

	boolean disconnect();

	void getRackID();

	/*
	 * List
	 */
	
	List getList();
	
	List getList_Light_drivers();
	
	List getList_Shutter_drivers();
	
	List getList_TOR_drivers();
	
	List getList_HVAC_drivers();
	
	List getList_groups();
	/*
	 * watchdog 
	 */
	int getWatchdog();
	
	
	
	
}