package com.energieip.api;

import java.util.List;

public interface EnergieAPIInterface {

	/* 
	 * Utilities
	 */
	
	int getRackID();

	
	
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