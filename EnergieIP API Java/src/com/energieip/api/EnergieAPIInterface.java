package com.energieip.api;

public interface EnergieAPIInterface {

	/*
	 * TCP parameters
	 */
	
	void set_TCPserver_IP(String tcpServer_IP);
	void set_TCPserver_PORT(int tcpServer_PORT);

	
	/*
	 * Utilities
	 */
	
	// rack
	int get_RackID();
	boolean set_RackID();
	
	// scan
	boolean scan_WithErase();
	boolean scan_WithoutErase();

	// groups
	boolean set_Group(int SA, int target_group);
	int get_Group(int SA);

	
	/*
	 * List
	 */
	String[] get_List();
	String[] get_List_Light_drivers();
	String[] get_List_Shutter_drivers();
	String[] get_List_TOR_drivers();
	String[] get_List_HVAC_drivers();
	String[] get_List_groups();

	
	/*
	 * watchdog
	 */
	int get_Watchdog();
	boolean set_Watchdog(int watchdog);

	
	/*
	 * LIGHT DRIVER
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
	
	int get_LED_group_auto(int group);
	
	
	//boolean set_LED_Imax(int SA);   // mA
	boolean set_LED_percentage(int SA); // %
	boolean set_LED_start_time(int SA); // sec
	boolean set_LED_stop_time(int SA); // sec
	
	int set_LED_power(int SA); // W
	int set_LED_version(int SA); // code version
	int set_LED_error(int SA);
	int set_LED_group(int SA);
	
	@Deprecated
	boolean setGroupLightPercentage(int group, int percentage);
	@Deprecated
	boolean setIndividualLightPercentage(int SA, int percentage);
	
	
	/*
	 * BLINDS DRIVER
	 */
	boolean set_blind_1_up(int SA);
	boolean set_blind_1_down(int SA);
	boolean set_blind1_stop(int SA);

	boolean set_blind2_up(int SA);
	boolean set_blind_2_down(int SA);
	boolean set_blind_2_stop(int SA);
	
	
	@Deprecated
	boolean setShutterUp(int SA);
	@Deprecated
	boolean setShutterDown(int SA);
	@Deprecated
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
	boolean set_data1(int data1);
	boolean set_data2(int data2);
	
	@Deprecated
	boolean setData1(int data1);
	@Deprecated
	boolean setData2(int data2);
	

}