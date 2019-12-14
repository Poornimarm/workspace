package com.SerialButtons;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Test2 extends JFrame {
	private static final long serialVersionUID = 1L;
	private SerialPort comPort;


	private String comPortName;

	
	private int baudRate = 9600;

	static PrintWriter outPut;
	static PrintWriter inPut;

	private JPanel contentPane;
	
	
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArdunioSerialTest frame = new ArdunioSerialTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		public Test2() {
			setTitle("Arduino");
			//Choose what happens when the 'x' is clicked.
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//Set the size of the GUI.
			setBounds(700, 700, 864, 462);
			//Create a new contentPane and set the borders
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new GridLayout(5, 0, 0, 0));
			
			
			JPanel panel = new JPanel();
			contentPane.add(panel);
			panel.setLayout(null);
			
			JButton btnConnect = new JButton("Connect");
			btnConnect.setFont(new Font("Times New Roman", Font.BOLD, 16));
			btnConnect.setBackground(Color.PINK);
			btnConnect.setBounds(10, 5, 155, 23);
			panel.add(btnConnect);
			
			
			JButton btnDisconnect = new JButton("Disconnect");
			btnDisconnect.setFont(new Font("Times New Roman", Font.BOLD, 16));
			btnDisconnect.setBackground(Color.CYAN);
			btnDisconnect.setBounds(184, 5, 155, 23);
			panel.add(btnDisconnect);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
			
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
			
			
			
			comboBox.setBounds(29, 52, 99, 20);
			panel.add(comboBox);
			
		
		
      
		
		
		textField = new JTextField();
		textField.setBounds(601, 86, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Battery Value");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(481, 82, 93, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Temperature");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(481, 127, 91, 33);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(601, 135, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Humidity");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(481, 183, 93, 19);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(601, 184, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("10 GPIO Status");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(481, 227, 113, 27);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(601, 232, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Unused byte");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(481, 282, 93, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Unused byte");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(481, 321, 99, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(601, 281, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(601, 320, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Incoming Data");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_6.setBounds(96, 373, 157, 34);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(289, 384, 261, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
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
				//	textField.setText("Connect Arduino");
					
			
				}
				
				
				else 
				{
					//If the port couldn't be opened print out to the console.
					System.out.println("Error opening port.");
					//textField.setText("Connect Arduino");
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
							//textField.setText("DisConnect Arduin");	
						}
					}
				});
				
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						comPortName =comboBox.getSelectedItem().toString();
						//String s=comPortName.getBytes().toString();
						//comboBox.getSelectedItem().equals(s);
					
					}
				});
				
		
		JButton btnL1On = new JButton("L1 On");
		btnL1On.setBackground(new Color(0, 128, 0));
		btnL1On.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comPort.isOpen() == true)
				{
					//Send a 1 to the Arduino and update the user.
					System.out.println("LED1 on");
					//String s=comboBox.getName().toString();
					textField.setText("LED1 ON");
					outPut.print("1");
				
					outPut.flush();
				}
				else
				{
					//Update the status/console if the Arduino hasn't been connected.
					System.out.println("Connect Arduino");
					//textField.setText("Connect Arduin");	
				}
			}
		});
		
		
		
			
		btnL1On.setHorizontalAlignment(SwingConstants.LEFT);
		btnL1On.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnL1On.setBounds(21, 85, 71, 23);
		contentPane.add(btnL1On);
		
	
		
		
		
		JButton btnL2On = new JButton("L2 On");
		btnL2On.setBackground(new Color(0, 128, 0));
		btnL2On.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnL2On.setBounds(21, 113, 71, 23);
		contentPane.add(btnL2On);
		
		JButton btnL2Off = new JButton("L2 Off");
		btnL2Off.setBackground(new Color(255, 0, 0));
		btnL2Off.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnL2Off.setBounds(96, 113, 71, 23);
		contentPane.add(btnL2Off);
		
		JButton btnL3On = new JButton("L3 On");
		btnL3On.setBackground(new Color(0, 128, 0));
		btnL3On.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnL3On.setBounds(21, 147, 71, 23);
		contentPane.add(btnL3On);
		
		JButton btnL3Off = new JButton("L3 Off");
		btnL3Off.setBackground(new Color(255, 0, 0));
		btnL3Off.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnL3Off.setBounds(96, 147, 71, 23);
		contentPane.add(btnL3Off);
		
	

		
		
		
	}
}


