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
	
	
	
	
}