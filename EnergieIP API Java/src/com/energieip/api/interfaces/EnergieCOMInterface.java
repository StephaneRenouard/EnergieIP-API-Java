package com.energieip.api.interfaces;

public interface EnergieCOMInterface {
	

	/*
	 * TCP parameters
	 */
	
	boolean set_TCPserver_IP(String tcpServer_IP);
	boolean set_TCPserver_PORT(int tcpServer_PORT);

	boolean connect(String username, String password);
	boolean connect(String username, String password, int mode);
	
	boolean get_connectionStatus();
	boolean set_connectionStatus(boolean connectionStatus);
	
	boolean get_testConnection();
	
	boolean disconnect();
	

}
