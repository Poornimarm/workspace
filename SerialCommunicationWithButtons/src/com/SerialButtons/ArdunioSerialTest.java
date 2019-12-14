package com.SerialButtons;

import java.awt.BorderLayout;




import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

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

public class ArdunioSerialTest extends JFrame {
	
private static final long serialVersionUID = 1L;
	
	private SerialPort comPort;


	private String comPortName;

	
	private int baudRate = 9600;

	static PrintWriter outPut;
	static PrintWriter inPut;

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public ArdunioSerialTest() {
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
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setBounds(148, 52, 246, 20);
		panel.add(textField);
		textField.setColumns(10);
		
	
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnOn = new JButton("Led1 On");
		btnOn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOn.setBackground(Color.GREEN);
		panel_1.add(btnOn);
		
		JButton btnOff = new JButton(" Led1 Off");
		btnOff.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOff.setBackground(Color.RED);
		panel_1.add(btnOff);
		
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		
		JButton btnOn1 = new JButton("Led2 On");
		btnOn1.setBackground(Color.GREEN);
		btnOn1.setForeground(Color.BLACK);
		btnOn1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnOn1);
		
		JButton btnoff1 = new JButton("Led2 Off");
		btnoff1.setBackground(Color.RED);
		btnoff1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnoff1);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JButton btnOn2 = new JButton("Led3 On");
		btnOn2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOn2.setBackground(Color.GREEN);
		panel_3.add(btnOn2);
		
		JButton btnoff2 = new JButton("Led3 Off");
		btnoff2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnoff2.setBackground(Color.RED);
		
		panel_3.add(btnoff2);
		
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton btnOn3 = new JButton(" Led4 On");
		btnOn3.setBackground(Color.GREEN);
		btnOn3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_4.add(btnOn3);
		
		JButton btnOff3 = new JButton("Led4 Off");
		btnOff3.setBackground(Color.RED);
		btnOff3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_4.add(btnOff3);
		
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		JButton btnOn4 = new JButton("Led5 On");
		btnOn4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOn4.setBackground(Color.GREEN);
		panel_5.add(btnOn4);
		
		JButton btnOff4 = new JButton(" Led5 Off");
		btnOff4.setBackground(Color.RED);
		btnOff4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_5.add(btnOff4);
		
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		JButton btnOn5 = new JButton("Led6 On");
		btnOn5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOn5.setBackground(Color.GREEN);
		panel_6.add(btnOn5);
		
		JButton btnOff5 = new JButton("Led6 Off");
		btnOff5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOff5.setBackground(Color.RED);
		panel_6.add(btnOff5);
		
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		JButton btnOn6 = new JButton("Led7 On");
		btnOn6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOn6.setBackground(Color.GREEN);
		panel_7.add(btnOn6);
		
		JButton btnOff6 = new JButton("Led7 Off");
		btnOff6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOff6.setBackground(Color.RED);
		panel_7.add(btnOff6);
		
		
		JPanel panel_8 = new JPanel();
		contentPane.add(panel_8);
		
		JButton btnOn7 = new JButton("Led8 On");
		btnOn7.setBackground(Color.GREEN);
		btnOn7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_8.add(btnOn7);
		
		JButton btnOff7 = new JButton("Led8 Off");
		btnOff7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOff7.setBackground(Color.RED);
		panel_8.add(btnOff7);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9);
		
		JButton btnOn8 = new JButton("Led9 On");
		btnOn8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOn8.setBackground(Color.GREEN);
		panel_9.add(btnOn8);
		
		JButton btnOff8 = new JButton("Led9 Off");
		btnOff8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOff8.setBackground(Color.RED);
		panel_9.add(btnOff8);
		
		
		
	

		
		
		
	
		
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
					textField.setText("Connect Arduino");
					
			
				}
				
				
				else 
				{
					//If the port couldn't be opened print out to the console.
					System.out.println("Error opening port.");
					textField.setText("Connect Arduino");
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
							textField.setText("DisConnect Arduin");	
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
				
				//Listener for the on button.
				btnOn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						try
						{
					
						//Turns on the #13 pin LED.
						if(comPort.isOpen() == true )
						
						{
							outPut.print("1");

							URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Temperature.json ");
							HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
							
							postConnection.setRequestMethod("POST");
							
							postConnection.setRequestProperty("Content-Type", "application/json");
							postConnection.setDoOutput(true);
							PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
							//Send a 1 to the Arduino and update the user.
							System.out.println("LED1 on");
							//String s=comboBox.getName().toString();
							//textField.setText("LED1 ON");
							
						
							outPut.flush();
						}
						}
						catch(Exception E)
						
						{
							//Update the status/console if the Arduino hasn't been connected.
							System.out.println("Connect Arduino");
							textField.setText("Connect Arduin");	
						}
					}
				});
				
				
				//Listener for the off button.
				btnOff.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						try
						{
							
					
						//Turns off the #13 pin LED.
						if(comPort.isOpen() == true  )
						{
							URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Temperature.json ");
							HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
							postConnection.setRequestMethod("POST");
							
							postConnection.setRequestProperty("Content-Type", "application/json");
							postConnection.setDoOutput(true);
							PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
							//Send a 3 to the Arduino and update the user.
							System.out.println(" LED1 off");
							textField.setText("LED1 off");
							outPut.print("2");
							outPut.flush();
						}
						}
						catch(Exception E)
						{
							//Update the status/console if the Arduino hasn't been connected.
							System.out.println("Connect Arduino");
							textField.setText("Connect Arduino");
						}
					}
				});
				
				btnOn1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						//Turns on the #12 pin LED.
						if(comPort.isOpen() == true)
						{
							//Send a 3 to the Arduino and update the user.
							System.out.println(" Led2 on");
							textField.setText("Led2 ON");
							outPut.print("3");
							outPut.flush();
						}
						else
						{
							//Update the status/console if the Arduino hasn't been connected.
							System.out.println("Connect Arduino");
							textField.setText("connect Ardunio");
						}
					}
				});
				
				
				//Listener for the off button.
				 btnoff1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						//Turns off the #12 pin LED.
						if(comPort.isOpen() == true)
						{
							//Send a 4 to the Arduino and update the user.
							System.out.println("Led2 off");
							textField.setText("Led2 OFF");
							outPut.print("4");
							outPut.flush();
						}
						else
						{
							//Update the status/console if the Arduino hasn't been connected.
							//System.out.println("Connect Arduino");
							textField.setText("Connect Ardunio");
						}
					}
				});
				 
				 btnOn2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns on the #11 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 5 to the Arduino and update the user.
								System.out.println("Led3 on");
								textField.setText("Led3 On");
								outPut.print("5");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								//System.out.println("Connect Arduino");
								textField.setText("Connect Arduin");							}
						}
					});
					
					
					//Listener for the off button.
				 btnoff2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns off the #11 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 6 to the Arduino and update the user.
								System.out.println("Led3 off");
								textField.setText("Led3 OFF");			
								outPut.print("6");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								textField.setText("Connect Arduin");	
							}
						}
					});
				 
				 
				 btnOn3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns on the #10 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 7 to the Arduino and update the user.
								System.out.println("Led4 on");
								textField.setText("Led4 On");	
								outPut.print("7");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								//System.out.println("Connect Arduino");
								textField.setText("Connect Arduin");
							}
						}
					});
					
					
					//Listener for the off button.
				 btnOff3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns off the #10 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 8 to the Arduino and update the user.
								System.out.println("Led4 off");
								textField.setText("Led4 Off");
								outPut.print("8");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								textField.setText("Connect Arduin");
							}
						}
					});
				 
				 
				 btnOn4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
						
						}
					});
					
					
					//Listener for the off button.
				 btnOff4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns off the #9 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 10 to the Arduino and update the user.
								System.out.println("Led5 off");
								textField.setText("Led5 Off");
								outPut.print("10");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								textField.setText("Connect Ardunio");
								
							}
						}
					});
				 
				 
				 
				 btnOn5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns on the #8 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 11 to the Arduino and update the user.
								System.out.println("Led6 On");
								textField.setText("Led6 On");
								outPut.print("11");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								textField.setText("Connect Arduino");
							}
						}
					});
					
					
					//Listener for the off button.
				 btnOff5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns off the #8 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 12 to the Arduino and update the user.
							    System.out.println("Led6 off");
								textField.setText("Led6 Off");
								outPut.print("12");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								textField.setText("Connect Arduino");
							}
						}
					});
				 
				 
				 
				 btnOn6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns on the #7 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 14 to the Arduino and update the user.
								System.out.println("Led7 on");
								textField.setText("Led7 ON");
								outPut.print("13");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								textField.setText("Connect Arduino");
							}
						}
					});
					
					
					//Listener for the off button.
				 btnOff6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns off the #7 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 3 to the Arduino and update the user.
								System.out.println("Led7 off");
								textField.setText("Led7 Off");
								outPut.print("14");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								textField.setText("Connect Arduino");
							}
						}
					});
				 
				 
				
				 
				 btnOn7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns on the #5 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 17 to the Arduino and update the user.
								System.out.println("Led9 On");
								textField.setText("Led9 On");
								outPut.print("15");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								textField.setText("Connect Arduino");
							}
						}
					});
					
					
					//Listener for the off button.
				 btnOff7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns off the #13 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 18 to the Arduino and update the user.
								System.out.println("Led9 off");
								textField.setText("Led9 Off");
								outPut.print("16");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								textField.setText("Connect Arduino");
							}
						}
					});
				 
				 
				 btnOn8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns on the #6 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 1 to the Arduino and update the user.
								System.out.println("Led8 On");
								textField.setText("Led8 On");
								outPut.print("17");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								textField.setText("Connect Arduino");
							}
						}
					});
					
					
					//Listener for the off button.
				 btnOff8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							//Turns off the #6 pin LED.
							if(comPort.isOpen() == true)
							{
								//Send a 3 to the Arduino and update the user.
								System.out.println("Led8 off");
								textField.setText("Led8 off");
								outPut.print("18");
								outPut.flush();
							}
							else
							{
								//Update the status/console if the Arduino hasn't been connected.
								System.out.println("Connect Arduino");
								textField.setText("Connect Arduino");
							}
						}
					}); 
				 
				 
				 
	}
}
