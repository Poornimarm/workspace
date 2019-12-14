package com.SerialButtons;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fazecast.jSerialComm.SerialPort;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ArduinoControlTest extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private SerialPort comPort;
    private String comPortName;
    private int baudRate = 9600;

	static PrintWriter outPut;
	static PrintWriter inPut;

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
					ArduinoControlTest frame = new ArduinoControlTest();
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
	public ArduinoControlTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 505);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 127, 80));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.setForeground(new Color(47, 79, 79));
		btnNewButton.addActionListener(new ActionListener() {
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
						Thread.sleep(1000);
						outPut = new PrintWriter(comPort.getOutputStream());
						
					} 
					
					catch(Exception c){}
					
					//Update the console and status.
					System.out.println("Connection to Arduino successful.");
					
			
				}
				
				
				else 
				{
					//If the port couldn't be opened print out to the console.
					System.out.println("Error opening port.");
					
				}
				
				
				Thread thread = new Thread(){
					@Override public void run() {
						
						System.out.println("connected read");
						Scanner scanner = new Scanner(comPort.getInputStream());
						
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
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBackground(new Color(240, 248, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(80, 67, 125, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dissconnect");
		btnNewButton_1.setForeground(new Color(47, 79, 79));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comPort.isOpen() == true)
				{	
					//Close the port and update the console/status.
					comPort.closePort();
					System.out.println("Disconnected from Arduino.");
					//textField.setText("DisConnect Arduin");	
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(240, 248, 255));
		btnNewButton_1.setBounds(218, 67, 132, 23);
		contentPane.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(47, 79, 79));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comPortName =comboBox.getSelectedItem().toString();
			}
		});
		comboBox.setBounds(363, 70, 73, 20);
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
		contentPane.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("L1 On");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(comPort.isOpen() == true)
				{
					
					
					//Send a 1 to the Arduino and update the user.
					System.out.println("LED1 on");
					//String s=comboBox.getName().toString();
					//textField.setText("LED1 ON");
					outPut.print("1");
					//inPut.append((CharSequence) textField);
				
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
		btnNewButton_2.setBackground(new Color(50, 205, 50));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_2.setBounds(36, 115, 73, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("L1 Off");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comPort.isOpen() == true)
				{
					//Send a 3 to the Arduino and update the user.
					System.out.println(" LED1 off");
					//textField.setText("LED1 off");
					outPut.print("2");
					outPut.flush();
				}
				else
				{
					//Update the status/console if the Arduino hasn't been connected.
					System.out.println("Connect Arduino");
					//textField.setText("Connect Arduino");
				}
			}
		});
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_3.setBounds(119, 115, 73, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("L2 On");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comPort.isOpen() == true)
				{
					//Send a 1 to the Arduino and update the user.
					System.out.println("LED2 on");
					//String s=comboBox.getName().toString();
					//textField.setText("LED1 ON");
					outPut.print("3");
				
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
		btnNewButton_4.setBackground(new Color(50, 205, 50));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_4.setBounds(36, 149, 73, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("L2 Off");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comPort.isOpen() == true)
				{
					//Send a 3 to the Arduino and update the user.
					System.out.println(" LED2 off");
					//textField.setText("LED1 off");
					outPut.print("4");
					outPut.flush();
				}
				else
				{
					//Update the status/console if the Arduino hasn't been connected.
					System.out.println("Connect Arduino");
					//textField.setText("Connect Arduino");
				}
				
				
			}
		});
		btnNewButton_5.setBackground(new Color(255, 0, 0));
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_5.setBounds(119, 149, 73, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("L3 On");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Turns off the #11 pin LED.
				if(comPort.isOpen() == true)
				{
					//Send a 5 to the Arduino and update the user.
					System.out.println("Led3 on");
				//	textField.setText("Led3 On");
					outPut.print("5");
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
		btnNewButton_6.setBackground(new Color(50, 205, 50));
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_6.setBounds(36, 183, 73, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("L3 Off");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comPort.isOpen() == true)
				{
					//Send a 6 to the Arduino and update the user.
					System.out.println("Led3 off");
					//textField.setText("Led3 OFF");			
					outPut.print("6");
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
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_7.setBackground(new Color(255, 0, 0));
		btnNewButton_7.setBounds(119, 183, 73, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("L4 On");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(comPort.isOpen() == true)
				{
					//Send a 7 to the Arduino and update the user.
					System.out.println("Led4 on");
					//textField.setText("Led4 On");	
					outPut.print("7");
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
		btnNewButton_8.setBackground(new Color(50, 205, 50));
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_8.setBounds(36, 217, 73, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("L4 Off");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comPort.isOpen() == true)
				{
					//Send a 8 to the Arduino and update the user.
					System.out.println("Led4 off");
					//textField.setText("Led4 Off");
					outPut.print("8");
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
		btnNewButton_9.setBackground(new Color(255, 0, 0));
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_9.setBounds(118, 217, 74, 23);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("L5 On");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Turns on the #9 pin LED.
				if(comPort.isOpen() == true)
				{
					//Send a 9 to the Arduino and update the user.
					System.out.println("Led5 on");
					//textField.setText("Led5 On");
					outPut.print("9");
					outPut.flush();
				}
				else
				{
					//Update the status/console if the Arduino hasn't been connected.
					System.out.println("Connect Arduino");
					//textField.setText("Connect Ardunio");
				
				}
			}
		});
		btnNewButton_10.setBackground(new Color(50, 205, 50));
		btnNewButton_10.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_10.setBounds(36, 251, 73, 23);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("L5 Off");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
        //Turns off the #9 pin LED.
				
			
				if(comPort.isOpen() == true)
				{
					//Send a 10 to the Arduino and update the user.
					System.out.println("Led5 off");
				//	textField.setText("Led5 Off");
					outPut.print("10");
					outPut.flush();
				}
				else
				{
					//Update the status/console if the Arduino hasn't been connected.
					System.out.println("Connect Arduino");
				//	textField.setText("Connect Ardunio");
					
				}
				
				
			}
		});
		btnNewButton_11.setBackground(new Color(255, 0, 0));
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_11.setBounds(119, 251, 73, 23);
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("L6 On");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Turns on the #8 pin LED.
				if(comPort.isOpen() == true)
				{
					//Send a 11 to the Arduino and update the user.
					System.out.println("Led6 On");
					//textField.setText("Led6 On");
					outPut.print("11");
					outPut.flush();
				}
				else
				{
					//Update the status/console if the Arduino hasn't been connected.
					System.out.println("Connect Arduino");
					//textField.setText("Connect Arduino");
				}
			}
				
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_12.setBackground(new Color(50, 205, 50));
		btnNewButton_12.setBounds(36, 285, 73, 23);
		contentPane.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("L6 Off");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Turns off the #8 pin LED.
				if(comPort.isOpen() == true)
				{
					//Send a 12 to the Arduino and update the user.
				    System.out.println("Led6 off");
					//textField.setText("Led6 Off");
					outPut.print("12");
					outPut.flush();
				}
				else
				{
					//Update the status/console if the Arduino hasn't been connected.
					System.out.println("Connect Arduino");
					//textField.setText("Connect Arduino");
				}
				
			}
		});
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_13.setBackground(new Color(255, 0, 0));
		btnNewButton_13.setBounds(119, 285, 73, 23);
		contentPane.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("L7 On");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Turns on the #7 pin LED.
				if(comPort.isOpen() == true)
				{
					//Send a 14 to the Arduino and update the user.
					System.out.println("Led7 on");
					//textField.setText("Led7 ON");
					outPut.print("13");
					outPut.flush();
				}
				else
				{
					//Update the status/console if the Arduino hasn't been connected.
					System.out.println("Connect Arduino");
					//textField.setText("Connect Arduino");
				}
				
			}
		});
		btnNewButton_14.setBackground(new Color(50, 205, 50));
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_14.setBounds(36, 319, 73, 23);
		contentPane.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("L7 Off");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Turns off the #7 pin LED.
				if(comPort.isOpen() == true)
				{
					//Send a 3 to the Arduino and update the user.
					System.out.println("Led7 off");
					//textField.setText("Led7 Off");
					outPut.print("14");
					outPut.flush();
				}
				else
				{
					//Update the status/console if the Arduino hasn't been connected.
					System.out.println("Connect Arduino");
					//textField.setText("Connect Arduino");
				}
			}
		});
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_15.setBackground(new Color(255, 0, 0));
		btnNewButton_15.setBounds(119, 319, 73, 23);
		contentPane.add(btnNewButton_15);
		

		JButton btnNewButton_16 = new JButton("L8 On");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Turns on the #5 pin LED.
				if(comPort.isOpen() == true)
				{
					//Send a 17 to the Arduino and update the user.
					System.out.println("Led9 On");
					//textField.setText("Led9 On");
					outPut.print("15");
					outPut.flush();
				}
				else
				{
					//Update the status/console if the Arduino hasn't been connected.
					System.out.println("Connect Arduino");
					//textField.setText("Connect Arduino");
				}
				
			}
		});
		btnNewButton_16.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_16.setBackground(new Color(50, 205, 50));
		btnNewButton_16.setBounds(36, 353, 73, 23);
		contentPane.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("L8 Off");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Turns off the #13 pin LED.
				if(comPort.isOpen() == true)
				{
					//Send a 18 to the Arduino and update the user.
					System.out.println("Led9 off");
				//	textField.setText("Led9 Off");
					outPut.print("16");
					outPut.flush();
				}
				else
				{
					//Update the status/console if the Arduino hasn't been connected.
					System.out.println("Connect Arduino");
					//textField.setText("Connect Arduino");
				}
			}
		});
		btnNewButton_17.setBackground(new Color(255, 0, 0));
		btnNewButton_17.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_17.setBounds(115, 353, 77, 23);
		contentPane.add(btnNewButton_17);
		
		JLabel lblNewLabel = new JLabel("Bttery Value");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(303, 135, 86, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(422, 132, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Temperature");
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(303, 169, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Humidity");
		lblNewLabel_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(303, 212, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("10 GPIO Status");
		lblNewLabel_3.setForeground(new Color(240, 248, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(303, 246, 103, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Unused byte");
		lblNewLabel_4.setForeground(new Color(240, 248, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(303, 289, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Unused byte");
		lblNewLabel_5.setForeground(new Color(240, 248, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(303, 323, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(422, 166, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(422, 209, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(422, 243, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(422, 286, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(422, 320, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Incoming Data");
		lblNewLabel_6.setForeground(new Color(240, 248, 255));
		lblNewLabel_6.setBackground(new Color(240, 240, 240));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_6.setBounds(80, 408, 143, 26);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(245, 409, 216, 29);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		//Image img=new ImageIcon(this.getClass().getResource("/log22.png")).getImage();
	    // lblNewLabel_7.setIcon(new ImageIcon (img));
		
		
	}
}
