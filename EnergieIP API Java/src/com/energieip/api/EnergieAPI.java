package com.energieip.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class EnergieAPI implements EnergieAPIInterface {
	
	private Socket socket;
	
	private Socket connect(String IP, int port) throws UnknownHostException, IOException {
		
		Socket clientSocket = null;
		clientSocket = new Socket(IP, port);
		return clientSocket;
	}

	private Socket connect(String IP) throws UnknownHostException, IOException {
			Socket clientSocket = null;
			clientSocket = new Socket(IP, Parameters.CORE_PORT);
			return clientSocket;
	}

	private Socket connect() throws UnknownHostException, IOException {
		Socket clientSocket = null;
		clientSocket = new Socket(Parameters.CORE_IP, Parameters.CORE_PORT);
		return clientSocket;
	}

	private boolean disconnect(Socket socket) throws IOException {
		socket.close();
		return socket.isClosed();
	}

	public int getRackID() {
		
		int return_rack_id = 0;
		
		try{
			return_rack_id = Integer.parseInt(sendMessage(Messages.getRackID));
		} catch (Exception e){
			return_rack_id = 0;
		}
		
		return return_rack_id;		
	}

	

	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getList_Light_drivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getList_Shutter_drivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getList_TOR_drivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getList_HVAC_drivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getList_groups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWatchdog() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Send TCP message and wait for response
	 * @param message
	 * @return
	 */
	private String sendMessage(String message) {
		
		String  message_from_server = "";
		
		try {
			
		//Socket socket = new Socket(Parameters.CORE_IP, Parameters.CORE_PORT);
		socket = null;
		socket = new Socket("localhost", 8082);
		//socket =  connect();
	
		DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
		
		
		message = "1234567" + message + "\n";
		System.out.println("Sending: " + message);
		outToServer.writeBytes(message);
		
		System.out.println("Waiting for response...");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		
		String inputLine  = "";
		
		/*
		while ((inputLine = in.readLine()) != null) {
			message_from_server += inputLine;
		}
		*/
		
		message_from_server = in.readLine();
		
		System.out.println("From Server: " + message_from_server);
		
		//disconnect(socket);
		socket.close();
		
		} catch (UnknownHostException e) {
			//e.printStackTrace();
			System.err.println("ERROR: TCP Client UnknownHostException");
			message_from_server="-1";
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("ERROR: TCP Client IOException");
			message_from_server="-1";
		}
			
		return message_from_server;
	}

}
