package com.energieip.api;

public interface EnergieAPIInterface {

	/*
	 * TCP parameters
	 */
	
	void setTCPserver_IP(String tcpServer_IP);

	void setTCPserver_PORT(int tcpServer_PORT);

	/*
	 * Utilities
	 */

	int getRackID();

	boolean scan_WithErase();

	boolean scan_WithoutErase();

	/*
	 * List
	 */

	String[] getList();

	String[] getList_Light_drivers();

	String[] getList_Shutter_drivers();

	String[] getList_TOR_drivers();

	String[] getList_HVAC_drivers();

	String[] getList_groups();

	/*
	 * watchdog
	 */
	int getWatchdog();

	/*
	 * Set
	 */

	// watchdog
	boolean setWatchdog(int watchdog);

	// utilities
	boolean setGroup(int SA, int target_group);

	// light
	boolean setGroupLightPercentage(int group, int percentage);

	boolean setIndividualLightPercentage(int SA, int percentage);

	// shutter
	boolean setShutterUp(int SA);

	boolean setShutterDown(int SA);

	boolean setShutterStop(int SA);
	

}