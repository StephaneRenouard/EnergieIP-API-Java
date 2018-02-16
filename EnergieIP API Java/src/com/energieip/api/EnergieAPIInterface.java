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
	/*	
	 
	public int imax; // R, Imax mA according to driver (0-65535)
	public int percentage; // RW, % of power applied to appliance (0-100)
	public int time_to_start; // RW, second, (0-100)
	public int time_to_stop; // RW, second, (0-100)
	public int lux_corrected; // R, lux, (0-65535)
	public int lux; // R, lux, (0-65535)
	public int temperature; // R, deg C, (0-1200)
	public int movement; // R, s, no movment from this time =0 means movement
							// (0-60000)
	// from ID2
	public int power; // R, power in W (O-100)
	public int version; // R, (0-255)
	public int error; // R, error/sec (0-100)
	public int group; // RW, (1-99)
	*/
	int get_LED_Imax(int SA);   // mA
	int get_LED_percentage(int SA); // %
	int get_LED_start_time(int SA); // sec
	int get_LED_stop_time(int SA); // sec
	int get_LED_lux_corrected(int SA); // Lux
	int get_LED_lux(int SA); // Lux
	int get_LED_temperature(int SA); // 1/10°C
	int get_LED_movement(int SA); // sec
	
	int get_LED_power(int SA); // W
	int get_LED_version(int SA); // code version
	int get_LED_error(int SA);
	int get_LED_group(int SA);
	
	//boolean set_LED_Imax(int SA);   // mA
	boolean set_LED_percentage(int SA); // %
	boolean set_LED_start_time(int SA); // sec
	boolean set_LED_stop_time(int SA); // sec
	
	int set_LED_power(int SA); // W
	int set_LED_version(int SA); // code version
	int set_LED_error(int SA);
	int set_LED_group(int SA);
	
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