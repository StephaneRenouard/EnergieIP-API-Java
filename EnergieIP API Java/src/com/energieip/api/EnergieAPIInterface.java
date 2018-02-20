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
	int get_rackID();
	boolean set_rackID();
	
	// scan
	boolean scan_withErase();
	boolean scan_withoutErase();

	// groups
	boolean set_group(int SA, int target_group);
	int get_group(int SA);
	
	// ID2 (generic)
	int get_DRIVER_power(int SA); // W
	int get_DRIVER_version(int SA); // code version
	int get_DRIVER_error(int SA);
	int get_DRIVER_group(int SA);
	int get_DRIVER_position_on_switch(int SA);
	int get_DRIVER_position_on_daughterBoard(int SA);
	int get_DRIVER_position_on_table(int SA);
	int get_DRIVER_manufacturing_year(int SA);
	int get_DRIVER_manufacturing_month(int SA);
	
	// type
	int get_DRIVER_type(int SA);

	
	/*
	 * List
	 */
	String[] get_list();
	String[] get_list_light_drivers();
	String[] get_list_blind_drivers();
	String[] get_list_TOR_drivers();
	String[] get_list_HVAC_drivers();
	String[] get_list_groups();
	@Deprecated
	String[] get_list_shutter_drivers();

	
	/*
	 * watchdog
	 */
	int get_Watchdog();
	boolean set_Watchdog(int watchdog);

	
	/*
	 * LIGHT DRIVER
	 */
	// GET from ID11
	int get_LED_Imax(int SA);   // mA
	int get_LED_percentage(int SA); // %
	int get_LED_start_time(int SA); // sec
	int get_LED_stop_time(int SA); // sec
	int get_LED_lux_corrected(int SA); // Lux
	int get_LED_lux(int SA); // Lux
	int get_LED_temperature(int SA); // 1/10°C
	int get_LED_movement(int SA); // sec
	
	// GET from ID2
	int get_LED_power(int SA); // W
	int get_LED_version(int SA); // code version
	int get_LED_error(int SA);
	int get_LED_group(int SA);
	int get_LED_position_on_switch(int SA);
	int get_LED_position_on_daughterBoard(int SA);
	int get_LED_position_on_table(int SA);
	int get_LED_manufacturing_year(int SA);
	int get_LED_manufacturing_month(int SA);
		
	// GET from ID100-MODES
	int get_LED_group_auto(int group);
	int get_LED_group_application(int group);
	int get_LED_group_watchdog(int group);
	
	// GET from ID100-LIGHT
	int get_LED_group_lux_target(int group);
	int get_LED_group_correction_interval(int group);
	int get_LED_group_occupency_time(int group);
	int get_LED_group_night_threshold(int group);
	int get_LED_group_followMe_previous(int group);
	int get_LED_group_followMe_next(int group);
	int get_LED_group_ramping_up(int group);
	int get_LED_group_ramping_down(int group);
	int get_LED_group_lux_correctionFactor_night(int group);
	int get_LED_group_lux_correctionFactor_day(int group);
	int get_LED_group_start_Threshold(int group);
		
	// GET from ID100-STATUS
	int get_LED_group_temperature();
	int get_LED_group_temperature_corrected();
	int get_LED_group_lux();
	int get_LED_group_lux_corrected();
	int get_LED_group_occupency_time_505(int group);
	int get_LED_group_sensorAdress(int group);
	
	
	// SET from ID11
	boolean set_LED_Imax(int SA);   // mA
	boolean set_LED_percentage(int SA); // %
	boolean set_LED_start_time(int SA); // sec
	boolean set_LED_stop_time(int SA); // sec
	
	// SET from ID2
	boolean set_LED_group(int SA, int group);
	
	@Deprecated
	boolean setGroupLightPercentage(int group, int percentage);
	@Deprecated
	boolean setIndividualLightPercentage(int SA, int percentage);
	
	// SET from ID100-MODES
	boolean set_LED_group_auto(int group);
	boolean set_LED_group_application(int group);
	boolean set_LED_group_watchdog(int group);
	
	// SET from ID100-LIGHT
	boolean set_LED_group_lux_target(int group);
	boolean set_LED_group_correction_interval(int group);
	boolean set_LED_group_occupency_time(int group);
	boolean set_LED_group_night_threshold(int group);
	boolean set_LED_group_followMe_previous(int group);
	boolean set_LED_group_followMe_next(int group);
	boolean set_LED_group_ramping_up(int group);
	boolean set_LED_group_ramping_down(int group);
	boolean set_LED_group_lux_correctionFactor_night(int group);
	boolean set_LED_group_lux_correctionFactor_day(int group);
	boolean set_LED_group_start_Threshold(int group);

	
	
	/*
	 * BLIND DRIVER 
	 */
	
	// GET from ID13
	int get_BLIND_1_state(int SA);
	int get_BLIND_2_state(int SA);
	int get_BLIND_windowContact(int SA);
	
	// GET from ID2
	int get_BLIND_power(int SA); // W
	int get_BLIND_version(int SA); // code version
	int get_BLIND_error(int SA);
	int get_BLIND_group(int SA);
	int get_BLIND_position_on_switch(int SA);
	int get_BLIND_position_on_daughterBoard(int SA);
	int get_BLIND_position_on_table(int SA);
	int get_BLIND_manufacturing_year(int SA);
	int get_BLIND_manufacturing_month(int SA);
	
	
	// SET from ID13
	boolean set_BLIND_1_state(int SA, int state);
	boolean set_BLIND_2_state(int SA, int state);
	
	boolean set_BLIND_1_up(int SA);
	boolean set_BLIND_1_down(int SA);
	boolean set_BLIND_1_stop(int SA);

	boolean set_BLIND_2_up(int SA);
	boolean set_BLIND_2_down(int SA);
	boolean set_BLIND_2_stop(int SA);
	
	@Deprecated
	boolean setShutterUp(int SA);
	@Deprecated
	boolean setShutterDown(int SA);
	@Deprecated
	boolean setShutterStop(int SA);
	
	
	
	/*
	 *  HVAC DRIVER
	 */
	// from ID12
	int get_HVAC_fan(int SA);
	int get_HVAC_input_0_10V(int SA);
	int get_HVAC_input_TOR1(int SA); // set INT in place of BOOLEAN to get error code 
	int get_HVAC_input_TOR2(int SA); // set INT in place of BOOLEAN to get error code
	int get_HVAC_output_valve1_0_10V(int SA);
	int get_HVAC_output_valve2_0_10V(int SA);
	int get_HVAC_output_valve1_PWM(int SA);
	int get_HVAC_output_valve2_PWM(int SA);
	int get_HVAC_tachy(int SA);
	
	// from ID2
	int get_HVAC_power(int SA);
	int get_HVAC_version(int SA);
	int get_HVAC_error(int SA);
	int get_HVAC_group(int SA);
	
	// from ID100
	int get_HVAC_group_auto(int group);
	int get_HVAC_group_application(int group);
	int get_HVAC_group_eco(int group);
	int get_HVAC_group_air_quality(int group);
	int get_HVAC_group_fan_mod(int group);
	//int get
	
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