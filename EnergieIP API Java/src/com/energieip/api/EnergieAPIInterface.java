package com.energieip.api;



public interface EnergieAPIInterface {

	/* 
	 * Utilities
	 */
	
	int getRackID();

	
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
	//utilities
	boolean setGroup(int SA, int target_group);
	
	// light
	boolean setGroupLightPercentage(int group, int percentage);
	
	boolean setIndividualLightPercentage(int SA, int percentage);
	
	// shutter
	boolean setShutterUp(int SA);
	
	boolean setShuterDown(int SA);
	
	boolean setShutterStop(int SA);
	
}