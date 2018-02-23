package com.energieip.api.interfaces;



public interface EnergieAPIInterface {
	
	/*
	 * Utilities
	 */
	// rack
	int get_rackID();
	boolean set_rackID(int value);
	
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
	int get_LED_group_temperature(int group);
	int get_LED_group_temperature_corrected(int group);
	int get_LED_group_lux(int group);
	int get_LED_group_lux_corrected(int group);
	int get_LED_group_occupency_time_505(int group);
	int get_LED_group_sensorAdress(int group);
	
	
	// SET from ID11
	boolean set_LED_Imax(int SA, int value);   // mA
	boolean set_LED_percentage(int SA, int percentage); // %
	boolean set_LED_start_time(int SA, int value); // sec
	boolean set_LED_stop_time(int SA, int value); // sec
	
	// SET from ID2
	boolean set_LED_group(int SA, int group);
	
	@Deprecated
	boolean setGroupLightPercentage(int group, int percentage);
	@Deprecated
	boolean setIndividualLightPercentage(int SA, int percentage);
	
	// SET from ID100-MODES
	boolean set_LED_group_auto(int group, int value);
	boolean set_LED_group_application(int group, int value);
	boolean set_LED_group_watchdog(int group, int value);
	
	// SET from ID100-LIGHT
	boolean set_LED_group_lux_target(int group, int value);
	boolean set_LED_group_correction_interval(int group, int value);
	boolean set_LED_group_occupency_time(int group, int value);
	boolean set_LED_group_night_threshold(int group, int value);
	boolean set_LED_group_followMe_previous(int group, int value);
	boolean set_LED_group_followMe_next(int group, int value);
	boolean set_LED_group_ramping_up(int group, int value);
	boolean set_LED_group_ramping_down(int group, int value);
	boolean set_LED_group_lux_correctionFactor_night(int group, int value);
	boolean set_LED_group_lux_correctionFactor_day(int group, int value);
	boolean set_LED_group_start_Threshold(int group, int value);

	
	
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
	
	// GET from ID12
	int get_HVAC_fan(int SA);
	int get_HVAC_output_valve1_PWM(int SA);
	int get_HVAC_output_valve2_PWM(int SA);
	int get_HVAC_output_valve1_0_10V(int SA);
	int get_HVAC_output_valve2_0_10V(int SA);
	int get_HVAC_output_relay(int SA);
	int get_HVAC_input_TOR1(int SA); // set INT in place of BOOLEAN to get error code 
	int get_HVAC_input_TOR2(int SA); // set INT in place of BOOLEAN to get error code
	int get_HVAC_input_0_10V(int SA);
	int get_HVAC_tachy(int SA);
	
	// GET from ID2
	int get_HVAC_power(int SA);
	int get_HVAC_version(int SA);
	int get_HVAC_error(int SA);
	int get_HVAC_group(int SA);
	
	int get_HVAC_position_on_switch(int SA);
	int get_HVAC_position_on_daughterBoard(int SA);
	int get_HVAC_position_on_table(int SA);
	int get_HVAC_manufacturing_year(int SA);
	int get_HVAC_manufacturing_month(int SA);
		
	//GET from ID100-MODES
	int get_HVAC_group_auto(int group);
	int get_HVAC_group_application(int group);
	int get_HVAC_group_eco(int group);
	int get_HVAC_group_air_quality(int group);
	int get_HVAC_group_fan_mod(int group);
	int get_HVAC_group_watchdog(int group);
	int get_HVAC_group_on(int group);
	
	//GET from ID100-MATERIEL
	int get_HVAC_group_def_input_Tsensor(int group); // (reg. 201, hardware_inputsensor)
	int get_HVAC_group_def_temperature_compensation(int group);
	int get_HVAC_group_def_input_tor1(int group);
	int get_HVAC_group_def_input_tor2(int group);
	int get_HVAC_group_def_input_0_10V(int group);
	int get_HVAC_group_def_output_0_10V_1(int group);
	int get_HVAC_group_def_output_0_10V_2(int group);
	int get_HVAC_group_def_polarity_relay_window_closed(int group);
	int get_HVAC_group_def_polarity_dew_point(int group);
	int get_HVAC_group_def_polarity_change_over_heating(int group);
		
	// GET ID100-CALIBRATION
	int get_HVAC_group_calibration_C02_for_10V(int group);
	int get_HVAC_group_calibration_C0_for_10V(int group);
	int get_HVAC_group_calibration_T_for_10V(int group);
	
	// GET ID100-PARAMETERS
	int get_HVAC_parameters_temperature_target(int group); // RW, 100-300, 1/10C, def 220 
	int get_HVAC_parameters_temperature_offset(int group); // RW, -100/+100, %, def 0 
	int get_HVAC_parameters_temperature_offset_ladder(int group); // RW, 1-10s, C, def 3 
	int get_HVAC_parameters_temporisation_comfort_mode(int group); // RW, 0-240, min, def 0
	int get_HVAC_parameters_temporisation_sleep_mode(int group); // RW, 0-720, min, def 10
    int get_HVAC_parameters_temporisation_reduced_mode(int group); // RW, 0-720, min, def 5
	int get_HVAC_parameters_deadband_comfort_mode(int group); // RW, 0-20, �C, def 2
	int get_HVAC_parameters_deadBand_sleep_mode(int group); // RW, 0-20, �C, def 4
	int get_HVAC_parameters_deadBand_reduced_mode(int group); // RW, 0-20, �C, def 6
	int get_HVAC_parameters_proportionalBand_cold(int group); // RW, 2-10, C, def 2
	int get_HVAC_parameters_limit_valve_opening_cold(int group); // RW, 10-100, %, def 100
	int get_HVAC_parameters_proportionalBand_hot(int group); // RW, 2-10, C, def 2
	int get_HVAC_parameters_limit_valve_opening_hot(int group); // RW, 10-100, %, def 100
	int get_HVAC_parameters_fan_proportionalBand(int group); // RW, 2-10, C, def 2
	int get_HVAC_parameters_fan_speed_min(int group); // RW, 0-100; %, def 0
	int get_HVAC_parameters_fan_speed_max(int group); // RW, 0-100; %, def 100
	int get_HVAC_parameters_measure_integral_slope(int group); // RW, 0-100, i, def 10
	int get_HVAC_parameters_measure_slope(int group); // RW, 1-1000, i, def 100
	int get_HVAC_parameters_fan_threshold_low(int group); // RW, 10-50, %, def 20
	int get_HVAC_parameters_fan_threshold_high(int group); // RW, 10-50, %, def 80
	int get_HVAC_parameters_fan_valve_coef(int group); // RW, 1-10000, %, def 100
	int get_HVAC_parameters_airQuality_target(int group); // RW, 0-30000, ppm, def 700
	int get_HVAC_parameters_airQuality_proportionalBand(int group); // RW, 0-30000, ppm, def 800
	int get_HVAC_parameters_VaV_opening_max(int group); // RW, 0-100, %, def 100
	int get_HVAC_parameters_VaV_opening_min(int group); // RW, 0-100, %, def 0
	int get_HVAC_parameters_6Way_tension_100_cold(int group); // RW, 0-100, %, def 5
	int get_HVAC_parameters_6Way_tension_0_cold(int group); // RW, 0-100, %, def 37
	int get_HVAC_parameters_6Way_tension_0_hot(int group); // RW, 0-100, %, def 68
	int get_HVAC_parameters_6Way_tension_100_hot(int group); // RW, 0-100, %, def 100
	int get_HVAC_parameters_dewPoint_tempo(int group); // RW, 0-43200, sec, def 300
	
	
	// SET from ID12
	boolean set_HVAC_fan(int SA, int percentage); // %
	boolean set_HVAC_output_valve1_PWM(int SA, int percentage); // %
	boolean set_HVAC_output_valve2_PWM(int SA, int percentage); // %
	boolean set_HVAC_output_valve1_0_10V(int SA, int percentage); // %
	boolean set_HVAC_output_valve2_0_10V(int SA, int percentage); // %
	boolean set_HVAC_output_relay(int SA, boolean value);
			
	//SET from ID100-MODES
	boolean set_HVAC_group_auto(int group, boolean value);
	boolean set_HVAC_group_application(int group, int value);
	boolean set_HVAC_group_eco(int group, boolean value);
	boolean set_HVAC_group_air_quality(int group, int value);
	boolean set_HVAC_group_fan_mod(int group, int value);
	boolean set_HVAC_group_watchdog(int group, int value);
	boolean set_HVAC_group_on(int group, boolean value);
		
	//SET from ID100-MATERIEL
	boolean set_HVAC_group_def_input_Tsensor(int group, int value); // (reg. 201, hardware_inputsensor)
	boolean set_HVAC_group_def_temperature_compensation(int group, int value);
	boolean set_HVAC_group_def_input_tor1(int group, int value);
	boolean set_HVAC_group_def_input_tor2(int group, int value);
	boolean set_HVAC_group_def_input_0_10V(int group, int value);
	boolean set_HVAC_group_def_output_0_10V_1(int group, int value);
	boolean set_HVAC_group_def_output_0_10V_2(int group, int value);
	boolean set_HVAC_group_def_polarity_relay_window_closed(int group, boolean value);
	boolean set_HVAC_group_def_polarity_dew_point(int group, boolean value);
	boolean set_HVAC_group_def_polarity_change_over_heating(int group, boolean value);
			
	// SET ID100-CALIBRATION
	boolean set_HVAC_group_calibration_C02_for_10V(int group, int value);
	boolean set_HVAC_group_calibration_C0_for_10V(int group, int value);
	boolean set_HVAC_group_calibration_T_for_10V(int group, int value);
		
	// SET ID100-PARAMETERS
	boolean set_HVAC_parameters_temperature_target(int group, int value); // RW, 100-300, 1/10C, def 220 
	boolean set_HVAC_parameters_temperature_offset(int group, int value); // RW, -100/+100, %, def 0 
	boolean set_HVAC_parameters_temperature_offset_ladder(int group, int value); // RW, 1-10s, C, def 3 
	boolean set_HVAC_parameters_temporisation_comfort_mode(int group, int value); // RW, 0-240, min, def 0
	boolean set_HVAC_parameters_temporisation_sleep_mode(int group, int value); // RW, 0-720, min, def 10
    boolean set_HVAC_parameters_temporisation_reduced_mode(int group, int value); // RW, 0-720, min, def 5
	boolean set_HVAC_parameters_deadband_comfort_mode(int group, int value); // RW, 0-20, �C, def 2
	boolean set_HVAC_parameters_deadBand_sleep_mode(int group, int value); // RW, 0-20, �C, def 4
	boolean set_HVAC_parameters_deadBand_reduced_mode(int group, int value); // RW, 0-20, �C, def 6
	boolean set_HVAC_parameters_proportionalBand_cold(int group, int value); // RW, 2-10, C, def 2
	boolean set_HVAC_parameters_limit_valve_opening_cold(int group, int value); // RW, 10-100, %, def 100
	boolean set_HVAC_parameters_proportionalBand_hot(int group, int value); // RW, 2-10, C, def 2
	boolean set_HVAC_parameters_limit_valve_opening_hot(int group, int value); // RW, 10-100, %, def 100
	boolean set_HVAC_parameters_fan_proportionalBand(int group, int value); // RW, 2-10, C, def 2
	boolean set_HVAC_parameters_fan_speed_min(int group, int value); // RW, 0-100; %, def 0
	boolean set_HVAC_parameters_fan_speed_max(int group, int value); // RW, 0-100; %, def 100
	boolean set_HVAC_parameters_measure_integral_slope(int group, int value); // RW, 0-100, i, def 10
	boolean set_HVAC_parameters_measure_slope(int group, int value); // RW, 1-1000, i, def 100
	boolean set_HVAC_parameters_fan_threshold_low(int group, int value); // RW, 10-50, %, def 20
	boolean set_HVAC_parameters_fan_threshold_high(int group, int value); // RW, 10-50, %, def 80
	boolean set_HVAC_parameters_fan_valve_coef(int group, int value); // RW, 1-10000, %, def 100
	boolean set_HVAC_parameters_airQuality_target(int group, int value); // RW, 0-30000, ppm, def 700
	boolean set_HVAC_parameters_airQuality_proportionalBand(int group, int value); // RW, 0-30000, ppm, def 800
	boolean set_HVAC_parameters_VaV_opening_max(int group, int value); // RW, 0-100, %, def 100
	boolean set_HVAC_parameters_VaV_opening_min(int group, int value); // RW, 0-100, %, def 0
	boolean set_HVAC_parameters_6Way_tension_100_cold(int group, int value); // RW, 0-100, %, def 5
	boolean set_HVAC_parameters_6Way_tension_0_cold(int group, int value); // RW, 0-100, %, def 37
	boolean set_HVAC_parameters_6Way_tension_0_hot(int group, int value); // RW, 0-100, %, def 68
	boolean set_HVAC_parameters_6Way_tension_100_hot(int group, int value); // RW, 0-100, %, def 100
	boolean set_HVAC_parameters_dewPoint_tempo(int group, int value); // RW, 0-43200, sec, def 300
	
	
	// ID100 other
	@Deprecated
	boolean set_HVAC_temp_target(int group, int value);
	
	@Deprecated
	boolean set_HVAC_auto(int group, int value);
	
	
	/*
	 *  IO DRIVER
	 */
	
	// GET from ID14
	int get_IO_input_1(int SA);
	int get_IO_input_2(int SA);
	int get_IO_input_3(int SA);
	int get_IO_input_4(int SA);
	short get_IO_input_all(int SA);
	
	int get_IO_output_1(int SA);
	int get_IO_output_2(int SA);
	int get_IO_output_3(int SA);
	int get_IO_output_4(int SA);
	int get_IO_output_5(int SA);
	int get_IO_output_6(int SA);
	int get_IO_output_7(int SA);
	int get_IO_output_8(int SA);
	short get_IO_output_all(int SA);
	
	// GET from ID2
	int get_IO_power(int SA);
	int get_IO_version(int SA);
	int get_IO_error(int SA);
	int get_IO_group(int SA);
	
	int get_IO_position_on_switch(int SA);
	int get_IO_position_on_daughterBoard(int SA);
	int get_IO_position_on_table(int SA);
	int get_IO_manufacturing_year(int SA);
	int get_IO_manufacturing_month(int SA);
	
	
	// SET from ID14
	boolean set_IO_output_1(int SA, boolean value);
	boolean set_IO_output_2(int SA, boolean value);
	boolean set_IO_output_3(int SA, boolean value);
	boolean set_IO_output_4(int SA, boolean value);
	boolean set_IO_output_5(int SA, boolean value);
	boolean set_IO_output_6(int SA, boolean value);
	boolean set_IO_output_7(int SA, boolean value);
	boolean set_IO_output_8(int SA, boolean value);
	boolean set_IO_output_all(int SA, short value);
	
	
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