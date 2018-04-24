package com.energieip.api;


/*
 * SimpleRead.java
 *
 * Copyright (c) 2009 handco research, Inc. All Rights Reserved.
 *
 * Handco grants you ("Licensee") a non-exclusive, royalty free, license 
 * to use, modify and redistribute this software in source and binary
 * code form, provided that i) this copyright notice and license appear
 * on all copies of the software; and ii) Licensee does not utilize the
 * software in a manner which is disparaging to handco.
 *
 * This software is provided "AS IS," without a warranty of any kind.
 * 
 * ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES,
 * INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. 
 * HANDCO SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY
 * LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THE
 * SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL HANDCO BE LIABLE FOR 
 * ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES,
 * HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING
 * OUT OF THE USE OF OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * This software is not designed or intended for use in on-line control
 * of aircraft, air traffic, aircraft navigation or aircraft
 * communications; or in the design, construction, operation or
 * maintenance of any nuclear facility. Licensee represents and
 * warrants that it will not use or redistribute the Software for such
 * purposes.
 * 
 */

import java.io.*;
import java.util.*;

import javax.swing.event.EventListenerList;

import fr.handco.lib.meter.MeterFrame;
import fr.handco.lib.time.Time;
import fr.handco.lib.tools.Debug;
import fr.handco.meter.Meter;
import fr.handco.meter.MeterListener;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

/**
 * This class allows to listen to an Energy Meter on Serial Port
 * @author Stephane Renouard <stephane.renouard@handco.fr>
 * @date April 2011
 * @version 2
 * @copyright HANDCO 2009-2011 
 * 
 */
public class SimpleRead implements SerialPortEventListener, Runnable{

	private boolean DEBUG = false;
	
	private Meter meter;
	
	@SuppressWarnings("rawtypes")
	private Enumeration portList;
	private CommPortIdentifier portId;
	private SerialPort serialPort;
	@SuppressWarnings("unused")
	private OutputStream outputStream;
	@SuppressWarnings("unused")
	private InputStream inputStream;
	Thread readThread;

	BufferedReader in;

	/*
	 * user defined data
	 */
	String PORT = "/dev/ttyUSB0";
	
	/*
	 * meter is 1200
	 * wireless is 9600
	 */
	int PORT_SPEED = 1200;
	int PORT_DATABITS = SerialPort.DATABITS_7;
	int PORT_STOPBITS = SerialPort.STOPBITS_1;
	int PORT_PARITY = SerialPort.PARITY_EVEN;

	
	
	
	/*
	 * Listener for eventing model 
	 */
    private final EventListenerList listeners = new EventListenerList();

	
	/*
	 * debug
	 */
	private Debug debug;
	
	/**
	 * Main entry point
	 * @param args
	 */
	public static void main(String[] args) {

		new SimpleRead();
		
	}

	/**
	 * constructor
	 */
	public SimpleRead() {
		
		meter = new Meter();
		
		debug = new Debug(this);
		debug.state=true;
		

		debug.print("SimpleDataRead on port " + PORT);

		
		/*
		 * RAZ params
		 */
		
		RAZparams();
	
		/*
		 * getting serial port list
		 */
		portList = CommPortIdentifier.getPortIdentifiers();

		while (portList.hasMoreElements()) {
			portId = (CommPortIdentifier) portList.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				
				if (portId.getName().equals(PORT)) {

					System.out.println("Found " + portId.getName());

					/*
					 * opening port
					 */

					try {
						serialPort = (SerialPort) portId.open("SimpleApp",
								2000);
					} catch (PortInUseException e) {
					}

					/*
					 * getting input and output streams
					 */

					try {
						// for READING data
						//inputStream = serialPort.getInputStream(); // OLD METHOD
						in = new BufferedReader(new InputStreamReader(
								serialPort.getInputStream()));
						// for WRITTING data
						outputStream = serialPort.getOutputStream();
					} catch (IOException e) {
					}

					/*
					 * setting port parameters
					 */
					try {
						serialPort.setSerialPortParams(PORT_SPEED,
								PORT_DATABITS, PORT_STOPBITS, PORT_PARITY);
						serialPort
								.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
					} catch (UnsupportedCommOperationException e) {
					}

					/*
					 * launching reading thread using EventListener
					 */
					try {
						serialPort.addEventListener(this);
					} catch (TooManyListenersException e) {
					}
					serialPort.notifyOnDataAvailable(true);
					
					

					readThread = new Thread(this);
					readThread.start();

			
					 
				}
				
				else {
					System.out.println ("ERROR: " + PORT + " unreachable");
				}

			}
		}
	}

	/**
	 * main thread for reading on serial port
	 */
	public void run() {
		
		System.out.println("starting main thread");
		
		while (!Thread.interrupted()) {
			
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

		
	}



	/**
	 * event handler for serial events 
	 */
	public void serialEvent(SerialPortEvent event) {

		/*
		 * creating StringBuffer for reading
		 */
		// for old reading method
		//StringBuffer inputBuffer = new StringBuffer();

		/*
		 * switch for message events
		 */
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		/*
		 * the one that is interesting us
		 */
		case SerialPortEvent.DATA_AVAILABLE:

			// debug purpose
			//System.out.println("incomming data ");

			/*
			 *  OLD METHOD : defined readbuffer size
			 *
			byte[] readBuffer = new byte[20];
			
			
			try {
			while (inputStream.available() > 0) {
			    int numBytes = inputStream.read(readBuffer);
			}
			System.out.print(new String(readBuffer));
			System.out.println("\n");
			} catch (IOException e) {}
			break;
			 */

			/*
			 * NEW METHOD : dynamic readbuffer size
			 
			 while (true) {
			 	try {
			 	    newData =  inputStream.read();
			 	    if ('\r' == (char)newData) {
			 	    	System.out.println(" r newData");
			 	    	inputBuffer.append('\n');
			 	    } else if ('\n' == (char) newData) {
			 	    	System.out.println(" END newData");
			 	    	break;
			 	        		    	    	
			 	    } else {
			 	    	System.out.println("appending newData");
			 	    	inputBuffer.append(newData);
			 	    	System.out.println("nouvelle donn�e: " + newData);
			 	    	System.out.println("total: " + new String(inputBuffer));
			 	    }
			 	} catch (IOException ex) {
			 		System.err.println(ex);
			 		return;
			 	}
			  }
			 
			 System.out.println("FINAL:");
			System.out.println(new String(inputBuffer));
			
			// end switch
			break;
			 */

			/*
			 * Another way (very simple and efficient): response is a string
			 */
			String received_data = new String();
			try {
				
				//reading buffer 
				received_data = (String) in.readLine();
				
				if(DEBUG){
				System.out.println("[DATA]=" + received_data); // DEBUG PURPOSE
				}
					
					if(received_data.contains("ADCO")) {
						meter.ADCO=(received_data.split(" "))[1];
					}
				
					else if(received_data.contains("OPTARIF")) {
						meter.OPTARIF=(received_data.split(" "))[1];
					}
				else if(received_data.contains("ISOUSC")) {
						meter.ISOUSC = Integer.parseInt((received_data.split(" "))[1]);
					}
					else if(received_data.contains("HCHC")) {
						meter.HCHC = Integer.parseInt((received_data.split(" "))[1]);
					}
					
					else if(received_data.contains("HCHP")) {
						meter.HCHP = Integer.parseInt((received_data.split(" "))[1]);
					}
					else if(received_data.contains("BASE")) {
						meter.BASE = Integer.parseInt((received_data.trim().split(" "))[1]);
					}
					else if(received_data.contains("PTEC")) {
						meter.PTEC=(received_data.split(" "))[1];
					}
					else if(received_data.contains("IINST")) {
						meter.IINST = Integer.parseInt((received_data.split(" "))[1]);
					}
					else if(received_data.contains("IMAX")) {
						meter.IMAX = Integer.parseInt((received_data.split(" "))[1]);
						
					}
					else if(received_data.contains("PAPP")) {
						meter.PAPP = Integer.parseInt((received_data.split(" "))[1]);
					}
					else if(received_data.contains("HHPHC")) {
						meter.HHPHC = (received_data.split(" "))[1];
					}
					else if(received_data.contains("MOTDETAT")) {
						meter.MOTDETAT = true;
						//System.out.println("FINI-------------------------------------");
					}
					else {}
					
					
				

				
				if (meter.MOTDETAT==true) {
					
					/*
					if(DEBUG){
					System.out.println("ADCO=" + ADCO);
					System.out.println("OPTARIF=" + OPTARIF);
					System.out.println("ISOUSC=" + ISOUSC);
					System.out.println("HCHC=" + HCHC);
					System.out.println("HCHP=" + HCHP);
					System.out.println("BASE=" + BASE);
					System.out.println("PTEC=" + PTEC);
					System.out.println("IINST=" + IINST);
					System.out.println("IMAX=" + IMAX);
					System.out.println("PAPP=" + PAPP);
					System.out.println("HHPHC=" + HHPHC);
					}
					
					
					/*
					 * assemblage trame
					 */
				
					String frame = ("ADCO=" + meter.ADCO + " OPTARIF=" + meter.OPTARIF + " ISOUSC=" + meter.ISOUSC + " HCHC=" + meter.HCHC + " HCHP=" + meter.HCHP + " BASE=" + meter.BASE + " PTEC=" + meter.PTEC + " IINST=" + meter.IINST + " IMAX=" + meter.IMAX + " PAPP=" + meter.PAPP+ " HHPHC=" + meter.HHPHC);
					
					System.out.println("trame=" + frame);
					
					MeterFrame trame = new MeterFrame();
					
					
					
					trame.ADCO = meter.ADCO;
					trame.OPTARIF = meter.OPTARIF;
					trame.ISOUSC = meter.ISOUSC;
					trame.HCHC = meter.HCHC;
					trame.HCHP = meter.HCHP;
					trame.PTEC = meter.PTEC;
					trame.IINST = meter.IINST;
					trame.IMAX = meter.IMAX;
					trame.PAPP = meter.PAPP;
					trame.HHPHC = meter.HHPHC;
					trame.MOTDETAT = true;		
					
					if(trame.OPTARIF.matches("BASE")){
						trame.HCHP = meter.BASE;
					}
					
					
					trame.TAG = Time.timeStamp("").trim();
					
					
					fireMeterFrameChanged(trame);
					
					/*
					 * RAZ params
					 */
					
					//RAZparams();
					
					meter.MOTDETAT = false;
					
					
					/*
					 * END OF PROCESS
					 */
					
					//System.out.println("------------------------------\n");
					
				}
				
					
				

			} catch (IOException e) {
			}

			break;

		
	}



		
		
	}
	
	@SuppressWarnings("unused")
	private void makeFrame(String trame) {
		// TODO Auto-generated method stub
		
	}

	private void RAZparams() {
		meter.ADCO = "error";
		meter.OPTARIF = "error";
		meter.ISOUSC = -1;
		meter.HCHC = -1;
		meter.HCHP = -1;
		meter.BASE = -1;
		meter.PTEC = "error";
		meter.IINST = -1;
		meter.IMAX = -1;
		meter.PAPP = -1;
		meter.HHPHC = "null";	
	}

	/**
	 * stopping everything
	 *
	 */
	public void close() {
		
		//stop the thread
		Thread.interrupted();
		
		// close the port
		serialPort.close();
		
		
		
	}

	/*
	 * LISTENERS
	 */
    public void addMeterListener(MeterListener listener) {
        listeners.add(MeterListener.class, listener);
    }	

    public void removeMeterListener(MeterListener listener) {
        listeners.remove(MeterListener.class, listener);
    }
    
    public MeterListener[] getMeterListeners() {
        return listeners.getListeners(MeterListener.class);
    }
    
    protected void fireMeterFrameChanged(MeterFrame frame) {
            for(MeterListener listener : getMeterListeners()) {
                listener.newFrame(frame);
            }
    }


}
