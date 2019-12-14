package com.SerialButtons;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import com.fazecast.jSerialComm.SerialPort;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class ArdunoSerial extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private SerialPort comPort;

	private String comPortName = "COM4";
	
	private int baudRate = 9600;

	static PrintWriter outPut;


	private JPanel contentPane;

	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArdunoSerial frame = new ArdunoSerial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ArdunoSerial() {


		setTitle("Arduino");
		//Choose what happens when the 'x' is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set the size of the GUI.
		setBounds(400, 400, 446, 362);
		//Create a new contentPane and set the borders
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 0, 0, 0));
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(80, 10, 73, 23);
		panel.add(btnConnect);
		
		
		JButton btnDisconnect = new JButton("Disconnect");
		btnDisconnect.setBounds(174, 10, 85, 23);
		panel.add(btnDisconnect);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(206, 5, 85, 23);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(301, 11, 91, 20);
		panel.add(comboBox_1);
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnOn = new JButton("Led On");
		panel_1.add(btnOn);
		

		
		JButton btnOff = new JButton(" Led Off");
		panel_1.add(btnOff);
		
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		
		JButton btnOn1 = new JButton("TV On");
		panel_2.add(btnOn1);
		
		JButton btnoff1 = new JButton("Tv Off");
		panel_2.add(btnoff1);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JButton btnOn2 = new JButton("Fan On");
		panel_3.add(btnOn2);
		
		JButton btnoff2 = new JButton("Fan Off");
		panel_3.add(btnoff2);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblStatus);
		
		
		
		
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//Set up the values for the USB port.
				comPort = SerialPort.getCommPort(comPortName);
				comPort.setBaudRate(baudRate);
					
				//If the port is not closed, open the USB port.
				if(comPort.isOpen() == false)
				{	
					try 
					{
						//Open the USB port and initialize the PrintWriter.
						comPort.openPort();
						Thread.sleep(1000);
						outPut = new PrintWriter(comPort.getOutputStream());
					} 
					
					catch(Exception c){}
					
					//Update the console and status.
					System.out.println("Connection to Arduino successful.");
					lblStatus.setText("Status: Connected");
					
			
				}
				
				
				else 
				{
					//If the port couldn't be opened print out to the console.
					System.out.println("Error opening port.");
					lblStatus.setText("Status: Opening USB failed");
				}
			}
			
			
			
		});
		
		//Listener for the disconnect button.
				btnDisconnect.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						//Close the USB port if it's open.
						if(comPort.isOpen() == true)
						{	
							//Close the port and update the console/status.
							comPort.closePort();
							System.out.println("Disconnected from Arduino.");
							lblStatus.setText("Status: Disconnected");
						}
					}
				});
				
				//Listener for the on button.
				btnOn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						//Turns on the #13 pin LED.
						if(comPort.isOpen() == true)
						{
							//Send a 1 to the Arduino and update the user.
							System.out.println("Status: LsED on");
							lblStatus.setText("Status: LED on");
							outPut.print("1");
							outPut.flush();
						}
						else
						{
							//Update the status/console if the Arduino hasn't been connected.
							System.out.println("Connect Arduino");
							lblStatus.setText("Status: Connect Arduino");
						}
					}
				});
				
				
				//Listener for the off button.
				btnOff.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						//Turns off the #13 pin LED.
						if(comPort.isOpen() == true)
						{
							//Send a 3 to the Arduino and update the user.
							System.out.println("Status: LED off");
							lblStatus.setText("Status: LED off");
							outPut.print("2");
							outPut.flush();
						}
						else
						{
							//Update the status/console if the Arduino hasn't been connected.
							System.out.println("Connect Arduino");
							lblStatus.setText("Status: Connect Arduino");
						}
					}
				});
				
				btnOn1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						//Turns on the #13 pin LED.
						if(comPort.isOpen() == true)
						{
							//Send a 1 to the Arduino and update the user.
							System.out.println("Status: TV on");
							lblStatus.setText("Status: TV on");
							outPut.print("3");
							outPut.flush();
						}
						else
						{
							//Update the status/console if the Arduino hasn't been connected.
							System.out.println("Connect Arduino");
							lblStatus.setText("Status: Connect Arduino");
						}
					}
				});
				
				
				//Listener for the off button.
				 btnoff1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						//Turns off the #13 pin LED.
						if(comPort.isOpen() == true)
						{
							//Send a 3 to the Arduino and update the user.
							System.out.println("Status: TV off");
							lblStatus.setText("Status: TV off");
							outPut.print("4");
							outPut.flush();
						}
						else
						{
							//Update the status/console if the Arduino hasn't been connected.
							System.out.println("Connect Arduino");
							lblStatus.setText("Status: Connect Arduino");
						}
					}
				});
				 
				 btnOn2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns on the #13 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 1 to the Arduino and update the user.
								System.out.println("Status: Fan on");
								lblStatus.setText("Status: Fan on");
								outPut.print("5");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								lblStatus.setText("Status: Connect Arduino");
							}
						}
					});
					
					
					//Listener for the off button.
				 btnoff2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns off the #13 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 3 to the Arduino and update the user.
								System.out.println("Status: Fan off");
								lblStatus.setText("Status: Fan off");
								outPut.print("6");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								lblStatus.setText("Status: Connect Arduino");
							}
						}
					});
	}
}
