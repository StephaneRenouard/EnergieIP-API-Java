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
	
	/**
	 * Default constructor
	 */
	public CoreConnector() {
		// TODO Auto-generated constructor stu
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

			socket = null;
			socket = new Socket(Parameters.CORE_IP, Parameters.CORE_PORT);
			// socket = connect();

			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

			message = "1234567" + message + "\n";
			System.out.println("Sending: " + message);
			outToServer.writeBytes(message);

			System.out.println("Waiting for response...");

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
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

}
