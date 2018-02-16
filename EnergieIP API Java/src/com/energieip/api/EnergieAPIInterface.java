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
	
	// rack
	int getRackID();
	boolean set_RackID();

	// scan
	boolean scan_WithErase();
	boolean scan_WithoutErase();

	// groups
	boolean setGroup(int SA, int target_group);

	
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
	boolean setWatchdog(int watchdog);

	

	/*
	 * LIGHT DRIVER
	 */
	boolean setGroupLightPercentage(int group, int percentage);
	boolean setIndividualLightPercentage(int SA, int percentage);

	
	/*
	 * BLINDS DRIVER
	 */
	boolean setShutterUp(int SA);
	boolean setShutterDown(int SA);
	boolean setShutterStop(int SA);
	
	
	
	
	/*
	 *  HVAC DRIVER
	 */
	int get_HVAC_input_0_10V(int SA);
	int get_HVAC_input_TOR1(int SA); // set INT in place of BOOLEAN to get error code 
	int get_HVAC_input_TOR2(int SA); // set INT in place of BOOLEAN to get error code
		
	boolean set_HVAC_output_valve1_0_10V(int SA, int value);
	boolean set_HVAC_output_valve2_0_10V(int SA, int value);
	boolean set_HVAC_output_valve1_PWM(int SA, int value);
	boolean set_HVAC_output_valve2_PWM(int SA, int value);
			
	boolean set_HVAC_temp_target(int group, int value);
	
	boolean set_HVAC_auto(int group, int value);
	
	
	/*
	 * development tools
	 */
	boolean setData1(int data1);
	boolean setData2(int data2);
	

}