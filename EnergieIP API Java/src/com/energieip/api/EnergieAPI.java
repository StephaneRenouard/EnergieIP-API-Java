package com.energieip.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


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

	public int getRackID() {

		int return_rack_id = -1;

		try {
			return_rack_id = Integer.parseInt(sendMessage(Messages.getRackID));
		} catch (Exception e) {
			return_rack_id = -1;
		}

		return return_rack_id;
	}

	@Override
	public String[] getList() {
		String return_list = "";

		try {
			return_list = sendMessage(Messages.getList);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] getList_Light_drivers() {
		String return_list = "";

		try {
			return_list = sendMessage(Messages.getList_Light_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] getList_Shutter_drivers() {
		String return_list = "";

		try {
			return_list = sendMessage(Messages.getList_Shutter_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] getList_TOR_drivers() {
		String return_list = "";

		try {
			return_list = sendMessage(Messages.getList_TOR_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] getList_HVAC_drivers() {
		String return_list = "";

		try {
			return_list = sendMessage(Messages.getList_HVAC_drivers);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public String[] getList_groups() {
		String return_list = "";

		try {
			return_list = sendMessage(Messages.getList_groups);
		} catch (Exception e) {
			return_list = "-1";
		}

		return makeList(return_list);
	}

	@Override
	public int getWatchdog() {

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
	public boolean setGroup(int SA, int target_group) {

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
	public void setTCPserver_IP(String tcpServer_IP) {

		Parameters.CORE_IP = tcpServer_IP;
		
	}

	@Override
	public void setTCPserver_PORT(int tcpServer_PORT) {

		Parameters.CORE_PORT = tcpServer_PORT;
		
	}

}
