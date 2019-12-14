package com.SerialButtons;




import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.fazecast.jSerialComm.SerialPort;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class TestH {
	
	static SerialPort chosenPort;
	static int x = 0;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;

	public static void main(String[] args) {
		
		// create and configure the window
		JFrame window = new JFrame();
		window.setTitle("Sensor Graph GUI");
		window.setSize(804, 474);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 584, 33);
		window.getContentPane().add(topPanel);
		JButton connectButton = new JButton("Connect");
		topPanel.add(connectButton);
		
		// create a drop-down box and connect button, then place them at the top of the window
		JComboBox<String> portList = new JComboBox<String>();
		topPanel.add(portList);
		
		textField = new JTextField();
		textField.setBounds(289, 86, 86, 20);
		window.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Battery Value");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(111, 82, 93, 27);
		window.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Temperature");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(113, 127, 91, 33);
		window.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(289, 135, 86, 20);
		window.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Humidity");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(111, 183, 93, 19);
		window.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(289, 184, 86, 20);
		window.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("10 GPIO Status");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(111, 232, 113, 27);
		window.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(289, 237, 86, 20);
		window.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Unused byte");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(111, 282, 93, 14);
		window.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Unused byte");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(111, 321, 99, 14);
		window.getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(289, 281, 86, 20);
		window.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(289, 320, 86, 20);
		window.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Incoming Data");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_6.setBounds(96, 373, 157, 34);
		window.getContentPane().add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(289, 384, 261, 20);
		window.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		
		// configure the connect button and use another thread to listen for data
		connectButton.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent arg0) {
				if(connectButton.getText().equals("Connect")) {
					// attempt to connect to the serial port
					chosenPort = SerialPort.getCommPort(portList.getSelectedItem().toString());
					chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0,16);
					if(chosenPort.openPort()) {
						connectButton.setText("Disconnect");
						portList.setEnabled(false);
					}
					
					// create a new thread that listens for incoming text and populates the graph
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
								
								
								
							    textField.setText(Integer.toString(decimal1));
							   
								textField_1.setText(Integer.toString(decimal2));
								textField_2.setText(Integer.toString(decimal3));
								
								textField_3.setText(binary1);
								textField_4.setText(binary2);
								textField_5.setText(binary3);
								
								
								
								
						
								textField_6.setText(line);
								
								
								
								
								
								
								
							
								
									window.repaint();									
								} catch(Exception e) {}
							}							
							scanner.close();
						}
					};
					thread.start();
					
					
					// create a new thread that listens for incoming text and populates the graph
			Thread thread2 = new Thread(){
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
					
					
				} else {
					// disconnect from the serial port
					chosenPort.closePort();
					portList.setEnabled(true);
					connectButton.setText("Connect");
					x = 0;
				}
			}
		});
		
		// populate the drop-down box
		SerialPort[] portNames = SerialPort.getCommPorts();
		for(int i = 0; i < portNames.length; i++)
			portList.addItem(portNames[i].getSystemPortName());
		
		// show the window
		window.setVisible(true);
	}
}


