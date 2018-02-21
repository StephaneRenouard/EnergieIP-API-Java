package com.energieip.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ENERGIEIP JAVA API 
 * @author stephane@energie-ip.com
 *
 * this class implements the EnergieAPIInterface definition.
 *
 */
public class EnergieAPI implements EnergieAPIInterface {

	private Socket socket;

	@SuppressWarnings("unused")
	private Socket connect(String IP, int port) throws UnknownHostException, IOException {

		Socket clientSocket = null;
		clientSocket = new Socket(IP, port);
		return clientSocket;
	}

	@SuppressWarnings("unused")
	private Socket connect(String IP) throws UnknownHostException, IOException {
		Socket clientSocket = null;
		clientSocket = new Socket(IP, Parameters.CORE_PORT);
		return clientSocket;
	}

	@SuppressWarnings("unused")
	private Socket connect() throws UnknownHostException, IOException {
		Socket clientSocket = null;
		PropertiesManager.getProperties();
		clientSocket = new Socket(Parameters.CORE_IP, Parameters.CORE_PORT);
		return clientSocket;
	}

	@SuppressWarnings("unused")
	private boolean disconnect(Socket socket) throws IOException {
		socket.close();
		return socket.isClosed();
	}

	public int get_RackID() {

		int return_rack_id = -1;

		try {
			return_rack_id = Integer.parseInt(sendMessage(Messages.getRackID));
		} catch (Exception e) {
			return_rack_id = -1;
		}

		return return_rack_id;
	}

	@Override
	public String[] get_List() {
		String return_list = "";

		try {
			return_list = sendMessage(Messages.getList);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] get_List_Light_drivers() {
		String return_list = "";

		try {
			return_list = sendMessage(Messages.getList_Light_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] get_List_Shutter_drivers() {
		String return_list = "";

		try {
			return_list = sendMessage(Messages.getList_Shutter_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] get_List_TOR_drivers() {
		String return_list = "";

		try {
			return_list = sendMessage(Messages.getList_TOR_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] get_List_HVAC_drivers() {
		String return_list = "";

		try {
			return_list = sendMessage(Messages.getList_HVAC_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] get_List_groups() {
		String return_list = "";

		try {
			return_list = sendMessage(Messages.getList_groups);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public int get_Watchdog() {

		int return_watchdog = -1;

		try {
			return_watchdog = Integer.parseInt(sendMessage(Messages.getWatchdog));
		} catch (Exception e) {
			return_watchdog = -1;
		}

		return return_watchdog;
	}

	/**
	 * Send TCP message and wait for response
	 * 
	 * @param message
	 * @return
	 */
	private String sendMessage(String message) {

		String message_from_server = "";

		try {

			socket = null;
			socket = new Socket(Parameters.CORE_IP, Parameters.CORE_PORT);
			// socket = connect();

			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

			message = "1234567" + message + "\n";
			System.out.println("Sending: " + message);
			outToServer.writeBytes(message);

			System.out.println("Waiting for response...");

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String inputLine = "";

			/*
			 * while ((inputLine = in.readLine()) != null) { message_from_server
			 * += inputLine; }
			 */

			message_from_server = in.readLine();

			System.out.println("From Server: " + message_from_server);

			// disconnect(socket);
			socket.close();

		} catch (UnknownHostException e) {
			// e.printStackTrace();
			System.err.println("ERROR: TCP Client UnknownHostException");
			message_from_server = "-1";
		} catch (IOException e) {
			// e.printStackTrace();
			System.err.println("ERROR: TCP Client IOException");
			message_from_server = "-1";
		}

		return message_from_server;
	}

	/**
	 * Return List from String
	 * 
	 * @param return_list
	 * @return
	 */
	private String[] makeList(String return_list) {

		String[] myList = return_list.split(";");

		return myList;
	}

	@Override
	public boolean set_Group(int SA, int target_group) {

		boolean return_value = false;

		try {
			String result = sendMessage(Messages.setGroup + " " + SA + " " + target_group);

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
	@Deprecated
	public boolean setGroupLightPercentage(int group, int percentage) {

		boolean return_value = false;

		try {
			String result = sendMessage(Messages.setGroupLightPercentage + " " + group + " " + percentage);

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
	public boolean setIndividualLightPercentage(int SA, int percentage) {

		boolean return_value = false;

		try {
			String result = sendMessage(Messages.setIndividualLightPercentage + " " + SA + " " + percentage);

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
	@Deprecated
	public boolean setShutterUp(int SA) {

		boolean return_value = false;

		try {
			String result = sendMessage(Messages.setShutterUp + " " + SA);

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
	@Deprecated
	public boolean setShutterDown(int SA) {

		boolean return_value = false;

		try {

			String result = sendMessage(Messages.setShutterDown + " " + SA);

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
	@Deprecated
	public boolean setShutterStop(int SA) {

		boolean return_value = false;

		try {
			String result = sendMessage(Messages.setShutterStop + " " + SA);

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
	public void set_TCPserver_IP(String tcpServer_IP) {

		Parameters.CORE_IP = tcpServer_IP;

	}

	@Override
	public void set_TCPserver_PORT(int tcpServer_PORT) {

		Parameters.CORE_PORT = tcpServer_PORT;

	}

	@Override
	public boolean set_Watchdog(int watchdog) {

		boolean return_value = false;

		try {

			String result = sendMessage(Messages.setWatchdog + " " + watchdog);

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
	public boolean scan_WithErase() {
		boolean return_value = false;

		try {

			String result = sendMessage(Messages.scan_WithErase);

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
	public boolean scan_WithoutErase() {

		boolean return_value = false;

		try {

			String result = sendMessage(Messages.scan_WithoutErase);

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
	public boolean set_data1(int data1) {

		boolean return_value = false;

		
		String result = sendMessage(Messages.set_Data_1 + " " + Integer.toString(data1));
			
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
		
		String result = sendMessage(Messages.set_Data_2 + " " + Integer.toString(data2));
		
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
	public int get_HVAC_input_0_10V(int SA) {
		
		int response = -1;

		try {
			response = Integer.parseInt(sendMessage(Messages.get_HVAC_input_0_10V + " " + Integer.toString(SA)));
		} catch (Exception e) {
			response = -1;
		}

		return response;
	}

	@Override
	public int get_HVAC_input_TOR1(int SA) {
		int response = -1;

		try {
			response = Integer.parseInt(sendMessage(Messages.get_HVAC_input_TOR1 + " " + Integer.toString(SA)));
		} catch (Exception e) {
			response = -1;
		}

		return response;
	}

	@Override
	public int get_HVAC_input_TOR2(int SA) {
		
		int response = -1;

		try {
			response = Integer.parseInt(sendMessage(Messages.get_HVAC_input_TOR2 + " " + Integer.toString(SA)));
		} catch (Exception e) {
			response = -1;
		}

		return response;
	}

	@Override
	public boolean set_HVAC_output_valve1_0_10V(int SA, int value) {
	
		boolean return_value = false;
		
		String result = sendMessage(Messages.set_HVAC_output_valve1_0_10V + " " + Integer.toString(SA) + " " + Integer.toString(value));
		
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
	public boolean set_HVAC_output_valve2_0_10V(int SA, int value) {
		
		boolean return_value = false;
		
		String result = sendMessage(Messages.set_HVAC_output_valve2_0_10V + " " + Integer.toString(SA) + " " + Integer.toString(value));
		
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
	public boolean set_HVAC_output_valve1_PWM(int SA, int value) {
		
		boolean return_value = false;
		
		String result = sendMessage(Messages.set_HVAC_output_valve1_PWM + " " + Integer.toString(SA) + " " + Integer.toString(value));
		
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
	public boolean set_HVAC_output_valve2_PWM(int SA, int value) {

		boolean return_value = false;
		
		String result = sendMessage(Messages.set_HVAC_output_valve2_PWM + " " + Integer.toString(SA) + " " + Integer.toString(value));
		
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
	public boolean set_HVAC_temp_target(int group, int value) {
		
		boolean return_value = false;
		
		String result = sendMessage(Messages.set_HVAC_temp_target + " " + Integer.toString(group) + " " + Integer.toString(value));
		
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
	public boolean set_HVAC_auto(int group, int value) {
		
		boolean return_value = false;
		
		String result = sendMessage(Messages.set_HVAC_auto + " " + Integer.toString(group) + " " + Integer.toString(value));
		
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
	public boolean set_RackID() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int get_Group(int SA) {
		// TODO Auto-generated method stub
		return 0;
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
	public int get_LED_group_auto(int group) {
		// TODO Auto-generated method stub
		return 0;
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
	public int set_LED_power(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int set_LED_version(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int set_LED_error(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int set_LED_group(int SA) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public boolean set_blind_1_up(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_blind_1_down(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_blind1_stop(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_blind2_up(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_blind_2_down(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set_blind_2_stop(int SA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setData1(int data1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setData2(int data2) {
		// TODO Auto-generated method stub
		return false;
	}

}
