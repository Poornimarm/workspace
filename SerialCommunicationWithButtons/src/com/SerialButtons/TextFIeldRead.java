package com.SerialButtons;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.io.Reader;
import java.util.Scanner;
public class TextFIeldRead extends JFrame {
private static final long serialVersionUID = 1L;

protected static final SerialPort DATA_AVAILABLE = null;
	
	private SerialPort comPort;


	private String comPortName;

	
	private int baudRate = 9600;

	static PrintWriter outPut;


	private JPanel contentPane;
	private BufferedReader input;
	private OutputStream output;
	private JTextField textField;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextFIeldRead frame = new TextFIeldRead();
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
	public TextFIeldRead() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Temperature");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(196, 90, 86, 18);
		contentPane.add(lblNewLabel);
		
		
		//Ardunino connect
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				comPort = SerialPort.getCommPort(comPortName);
				comPort.setBaudRate(baudRate);
					
				//If the port is not closed, open the USB port.
				if(comPort.isOpen() == false)
					
				{	
					try 
					{
						if(comPort.openPort() && SerialPort.LISTENING_EVENT_DATA_AVAILABLE==1)
						{
						//Thread.sleep(2000);
						outPut = new PrintWriter(comPort.getOutputStream());
						String s=serialRead();
						System.out.println(s);
						textField.setText(s);
					}
					}
					catch(Exception c){}
					
					//Update the console and status.
					System.out.println("Connection to Arduino successful.");
					//textField.setText("Connect Arduino");
					
					
					
				}
				
				
				else 
				{
					//If the port couldn't be opened print out to the console.
					System.out.println("Error opening port.");
					textField.setText("Connect Arduino");
				}
				
				
			}

			
			
				public String serialRead()
				{
					//Loop through and read the serial port while the comport has not timed out.
					//comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
					
					//String to save incoming data to.
					String dataIn="";
					
					//Scanner object to read in through the comport.
					Scanner in = new Scanner(comPort.getInputStream());
					
					//try
					//{
						//Grab data if there is a next value.  Sleep for 500 milliseconds after, same as the Arduino is senidng it.
					//if(in.hasNext())
					//{
							dataIn = in.next();
						//Thread.sleep(2000);
						//}
						
						//Close the scanner.
					//   	in.close();
					//} 
				//	catch (Exception e) 
					//{
					//	System.out.println("Error reading the data from serial.");
					//	e.printStackTrace();
					//}
					//Return the 
					
					//}
					return dataIn;
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(86, 30, 115, 23);
		contentPane.add(btnNewButton);
		
		//Ardunio Disconnected
		JButton btnNewButton_1 = new JButton("Dissconect");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
						//Thread.sleep(2000);
						//outPut = new PrintWriter(comPort.getOutputStream());
						//input = new BufferedReader(new InputStreamReader(comPort.getInputStream()));
						//output = serialPort.getOutputStream();
						
					} 
					
					catch(Exception c){}
					
					//Update the console and status.
					System.out.println("Connection to Arduino successful.");
					//textField.setText("Connect Arduino");
					
			
				}
				
				
				else 
				{
					//If the port couldn't be opened print out to the console.
					System.out.println("Error opening port.");
					textField.setText("Connect Arduino");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(254, 30, 115, 23);
		contentPane.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		
		
		comboBox.addItem("COM1");
		comboBox.addItem("COM2");
		comboBox.addItem("COM3");
		comboBox.addItem("COM4");
		comboBox.addItem("COM5");
		comboBox.addItem("COM6");
		comboBox.addItem("COM7");
		comboBox.addItem("COM8");
		comboBox.addItem("COM9");
		comboBox.addItem("COM10");
		comboBox.addItem("COM11");
		comboBox.addItem("COM12");
		comboBox.addItem("COM13");
		comboBox.addItem("COM14");
		comboBox.addItem("COM15");
		comboBox.addItem("COM16");
		comboBox.addItem("COM17");
		comboBox.addItem("COM18");
		comboBox.addItem("COM19");
		comboBox.addItem("COM20");
		comboBox.addItem("COM21");
		comboBox.addItem("COM22");
		comboBox.addItem("COM23");
		comboBox.addItem("COM24");
		comboBox.addItem("COM25");
		comboBox.addItem("COM26");
		comboBox.addItem("COM27");
		comboBox.addItem("COM28");
		comboBox.addItem("COM29");
		comboBox.addItem("COM30");
		
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comPortName =comboBox.getSelectedItem().toString();
			}
		});
		comboBox.setBounds(427, 33, 127, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(329, 90, 269, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
