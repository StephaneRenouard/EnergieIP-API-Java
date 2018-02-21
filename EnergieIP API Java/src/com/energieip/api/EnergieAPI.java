package com.energieip.api;

import com.energieip.api.connector.CoreConnector;
import com.energieip.api.connector.Messages;
import com.energieip.api.interfaces.EnergieAPIInterface;
import com.energieip.api.interfaces.EnergieCOMInterface;

/**
 * ENERGIEIP JAVA API 
 * @author stephane@energie-ip.com
 *
 * this class implements the EnergieAPIInterface definition.
 *
 */
public class EnergieAPI implements EnergieAPIInterface, EnergieCOMInterface {
	
	
	private CoreConnector connector;
	
	/**
	 * default constructor
	 */
	public EnergieAPI() {
		// define a new connector
		connector = new CoreConnector();
	}
	
	
	/**
	 * Return List from String (utilities)
	 * 
	 * @param return_list
	 * @return String[]
	 */
	private String[] makeList(String return_list) {

		String[] myList = return_list.split(";");

		return myList;
	}

	// ------------------------------------------------------------------------------------------------------------------------
	
	/* COM Interface
	 * (non-Javadoc)
	 * @see com.energieip.api.EnergieCOMInterface#set_TCPserver_IP(java.lang.String)
	 */
	@Override
	public void set_TCPserver_IP(String tcpServer_IP) {
		
		Parameters.CORE_IP = tcpServer_IP;
		
	}

	/* COM Interface
	 * (non-Javadoc)
	 * @see com.energieip.api.EnergieCOMInterface#set_TCPserver_PORT(int)
	 */
	@Override
	public void set_TCPserver_PORT(int tcpServer_PORT) {
		
		Parameters.CORE_PORT = tcpServer_PORT;
		
	}

	// ------------------------------------------------------------------------------------------------------------------------
	
	/* EnergieAPI Interface
	 * (non-Javadoc)
	 * @see com.energieip.api.EnergieAPIInterface#get_rackID()
	 */
	@Override
	public int get_rackID() {
		
		int return_rack_id = -1;

		try {
			return_rack_id = Integer.parseInt(connector.sendMessage(Messages.get_RackID));
		} catch (Exception e) {
			return_rack_id = -1;
		}

		return return_rack_id;
	}

	@Override
	public boolean set_rackID() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.energieip.api.interfaces.EnergieAPIInterface#scan_withErase()
	 */
	@Override
	public boolean scan_withErase() {
		
		boolean return_value = false;

		try {

			String result = connector.sendMessage(Messages.scan_WithErase);

			switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
			}
		} catch (Exception e) {
			// nothing to do
		}

		return return_value;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.energieip.api.interfaces.EnergieAPIInterface#scan_withoutErase()
	 */
	@Override
	public boolean scan_withoutErase() {
		
		boolean return_value = false;

		try {

			String result = connector.sendMessage(Messages.scan_WithoutErase);

			switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
			}
		} catch (Exception e) {
			// nothing to do
		}

		return return_value;
	}

	@Override
	public boolean set_group(int SA, int target_group) {
		
		boolean return_value = false;

		try {
			String result = connector.sendMessage(Messages.set_driver_group + " " + SA + " " + target_group);

			switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
			}
		} catch (Exception e) {
			// nothing to do
		}

		return return_value;
	}
	

	@Override
	public int get_group(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_DRIVER_power(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_DRIVER_version(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_DRIVER_error(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_DRIVER_group(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_DRIVER_position_on_switch(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_DRIVER_position_on_daughterBoard(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_DRIVER_position_on_table(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_DRIVER_manufacturing_year(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_DRIVER_manufacturing_month(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_DRIVER_type(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] get_list() {
		
		String return_list = "";

		try {
			return_list = connector.sendMessage(Messages.get_List);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] get_list_light_drivers() {
		
		String return_list = "";

		try {
			return_list = connector.sendMessage(Messages.get_List_Light_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] get_list_blind_drivers() {
		
		String return_list = "";

		try {
			return_list = connector.sendMessage(Messages.get_List_Blind_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] get_list_TOR_drivers() {
		
		String return_list = "";

		try {
			return_list = connector.sendMessage(Messages.get_List_TOR_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] get_list_HVAC_drivers() {
		
		String return_list = "";

		try {
			return_list = connector.sendMessage(Messages.get_List_HVAC_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] get_list_groups() {
		
		String return_list = "";

		try {
			return_list = connector.sendMessage(Messages.get_List_groups);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);

	}

	@Override
	public String[] get_list_shutter_drivers() {
		
		String return_list = "";

		try {
			return_list = connector.sendMessage(Messages.get_List_Shutter_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public int get_Watchdog() {
		int return_watchdog = -1;

		try {
			return_watchdog = Integer.parseInt(connector.sendMessage(Messages.get_Watchdog));
		} catch (Exception e) {
			return_watchdog = -1;
		}

		return return_watchdog;

	}

	@Override
	public boolean set_Watchdog(int watchdog) {
		
		boolean return_value = false;

		try {

			String result = connector.sendMessage(Messages.set_Watchdog + " " + watchdog);

			switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
			}
		} catch (Exception e) {
			// nothing to do
		}

		return return_value;
	}

	@Override
	public int get_LED_Imax(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_percentage(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_start_time(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_stop_time(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_lux_corrected(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_lux(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_temperature(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_movement(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_power(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_version(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_error(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_position_on_switch(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_position_on_daughterBoard(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_position_on_table(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_manufacturing_year(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_manufacturing_month(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_auto(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_application(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_watchdog(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_lux_target(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_correction_interval(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_occupency_time(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_night_threshold(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_followMe_previous(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_followMe_next(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_ramping_up(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_ramping_down(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_lux_correctionFactor_night(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_lux_correctionFactor_day(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_start_Threshold(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_temperature() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_temperature_corrected() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_lux() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_lux_corrected() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_occupency_time_505(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_LED_group_sensorAdress(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean set_LED_Imax(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_percentage(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_start_time(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_stop_time(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group(int SA, int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setGroupLightPercentage(int group, int percentage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setIndividualLightPercentage(int SA, int percentage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_auto(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_application(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_watchdog(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_lux_target(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_correction_interval(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_occupency_time(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_night_threshold(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_followMe_previous(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_followMe_next(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_ramping_up(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_ramping_down(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_lux_correctionFactor_night(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_lux_correctionFactor_day(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_LED_group_start_Threshold(int group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int get_BLIND_1_state(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_BLIND_2_state(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_BLIND_windowContact(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_BLIND_power(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_BLIND_version(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_BLIND_error(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_BLIND_group(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_BLIND_position_on_switch(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_BLIND_position_on_daughterBoard(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_BLIND_position_on_table(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_BLIND_manufacturing_year(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_BLIND_manufacturing_month(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean set_BLIND_1_state(int SA, int state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_BLIND_2_state(int SA, int state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_BLIND_1_up(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_BLIND_1_down(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_BLIND_1_stop(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_BLIND_2_up(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_BLIND_2_down(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_BLIND_2_stop(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Deprecated
	@Override
	public boolean setShutterUp(int SA) {
		boolean return_value = false;

		try {
			String result = connector.sendMessage(Messages.setShutterUp + " " + SA);

			switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
			}
		} catch (Exception e) {
			// nothing to do
		}

		return return_value;
	}

	@Deprecated
	@Override
	public boolean setShutterDown(int SA) {
		
		boolean return_value = false;

		try {

			String result = connector.sendMessage(Messages.setShutterDown + " " + SA);

			switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
			}
		} catch (Exception e) {
			// nothing to do
		}

		return return_value;
	}

	@Deprecated
	@Override
	public boolean setShutterStop(int SA) {
		
		boolean return_value = false;

		try {
			String result = connector.sendMessage(Messages.setShutterStop + " " + SA);

			switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
			}
		} catch (Exception e) {
			// nothing to do
		}

		return return_value;
	}

	@Override
	public int get_HVAC_fan(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_output_valve1_PWM(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_output_valve2_PWM(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_output_valve1_0_10V(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_output_valve2_0_10V(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_output_relay(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_input_TOR1(int SA) {
		
		int response = -1;

		try {
			response = Integer.parseInt(connector.sendMessage(Messages.get_HVAC_input_TOR1 + " " + Integer.toString(SA)));
		} catch (Exception e) {
			response = -1;
		}

		return response;

	}

	@Override
	public int get_HVAC_input_TOR2(int SA) {
		
		int response = -1;

		try {
			response = Integer.parseInt(connector.sendMessage(Messages.get_HVAC_input_TOR2 + " " + Integer.toString(SA)));
		} catch (Exception e) {
			response = -1;
		}

		return response;

	}

	@Override
	public int get_HVAC_input_0_10V(int SA) {
		
		int response = -1;

		try {
			response = Integer.parseInt(connector.sendMessage(Messages.get_HVAC_input_0_10V + " " + Integer.toString(SA)));
		} catch (Exception e) {
			response = -1;
		}

		return response;
	}

	@Override
	public int get_HVAC_tachy(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_power(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_version(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_error(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_position_on_switch(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_position_on_daughterBoard(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_position_on_table(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_manufacturing_year(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_manufacturing_month(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_auto(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_application(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_eco(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_air_quality(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_fan_mod(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_watchdog(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_on(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_def_input_Tsensor(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_def_temperature_compensation(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_def_input_tor1(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_def_input_tor2(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_def_input_0_10V(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_def_output_0_10V_1(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_def_output_0_10V_2(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_def_polarity_relay_window_closed(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_def_polarity_dew_point(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_def_polarity_change_over_heating(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_calibration_C02_for_10V(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_calibration_C0_for_10V(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_group_calibration_T_for_10V(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_temperature_target(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_temperature_offset(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_temperature_offset_ladder(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_temporisation_comfort_mode(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_temporisation_sleep_mode(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_temporisation_reduced_mode(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_deadband_comfort_mode(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_deadBand_sleep_mode(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_deadBand_reduced_mode(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_proportionalBand_cold(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_limit_valve_opening_cold(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_proportionalBand_hot(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_limit_valve_opening_hot(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_fan_proportionalBand(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_fan_speed_min(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_fan_speed_max(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_measure_integral_slope(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_measure_slope(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_fan_threshold_low(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_fan_threshold_high(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_fan_valve_coef(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_airQuality_target(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_airQuality_proportionalBand(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_VaV_opening_max(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_VaV_opening_min(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_6Way_tension_100_cold(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_6Way_tension_0_cold(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_6Way_tension_0_hot(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_6Way_tension_100_hot(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_HVAC_parameters_dewPoint_tempo(int group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean set_HVAC_fan(int SA, int percentage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_output_valve1_PWM(int SA, int percentage) {
	boolean return_value = false;
		
		String result = connector.sendMessage(Messages.set_HVAC_output_valve1_PWM + " " + Integer.toString(SA) + " " + Integer.toString(percentage));
		
		switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
		}	
		
		return return_value;
	
	}

	@Override
	public boolean set_HVAC_output_valve2_PWM(int SA, int percentage) {
	
		boolean return_value = false;
		
		String result = connector.sendMessage(Messages.set_HVAC_output_valve2_PWM + " " + Integer.toString(SA) + " " + Integer.toString(percentage));
		
		switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
		}	
		
		return return_value;
	
	}

	@Override
	public boolean set_HVAC_output_valve1_0_10V(int SA, int percentage) {
		boolean return_value = false;
		
		String result = connector.sendMessage(Messages.set_HVAC_output_valve1_0_10V + " " + Integer.toString(SA) + " " + Integer.toString(percentage));
		
		switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
		}	
		
		return return_value;
	
	}

	@Override
	public boolean set_HVAC_output_valve2_0_10V(int SA, int percentage) {
		
		boolean return_value = false;
		
		String result = connector.sendMessage(Messages.set_HVAC_output_valve2_0_10V + " " + Integer.toString(SA) + " " + Integer.toString(percentage));
		
		switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
		}	
		
		return return_value;
	
	}

	@Override
	public boolean set_HVAC_output_relay(int SA, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_auto(int group, boolean value) {
boolean return_value = false;
		
		String result = connector.sendMessage(Messages.set_HVAC_group_auto + " " + Integer.toString(group) + " " + Boolean.toString(value));
		
		switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
		}	
		
		return return_value;
	}

	@Override
	public boolean set_HVAC_group_application(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_eco(int group, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_air_quality(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_fan_mod(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_watchdog(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_on(int group, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_def_input_Tsensor(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_def_temperature_compensation(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_def_input_tor1(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_def_input_tor2(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_def_input_0_10V(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_def_output_0_10V_1(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_def_output_0_10V_2(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_def_polarity_relay_window_closed(int group, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_def_polarity_dew_point(int group, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_def_polarity_change_over_heating(int group, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_calibration_C02_for_10V(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_calibration_C0_for_10V(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_group_calibration_T_for_10V(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_temperature_target(int group, int value) {
		
		boolean return_value = false;
		
		String result = connector.sendMessage(Messages.set_HVAC_parameters_temperature_target + " " + Integer.toString(group) + " " + Integer.toString(value));
		
		switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
		}	
		
		return return_value;
	}

	@Override
	public boolean set_HVAC_parameters_temperature_offset(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_temperature_offset_ladder(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_temporisation_comfort_mode(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_temporisation_sleep_mode(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_temporisation_reduced_mode(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_deadband_comfort_mode(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_deadBand_sleep_mode(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_deadBand_reduced_mode(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_proportionalBand_cold(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_limit_valve_opening_cold(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_proportionalBand_hot(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_limit_valve_opening_hot(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_fan_proportionalBand(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_fan_speed_min(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_fan_speed_max(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_measure_integral_slope(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_measure_slope(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_fan_threshold_low(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_fan_threshold_high(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_fan_valve_coef(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_airQuality_target(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_airQuality_proportionalBand(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_VaV_opening_max(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_VaV_opening_min(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_6Way_tension_100_cold(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_6Way_tension_0_cold(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_6Way_tension_0_hot(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_6Way_tension_100_hot(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_HVAC_parameters_dewPoint_tempo(int group, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Deprecated
	@Override
	public boolean set_HVAC_temp_target(int group, int value) {
		
		boolean return_value = false;
		
		String result = connector.sendMessage(Messages.set_HVAC_temp_target + " " + Integer.toString(group) + " " + Integer.toString(value));
		
		switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
		}	
		
		return return_value;
	}
	
	@Deprecated
	@Override
	public boolean set_HVAC_auto(int group, int value) {
		
		boolean return_value = false;
		
		String result = connector.sendMessage(Messages.set_HVAC_auto + " " + Integer.toString(group) + " " + Integer.toString(value));
		
		switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
		}	
		
		return return_value;
	}

	@Override
	public int get_IO_input_1(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_input_2(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_input_3(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_input_4(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public short get_IO_input_all(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_output_1(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_output_2(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_output_3(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_output_4(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_output_5(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_output_6(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_output_7(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_output_8(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public short get_IO_output_all(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_power(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_version(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_error(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_group(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_position_on_switch(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_position_on_daughterBoard(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_position_on_table(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_manufacturing_year(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get_IO_manufacturing_month(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean set_IO_output_1(int SA, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_IO_output_2(int SA, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_IO_output_3(int SA, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_IO_output_4(int SA, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_IO_output_5(int SA, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_IO_output_6(int SA, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_IO_output_7(int SA, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_IO_output_8(int SA, boolean value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_IO_output_all(int SA, short value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_data1(int data1) {
		
		boolean return_value = false;

		String result = connector.sendMessage(Messages.set_Data_1 + " " + Integer.toString(data1));
			
		switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
		}
			
		return return_value;
	}

	@Override
	public boolean set_data2(int data2) {
		
		boolean return_value = false;

		String result = connector.sendMessage(Messages.set_Data_2 + " " + Integer.toString(data2));
			
		switch (result.trim()) {
			case "true":
				return_value = true;
				break;
			case "false":
				return_value = false;
			default:
				break;
		}
			
		return return_value;

	}

	@Deprecated
	@Override
	public boolean setData1(int data1) {
		
		return set_data1(data1);
		
	}

	@Deprecated
	@Override
	public boolean setData2(int data2) {
		
		return set_data2(data2);
	}
	
	



}
