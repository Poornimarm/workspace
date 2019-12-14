package com.SerialButtons;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class SinglePageAurdino extends JFrame {
	private SerialPort chosenPort;
	static int x = 0;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglePageAurdino frame = new SinglePageAurdino();
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
	public SinglePageAurdino() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 445);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox<String> portList = new JComboBox<String>();
		contentPane.add(portList);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(btnConnect.getText().equals("Connect")) {
					// attempt to connect to the serial port
					chosenPort = SerialPort.getCommPort(portList.getSelectedItem().toString());
					chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0,16);
					if(chosenPort.openPort()) {
						btnConnect.setText("Disconnect");
						portList.setEnabled(false);
					}
					
					Thread thread = new Thread(){
						@Override public void run() {
							
							System.out.println("connected read");
							Scanner scanner = new Scanner(chosenPort.getInputStream());
							
							while(scanner.hasNextLine()) {
								try {
								String line = scanner.nextLine();
									
								
								//String s="0c3c";
								String s1=line.substring(2,4);
								String s2=line.substring(4,6);
								String s3=line.substring(6,8);
								String s4=line.substring(8,10);
								String s5=line.substring(10,12);
								String s6=line.substring(12,14);
								
								int decimal1=Integer.parseInt(s1,16);
							
								int decimal2=Integer.parseInt(s2,16);
								
								int decimal3=Integer.parseInt(s3,16);
								
								int   decimal4=Integer.parseInt(s4,16);
								String binary1=Integer.toBinaryString(decimal4);
								
								
								int   decimal5=Integer.parseInt(s5,16);
								String binary2=Integer.toBinaryString(decimal5);
								
								
								int decimal6=Integer.parseInt(s6,16);
								String binary3=Integer.toBinaryString(decimal6);
								
								
								System.out.println(decimal1);
								System.out.println(decimal2);
								System.out.println(decimal3);
								System.out.println(binary1);
								System.out.println(binary2);
								System.out.println(binary3);
								
								
								/*System.out.println(s.substring(4, 6));
								System.out.println(s.substring(6, 8));
								System.out.println(s);*/
								
							   //int d1=Integer.parseInt( textField.getText());
							    textField.setText(Integer.toString(decimal1));
							   
								textField_1.setText(Integer.toString(decimal2));
								textField_2.setText(Integer.toString(decimal3));
								
								textField_3.setText(binary1);
								textField_4.setText(binary2);
								textField_5.setText(binary3);
								
								
								
								
						
								textField_6.setText(line);
								
								
								
								
								
								
								
							
								
									contentPane.repaint();									
								} catch(Exception e) {}
							}							
							scanner.close();
						}
					};
					thread.start();
					
					
					// create a new thread that listens for incoming text and populates the graph
				/*	Thread thread2 = new Thread(){
						@Override public void run() {
							System.out.println("connected write");
							//Scanner scan = new Scanner(System.in);
							//String input = "1";
							PrintWriter output = new PrintWriter(chosenPort.getOutputStream());
							while (true) {
								//input = scan.nextLine();
								//output.print(input);
								output.flush();
							}
							// output.close();
						}
					};
					thread2.start();
					*/
					
				} else {
					// disconnect from the serial port
					chosenPort.closePort();
					portList.setEnabled(true);
					btnConnect.setText("Connect");
					x = 0;
				}
			}
		});
		
		// populate the drop-down box
		SerialPort[] portNames = SerialPort.getCommPorts();
		for(int i = 0; i < portNames.length; i++)
			portList.addItem(portNames[i].getSystemPortName());
		
		// show the window
		contentPane.setVisible(true);
				
		btnConnect.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnConnect.setBounds(72, 11, 110, 23);
		contentPane.add(btnConnect);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(192, 14, 69, 20);
		contentPane.add(comboBox);
		
		JButton btnOnL1 = new JButton("L1 On");
		btnOnL1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnOnL1.setBounds(10, 75, 86, 23);
		contentPane.add(btnOnL1);
		
		JButton btnOnL2 = new JButton("L2 On");
		btnOnL2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnOnL2.setBounds(10, 109, 86, 23);
		contentPane.add(btnOnL2);
		
		JButton btnOnL3 = new JButton("L3 On");
		btnOnL3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnOnL3.setBounds(10, 143, 86, 23);
		contentPane.add(btnOnL3);
		
		JButton btnOnL4 = new JButton("L4 On");
		btnOnL4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnOnL4.setBounds(10, 177, 86, 23);
		contentPane.add(btnOnL4);
		
		JButton btnOnL5 = new JButton("L5 On");
		btnOnL5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnOnL5.setBounds(10, 211, 86, 23);
		contentPane.add(btnOnL5);
		
		JButton btnOnL6 = new JButton("L6 On");
		btnOnL6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnOnL6.setBounds(10, 245, 86, 23);
		contentPane.add(btnOnL6);
		
		JButton btnOnL7 = new JButton("L7 On");
		btnOnL7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnOnL7.setBounds(10, 279, 86, 23);
		contentPane.add(btnOnL7);
		
		JButton btnOnL8 = new JButton("L8 On");
		btnOnL8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnOnL8.setBounds(10, 313, 86, 23);
		contentPane.add(btnOnL8);
		
		JButton btnOnL9 = new JButton("L9 On");
		btnOnL9.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnOnL9.setBounds(10, 345, 86, 23);
		contentPane.add(btnOnL9);
		
		textField = new JTextField();
		textField.setBounds(415, 78, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Battery Value");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(260, 79, 86, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Temperature");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(260, 114, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Humidity");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(260, 152, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("10 GPIO Status");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(260, 186, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(415, 112, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(415, 146, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(415, 180, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Unused byte");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(260, 213, 96, 20);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(415, 214, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Unused byte");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(260, 250, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(415, 248, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Incoming Data");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_6.setBounds(192, 330, 116, 23);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(362, 333, 151, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
	}
}
