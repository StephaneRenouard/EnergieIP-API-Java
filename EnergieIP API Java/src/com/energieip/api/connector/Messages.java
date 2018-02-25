package com.energieip.api.connector;

/**
 * The Messages class allow messaging system over TCP from API to Core. 
 * @author stephane@energie-ip.com
 * 
 * This class is used by default by Core.
 *
 */
public class Messages {
	
	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * Utilities
	 */
	// rack
	static final public String get_RackID = "get_RackID";
	static final public String set_RackID = "set_RackID";
	
	// scan
	static final public String scan_WithErase = "scan_WithErase";
	static final public String scan_WithoutErase = "scan_WithoutErase";

	// groups
	static final public String set_driver_group = "set_driver_group";
	static final public String get_driver_group = "get_driver_group";
	
	// ID2 (generic)
	static final public String get_DRIVER_power = "get_DRIVER_power"; // W
	static final public String get_DRIVER_version = "get_DRIVER_version"; // code version
	static final public String get_DRIVER_error = "get_DRIVER_error";
	static final public String get_DRIVER_group = "get_DRIVER_group";
	static final public String get_DRIVER_position_on_switch = "get_DRIVER_position_on_switch";
	static final public String get_DRIVER_position_on_daughterBoard = "get_DRIVER_position_on_daughterBoard";
	static final public String get_DRIVER_position_on_table = "get_DRIVER_position_on_table";
	static final public String get_DRIVER_manufacturing_year = "get_DRIVER_manufacturing_year";
	static final public String get_DRIVER_manufacturing_month = "get_DRIVER_manufacturing_month";
	
	// type
	static final public String get_driver_type = "get_driver_type";
	
	// List
	static final public String get_List = "get_List";
	static final public String get_List_Light_drivers = "get_List_Light_drivers";
	static final public String get_List_Blind_drivers = "get_List_Blind_drivers";
	static final public String get_List_TOR_drivers = "get_List_TOR_drivers";
	static final public String get_List_HVAC_drivers = "get_List_HVAC_drivers";
	static final public String get_List_groups = "get_List_groups";
	@Deprecated
	static final public String get_List_Shutter_drivers = "get_List_Blind_drivers";
	
	
	// Watchdog
	static final public String get_Watchdog = "get_Watchdog";
	static final public String set_Watchdog = "set_Watchdog";
	

	// Data test
	static final public String set_Data_1 = "set_Data_1";
	static final public String set_Data_2 = "set_Data_2";
	
	
	// Connection test
	static final public String test = "test";
	
	
	
	// ------------------------------------------------------------------------------------------------------------------------	
	/*
	 * LIGHT DRIVER
	 */
	// GET from ID11
	static final public String get_LED_Imax = "get_LED_Imax";   // mA
	static final public String get_LED_percentage = "get_LED_percentage"; // %
	static final public String get_LED_start_time = "get_LED_start_time"; // sec
	static final public String get_LED_stop_time = "get_LED_stop_time"; // sec
	static final public String get_LED_lux_corrected = "get_LED_lux_corrected"; // Lux
	static final public String get_LED_lux = "get_LED_lux"; // Lux
	static final public String get_LED_temperature = "get_LED_temperature"; // 1/10°C
	static final public String get_LED_movement = "get_LED_movement"; // sec
	
	// GET from ID2
	static final public String get_LED_power = "get_LED_power"; // W
	static final public String get_LED_version = "get_LED_version"; // code version
	static final public String get_LED_error = "get_LED_error";
	static final public String get_LED_group = "get_LED_group";
	static final public String get_LED_position_on_switch = "get_LED_position_on_switch";
	static final public String get_LED_position_on_daughterBoard = "get_LED_position_on_daughterBoard";
	static final public String get_LED_position_on_table = "get_LED_position_on_table";
	static final public String get_LED_manufacturing_year = "get_LED_manufacturing_year";
	static final public String get_LED_manufacturing_month = "get_LED_manufacturing_month";
		
	// GET from ID100-MODES
	static final public String get_LED_group_auto = "get_LED_group_auto";
	static final public String get_LED_group_application = "get_LED_group_application";
	static final public String get_LED_group_watchdog = "get_LED_group_watchdog";
	
	// GET from ID100-LIGHT
	static final public String get_LED_group_lux_target = "get_LED_group_lux_target";
	static final public String get_LED_group_correction_interval = "get_LED_group_correction_interval";
	static final public String get_LED_group_occupency_time = "get_LED_group_occupency_time";
	static final public String get_LED_group_night_threshold = "get_LED_group_night_threshold";
	static final public String get_LED_group_followMe_previous = "get_LED_group_followMe_previous";
	static final public String get_LED_group_followMe_next = "get_LED_group_followMe_next";
	static final public String get_LED_group_ramping_up = "get_LED_group_ramping_up";
	static final public String get_LED_group_ramping_down = "get_LED_group_ramping_down";
	static final public String get_LED_group_lux_correctionFactor_night = "get_LED_group_lux_correctionFactor_night";
	static final public String get_LED_group_lux_correctionFactor_day = "get_LED_group_lux_correctionFactor_day";
	static final public String get_LED_group_start_Threshold = "get_LED_group_start_Threshold";
		
	// GET from ID100-STATUS
	static final public String get_LED_group_temperature = "get_LED_group_temperature";
	static final public String get_LED_group_temperature_corrected = "get_LED_group_temperature_corrected";
	static final public String get_LED_group_lux = "get_LED_group_lux";
	static final public String get_LED_group_lux_corrected = "get_LED_group_lux_corrected";
	static final public String get_LED_group_occupency_time_505 = "get_LED_group_occupency_time_505";
	static final public String get_LED_group_sensorAdress = "get_LED_group_sensorAdress";
	
	
	// SET from ID11
	static final public String set_LED_Imax = "set_LED_Imax";   // mA
	static final public String set_LED_percentage = "set_LED_percentage"; // %
	static final public String set_LED_start_time = "set_LED_start_time"; // sec
	static final public String set_LED_stop_time = "set_LED_stop_time"; // sec
	
	// SET from ID2
	static final public String set_LED_group = "set_LED_group";
	
	// SET from ID100-MODES
	static final public String set_LED_group_auto = "set_LED_group_auto";
	static final public String set_LED_group_application = "set_LED_group_application";
	static final public String set_LED_group_watchdog = "set_LED_group_watchdog";
	
	// SET from ID100-LIGHT
	static final public String set_LED_group_lux_target = "set_LED_group_lux_target";
	static final public String set_LED_group_correction_interval = "set_LED_group_correction_interval";
	static final public String set_LED_group_occupency_time = "set_LED_group_occupency_time";
	static final public String set_LED_group_night_threshold = "set_LED_group_night_threshold";
	static final public String set_LED_group_followMe_previous = "set_LED_group_followMe_previous";
	static final public String set_LED_group_followMe_next = "set_LED_group_followMe_next";
	static final public String set_LED_group_ramping_up = "set_LED_group_ramping_up";
	static final public String set_LED_group_ramping_down = "set_LED_group_ramping_down";
	static final public String set_LED_group_lux_correctionFactor_night = "set_LED_group_lux_correctionFactor_night";
	static final public String set_LED_group_lux_correctionFactor_day = "set_LED_group_lux_correctionFactor_day";
	static final public String set_LED_group_start_Threshold = "set_LED_group_start_Threshold";

	

	// ------------------------------------------------------------------------------------------------------------------------	
	/*
	 * BLIND DRIVER 
	 */
	
	// GET from ID13
	static final public String get_BLIND_1_state = "get_BLIND_1_state";
	static final public String get_BLIND_2_state = "get_BLIND_2_state";
	static final public String get_BLIND_windowContact = "get_BLIND_windowContact";
	
	// GET from ID2
	static final public String get_BLIND_power = "get_BLIND_power"; // W
	static final public String get_BLIND_version = "get_BLIND_version"; // code version
	static final public String get_BLIND_error = "get_BLIND_error";
	static final public String get_BLIND_group = "get_BLIND_group";
	
	static final public String get_BLIND_position_on_switch = "get_BLIND_position_on_switch";
	static final public String get_BLIND_position_on_daughterBoard = "get_BLIND_position_on_daughterBoard";
	static final public String get_BLIND_position_on_table = "get_BLIND_position_on_table";
	static final public String get_BLIND_manufacturing_year = "get_BLIND_manufacturing_year";
	static final public String get_BLIND_manufacturing_month = "get_BLIND_manufacturing_month";
	
	
	// SET from ID13
	static final public String set_BLIND_1_state = "set_BLIND_1_state";
	static final public String set_BLIND_2_state = "set_BLIND_2_state";
	
	static final public String set_BLIND_1_up = "set_BLIND_1_up";
	static final public String set_BLIND_1_down = "set_BLIND_1_down";
	static final public String set_BLIND_1_stop = "set_BLIND_1_stop";

	static final public String set_BLIND_2_up = "set_BLIND_2_up";
	static final public String set_BLIND_2_down = "set_BLIND_2_down";
	static final public String set_BLIND_2_stop = "set_BLIND_2_stop";
	
	@Deprecated
	static final public String setShutterUp = "setShutterUp";
	@Deprecated
	static final public String setShutterDown = "setShutterDown";
	@Deprecated
	static final public String setShutterStop = "setShutterStop";
	
	
	
	// ------------------------------------------------------------------------------------------------------------------------	
	/*
	 *  HVAC DRIVER
	 */
	
	// GET from ID12
	static final public String  get_HVAC_fan = "get_HVAC_fan";
	static final public String  get_HVAC_output_valve1_PWM = "get_HVAC_output_valve1_PWM";
	static final public String  get_HVAC_output_valve2_PWM = "get_HVAC_output_valve2_PWM";
	static final public String  get_HVAC_output_valve1_0_10V = "get_HVAC_output_valve1_0_10V";
	static final public String  get_HVAC_output_valve2_0_10V = "get_HVAC_output_valve2_0_10V";
	static final public String  get_HVAC_output_relay = "get_HVAC_output_relay";
	static final public String  get_HVAC_input_TOR1 = "get_HVAC_input_TOR1"; // set INT in place of BOOLEAN to get error code 
	static final public String  get_HVAC_input_TOR2 = "get_HVAC_input_TOR2"; // set INT in place of BOOLEAN to get error code
	static final public String  get_HVAC_input_0_10V = "get_HVAC_input_0_10V";
	static final public String  get_HVAC_tachy = "get_HVAC_tachy";
	
	// GET from ID2
	static final public String  get_HVAC_power = "get_HVAC_power";
	static final public String  get_HVAC_version = "get_HVAC_version";
	static final public String  get_HVAC_error = "get_HVAC_error";
	static final public String  get_HVAC_group = "get_HVAC_group";
	
	static final public String  get_HVAC_position_on_switch = "get_HVAC_position_on_switch";
	static final public String  get_HVAC_position_on_daughterBoard = "get_HVAC_position_on_daughterBoard";
	static final public String  get_HVAC_position_on_table = "get_HVAC_position_on_table";
	static final public String  get_HVAC_manufacturing_year = "get_HVAC_manufacturing_year";
	static final public String  get_HVAC_manufacturing_month = "get_HVAC_manufacturing_month";
		
	//GET from ID100-MODES
	static final public String  get_HVAC_group_auto = "get_HVAC_group_auto";
	static final public String  get_HVAC_group_application = "get_HVAC_group_application";
	static final public String  get_HVAC_group_eco = "get_HVAC_group_eco";
	static final public String  get_HVAC_group_air_quality = "get_HVAC_group_air_quality";
	static final public String  get_HVAC_group_fan_mod = "get_HVAC_group_fan_mod";
	static final public String  get_HVAC_group_watchdog = "get_HVAC_group_watchdog";
	static final public String  get_HVAC_group_on = "get_HVAC_group_on";
	
	//GET from ID100-MATERIEL
	static final public String  get_HVAC_group_def_input_Tsensor = "get_HVAC_group_def_input_Tsensor"; // (reg. 201, hardware_inputsensor)
	static final public String  get_HVAC_group_def_temperature_compensation = "get_HVAC_group_def_temperature_compensation";
	static final public String  get_HVAC_group_def_input_tor1 = "get_HVAC_group_def_input_tor1";
	static final public String  get_HVAC_group_def_input_tor2 = "get_HVAC_group_def_input_tor2";
	static final public String  get_HVAC_group_def_input_0_10V = "get_HVAC_group_def_input_0_10V";
	static final public String  get_HVAC_group_def_output_0_10V_1 = "get_HVAC_group_def_output_0_10V_1";
	static final public String  get_HVAC_group_def_output_0_10V_2 = "get_HVAC_group_def_output_0_10V_2";
	static final public String  get_HVAC_group_def_polarity_relay_window_closed = "get_HVAC_group_def_polarity_relay_window_closed";
	static final public String  get_HVAC_group_def_polarity_dew_point = "get_HVAC_group_def_polarity_dew_point";
	static final public String  get_HVAC_group_def_polarity_change_over_heating = "get_HVAC_group_def_polarity_change_over_heating";
		
	// GET ID100-CALIBRATION
	static final public String  get_HVAC_group_calibration_C02_for_10V = "get_HVAC_group_calibration_C02_for_10V";
	static final public String  get_HVAC_group_calibration_C0_for_10V = "get_HVAC_group_calibration_C0_for_10V";
	static final public String  get_HVAC_group_calibration_T_for_10V = "get_HVAC_group_calibration_T_for_10V";
	
	// GET ID100-PARAMETERS
	static final public String  get_HVAC_parameters_temperature_target = "get_HVAC_parameters_temperature_target"; // RW, 100-300, 1/10C, def 220 
	static final public String  get_HVAC_parameters_temperature_offset = "get_HVAC_parameters_temperature_offset"; // RW, -100/+100, %, def 0 
	static final public String  get_HVAC_parameters_temperature_offset_ladder = "get_HVAC_parameters_temperature_offset_ladder"; // RW, 1-10s, C, def 3 
	static final public String  get_HVAC_parameters_temporisation_comfort_mode = "get_HVAC_parameters_temporisation_comfort_mode"; // RW, 0-240, min, def 0
	static final public String  get_HVAC_parameters_temporisation_sleep_mode = "get_HVAC_parameters_temporisation_sleep_mode"; // RW, 0-720, min, def 10
    static final public String  get_HVAC_parameters_temporisation_reduced_mode = "get_HVAC_parameters_temporisation_reduced_mode"; // RW, 0-720, min, def 5
	static final public String  get_HVAC_parameters_deadband_comfort_mode = "get_HVAC_parameters_deadband_comfort_mode"; // RW, 0-20, �C, def 2
	static final public String  get_HVAC_parameters_deadBand_sleep_mode = "get_HVAC_parameters_deadBand_sleep_mode"; // RW, 0-20, �C, def 4
	static final public String  get_HVAC_parameters_deadBand_reduced_mode = "get_HVAC_parameters_deadBand_reduced_mode"; // RW, 0-20, �C, def 6
	
	static final public String  get_HVAC_parameters_proportionalBand_cold = "get_HVAC_parameters_proportionalBand_cold"; // RW, 2-10, C, def 2
	static final public String  get_HVAC_parameters_limit_valve_opening_cold = "get_HVAC_parameters_limit_valve_opening_cold"; // RW, 10-100, %, def 100
	static final public String  get_HVAC_parameters_proportionalBand_hot = "get_HVAC_parameters_proportionalBand_hot"; // RW, 2-10, C, def 2
	static final public String  get_HVAC_parameters_limit_valve_opening_hot = "get_HVAC_parameters_limit_valve_opening_hot"; // RW, 10-100, %, def 100
	static final public String  get_HVAC_parameters_fan_proportionalBand = "get_HVAC_parameters_fan_proportionalBand"; // RW, 2-10, C, def 2
	static final public String  get_HVAC_parameters_fan_speed_min = "get_HVAC_parameters_fan_speed_min"; // RW, 0-100; %, def 0
	static final public String  get_HVAC_parameters_fan_speed_max = "get_HVAC_parameters_fan_speed_max" ;// RW, 0-100; %, def 100
	static final public String  get_HVAC_parameters_measure_integral_slope = "get_HVAC_parameters_measure_integral_slope"; // RW, 0-100, i, def 10
	static final public String  get_HVAC_parameters_measure_slope = "get_HVAC_parameters_measure_slope"; // RW, 1-1000, i, def 100
	static final public String  get_HVAC_parameters_fan_threshold_low = "get_HVAC_parameters_fan_threshold_low"; // RW, 10-50, %, def 20
	static final public String  get_HVAC_parameters_fan_threshold_high = "get_HVAC_parameters_fan_threshold_high"; // RW, 10-50, %, def 80
	static final public String  get_HVAC_parameters_fan_valve_coef = "get_HVAC_parameters_fan_valve_coef"; // RW, 1-10000, %, def 100
	
	static final public String  get_HVAC_parameters_airQuality_target = "get_HVAC_parameters_airQuality_target"; // RW, 0-30000, ppm, def 700
	static final public String  get_HVAC_parameters_airQuality_proportionalBand = "get_HVAC_parameters_airQuality_proportionalBand"; // RW, 0-30000, ppm, def 800
	static final public String  get_HVAC_parameters_VaV_opening_max = "get_HVAC_parameters_VaV_opening_max"; // RW, 0-100, %, def 100
	static final public String  get_HVAC_parameters_VaV_opening_min = "get_HVAC_parameters_VaV_opening_min"; // RW, 0-100, %, def 0
	static final public String  get_HVAC_parameters_6Way_tension_100_cold = "get_HVAC_parameters_6Way_tension_100_cold"; // RW, 0-100, %, def 5
	static final public String  get_HVAC_parameters_6Way_tension_0_cold = "get_HVAC_parameters_6Way_tension_0_cold"; // RW, 0-100, %, def 37
	static final public String  get_HVAC_parameters_6Way_tension_0_hot = "get_HVAC_parameters_6Way_tension_0_hot"; // RW, 0-100, %, def 68
	static final public String  get_HVAC_parameters_6Way_tension_100_hot = "get_HVAC_parameters_6Way_tension_100_hot"; // RW, 0-100, %, def 100
	static final public String  get_HVAC_parameters_dewPoint_tempo = "get_HVAC_parameters_dewPoint_tempo"; // RW, 0-43200, sec, def 300
	
	
	// SET from ID12
	static final public String  set_HVAC_fan = "set_HVAC_fan"; // %
	static final public String  set_HVAC_output_valve1_PWM = "set_HVAC_output_valve1_PWM";// %
	static final public String  set_HVAC_output_valve2_PWM = "set_HVAC_output_valve2_PWM"; // %
	static final public String  set_HVAC_output_valve1_0_10V = "set_HVAC_output_valve1_0_10V"; // %
	static final public String  set_HVAC_output_valve2_0_10V = "set_HVAC_output_valve2_0_10V"; // %
	static final public String  set_HVAC_output_relay = "set_HVAC_output_relay";
			
	//SET from ID100-MODES
	static final public String  set_HVAC_group_auto = "set_HVAC_group_auto";
	static final public String  set_HVAC_group_application = "set_HVAC_group_application";
	static final public String  set_HVAC_group_eco = "set_HVAC_group_eco";
	static final public String  set_HVAC_group_air_quality = "set_HVAC_group_air_quality";
	static final public String  set_HVAC_group_fan_mod = "set_HVAC_group_fan_mod";
	static final public String  set_HVAC_group_watchdog = "set_HVAC_group_watchdog";
	static final public String  set_HVAC_group_on = "set_HVAC_group_on";
		
	//SET from ID100-MATERIEL
	static final public String  set_HVAC_group_def_input_Tsensor = "set_HVAC_group_def_input_Tsensor"; // (reg. 201, hardware_inputsensor)
	static final public String  set_HVAC_group_def_temperature_compensation = "set_HVAC_group_def_temperature_compensation";
	static final public String  set_HVAC_group_def_input_tor1 = "set_HVAC_group_def_input_tor1";
	static final public String  set_HVAC_group_def_input_tor2 = "set_HVAC_group_def_input_tor2";
	static final public String  set_HVAC_group_def_input_0_10V = "set_HVAC_group_def_input_0_10V";
	static final public String  set_HVAC_group_def_output_valve_1 = "set_HVAC_group_def_output_valve_1";
	static final public String  set_HVAC_group_def_output_valve_2 = "set_HVAC_group_def_output_valve_2";
	static final public String  set_HVAC_group_def_output_0_10V_1 = "set_HVAC_group_def_output_0_10V_1";
	static final public String  set_HVAC_group_def_output_0_10V_2 = "set_HVAC_group_def_output_0_10V_2";
	static final public String  set_HVAC_group_def_polarity_relay_window_closed = "set_HVAC_group_def_polarity_relay_window_closed";
	static final public String  set_HVAC_group_def_polarity_dew_point = "set_HVAC_group_def_polarity_dew_point";
	static final public String  set_HVAC_group_def_polarity_change_over_heating = "set_HVAC_group_def_polarity_change_over_heating";
			
	// SET ID100-CALIBRATION
	static final public String  set_HVAC_group_calibration_C02_for_10V = "set_HVAC_group_calibration_C02_for_10V";
	static final public String  set_HVAC_group_calibration_C0_for_10V = "set_HVAC_group_calibration_C0_for_10V";
	static final public String  set_HVAC_group_calibration_T_for_10V = "set_HVAC_group_calibration_T_for_10V";
		
	// SET ID100-PARAMETERS
	static final public String  set_HVAC_parameters_temperature_target = "set_HVAC_parameters_temperature_target"; // RW, 100-300, 1/10C, def 220 
	static final public String  set_HVAC_parameters_temperature_offset = "set_HVAC_parameters_temperature_offset"; // RW, -100/+100, %, def 0 
	static final public String  set_HVAC_parameters_temperature_offset_ladder = "set_HVAC_parameters_temperature_offset_ladder"; // RW, 1-10s, C, def 3 
	static final public String  set_HVAC_parameters_temporisation_comfort_mode = "set_HVAC_parameters_temporisation_comfort_mode"; // RW, 0-240, min, def 0
	static final public String  set_HVAC_parameters_temporisation_sleep_mode = "set_HVAC_parameters_temporisation_sleep_mode"; // RW, 0-720, min, def 10
    static final public String  set_HVAC_parameters_temporisation_reduced_mode = "set_HVAC_parameters_temporisation_reduced_mode"; // RW, 0-720, min, def 5
	static final public String  set_HVAC_parameters_deadband_comfort_mode = "set_HVAC_parameters_deadband_comfort_mode"; // RW, 0-20, �C, def 2
	static final public String  set_HVAC_parameters_deadBand_sleep_mode = "set_HVAC_parameters_deadBand_sleep_mode"; // RW, 0-20, �C, def 4
	static final public String  set_HVAC_parameters_deadBand_reduced_mode = "set_HVAC_parameters_deadBand_reduced_mode"; // RW, 0-20, �C, def 6
	static final public String  set_HVAC_parameters_proportionalBand_cold = "set_HVAC_parameters_proportionalBand_cold"; // RW, 2-10, C, def 2
	static final public String  set_HVAC_parameters_limit_valve_opening_cold = "set_HVAC_parameters_limit_valve_opening_cold"; // RW, 10-100, %, def 100
	static final public String  set_HVAC_parameters_proportionalBand_hot = "set_HVAC_parameters_proportionalBand_hot"; // RW, 2-10, C, def 2
	static final public String  set_HVAC_parameters_limit_valve_opening_hot = "set_HVAC_parameters_limit_valve_opening_hot"; // RW, 10-100, %, def 100
	static final public String  set_HVAC_parameters_fan_proportionalBand = "set_HVAC_parameters_fan_proportionalBand"; // RW, 2-10, C, def 2
	static final public String  set_HVAC_parameters_fan_speed_min = "set_HVAC_parameters_fan_speed_min"; // RW, 0-100; %, def 0
	static final public String  set_HVAC_parameters_fan_speed_max = "set_HVAC_parameters_fan_speed_max"; // RW, 0-100; %, def 100
	static final public String  set_HVAC_parameters_measure_integral_slope = "set_HVAC_parameters_measure_integral_slope"; // RW, 0-100, i, def 10
	static final public String  set_HVAC_parameters_measure_slope = "set_HVAC_parameters_measure_slope"; // RW, 1-1000, i, def 100
	static final public String  set_HVAC_parameters_fan_threshold_low = "set_HVAC_parameters_fan_threshold_low"; // RW, 10-50, %, def 20
	static final public String  set_HVAC_parameters_fan_threshold_high = "set_HVAC_parameters_fan_threshold_high"; // RW, 10-50, %, def 80
	static final public String  set_HVAC_parameters_fan_valve_coef = "set_HVAC_parameters_fan_valve_coef"; // RW, 1-10000, %, def 100
	static final public String  set_HVAC_parameters_airQuality_target = "set_HVAC_parameters_airQuality_target"; // RW, 0-30000, ppm, def 700
	static final public String  set_HVAC_parameters_airQuality_proportionalBand = "set_HVAC_parameters_airQuality_proportionalBand"; // RW, 0-30000, ppm, def 800
	static final public String  set_HVAC_parameters_VaV_opening_max = "set_HVAC_parameters_VaV_opening_max"; // RW, 0-100, %, def 100
	static final public String  set_HVAC_parameters_VaV_opening_min = "set_HVAC_parameters_VaV_opening_min"; // RW, 0-100, %, def 0
	static final public String  set_HVAC_parameters_6Way_tension_100_cold = "set_HVAC_parameters_6Way_tension_100_cold"; // RW, 0-100, %, def 5
	static final public String  set_HVAC_parameters_6Way_tension_0_cold = "set_HVAC_parameters_6Way_tension_0_cold"; // RW, 0-100, %, def 37
	static final public String  set_HVAC_parameters_6Way_tension_0_hot = "set_HVAC_parameters_6Way_tension_0_hot"; // RW, 0-100, %, def 68
	static final public String  set_HVAC_parameters_6Way_tension_100_hot = "set_HVAC_parameters_6Way_tension_100_hot"; // RW, 0-100, %, def 100
	static final public String  set_HVAC_parameters_dewPoint_tempo = "set_HVAC_parameters_dewPoint_tempo"; // RW, 0-43200, sec, def 300
	
	
	// ID100 other (Deprecated)
	@Deprecated
	static final public String set_HVAC_temp_target = "set_HVAC_temp_target";
	@Deprecated
	static final public String set_HVAC_auto = "set_HVAC_auto";
	
	
		
	// ------------------------------------------------------------------------------------------------------------------------	
	
	
	/*
	 *  I/O DRIVER
	 */
	
	// GET from ID14
	static final public String get_IO_input_1 = "get_IO_input_1";
	static final public String get_IO_input_2 = "get_IO_input_2";
	static final public String get_IO_input_3 = "get_IO_input_3";
	static final public String get_IO_input_4 = "get_IO_input_4";
	static final public String get_IO_input_5 = "get_IO_input_5";
	static final public String get_IO_input_6 = "get_IO_input_6";
	static final public String get_IO_input_7 = "get_IO_input_7";
	static final public String get_IO_input_8 = "get_IO_input_8";
	static final public String get_IO_input_all = "get_IO_input_all";
	
	static final public String get_IO_output_1 = "get_IO_output_1";
	static final public String get_IO_output_2 = "get_IO_output_2";
	static final public String get_IO_output_3 = "get_IO_output_3";
	static final public String get_IO_output_4 = "get_IO_output_4";
	static final public String get_IO_output_all = "get_IO_output_all";
	
	// GET from ID2
	static final public String get_IO_power = "get_IO_power";
	static final public String get_IO_version = "get_IO_version";
	static final public String get_IO_error = "get_IO_error";
	static final public String get_IO_group = "get_IO_group";
	
	static final public String get_IO_position_on_switch = "get_IO_position_on_switch";
	static final public String get_IO_position_on_daughterBoard = "get_IO_position_on_daughterBoard";
	static final public String get_IO_position_on_table = "get_IO_position_on_table";
	static final public String get_IO_manufacturing_year = "get_IO_manufacturing_year";
	static final public String get_IO_manufacturing_month = "get_IO_manufacturing_month";
	
	
	// SET from ID14
	static final public String set_IO_output_1 = "set_IO_output_1";
	static final public String set_IO_output_2 = "set_IO_output_2";
	static final public String set_IO_output_3 = "set_IO_output_3";
	static final public String set_IO_output_4 = "set_IO_output_4";
	static final public String set_IO_output_all = "set_IO_output_all";
	
	
			
	
}
