package com.energieip.api;

import java.util.List;

public class EnergieAPI implements EnergieAPIInterface {
	
	@Override
	public boolean connect(String IP, int port) {
		
		// use TCP client lib
		
		return false;
	}

	@Override
	public boolean connect(String IP) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean connect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disconnect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getRackID() {
		
		// send a rack ID message
		
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
	
	private Object SendTCPMessage(String message){	
		
		// send message and wait for return;
		
		// get the return and send to analyse
			//object result = AnalyseReturn(returned_message);
			//return result (that is an object, typo is done in method
		
		
	}

}
