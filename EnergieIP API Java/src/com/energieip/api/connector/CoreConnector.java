package com.energieip.api.connector;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


import com.energieip.api.Parameters;

/**
 * This class implements the connection mecanism to CORE
 * @author stephane@energie-ip.com
 *
 */
public class CoreConnector {
	
	private Socket socket;
	
	public boolean connectionStatus = false; // default connection status
	
	boolean DEBUG = true; 
	
	/**
	 * Default constructor
	 */
	public CoreConnector() {
		// TODO Auto-generated constructor
	}	
	

	public boolean connect(String username, String password, int mode) {
		
		boolean status = false;
		
		Parameters.USERNAME = username;
		Parameters.PASSWORD = password;
		Parameters.CONNECTION_MODE = mode;
		status = true;
		
		if(Parameters.CONNECTION_MODE==1){ // persistant
			
			try {
				socket = null;
				socket = new Socket(Parameters.CORE_IP, Parameters.CORE_PORT);
				connectionStatus = true;
			} catch (UnknownHostException e) {
				status = false;
				e.printStackTrace();
			} catch (IOException e) {
				status = false;
				e.printStackTrace();
			}
		}
		
		return status;
	}
	
	
/**
 * Test connection status with login/password
 * @return
 */
	public boolean test_Connection() {
		return String2Boolean(sendMessage(Messages.test));
		
	}
	
	
	/**
	 * String to boolean 
	 * @param string
	 * @return boolean
	 */
	private boolean String2Boolean(String string){
		
		Boolean result = false;
		string = string.trim();
		
		if(string.matches("true")){
			result = true;
		}else if(string.matches("false")) {
			result = false;
		}else{
			System.err.println("[Coreconnector] bad syntax");
		}
		
		return result;
		
	}
	
	
	
	
	/**
	 * Send TCP message and wait for response
	 * 
	 * @param message
	 * @return
	 */
	public String sendMessage(String message) {

		String message_from_server = "";

		try {
			
			if(Parameters.CONNECTION_MODE!=1){
				socket = null;
				socket = new Socket(Parameters.CORE_IP, Parameters.CORE_PORT);
			}
			
			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

			message = "1234567" + message + "\n";
			
			if(DEBUG){
				System.out.println("Sending: " + message.trim());
			}
			outToServer.writeBytes(message);
			
			if(DEBUG){
				System.out.println("Waiting for response...");
			}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			/*
			 * while ((inputLine = in.readLine()) != null) { message_from_server
			 * += inputLine; }
			 */
			message_from_server = in.readLine();
			
			if(DEBUG){
				System.out.println("From Server: " + message_from_server);
			}
			
			if(Parameters.CONNECTION_MODE!=1){
				socket.close();
			}
					
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






}
