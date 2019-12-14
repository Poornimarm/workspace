package com.serial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;

public class Firstproject {

	private JFrame frame;
	private JTextField Edit1;
	private JTextField Edit;
	private JTextField textField;
	private JToggleButton tglbtnNewToggleButton_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Firstproject window = new Firstproject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Firstproject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 641, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField.setBounds(24, 34, 345, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("LED");
	
		tglbtnNewToggleButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		tglbtnNewToggleButton.setBounds(24, 93, 152, 23);
		frame.getContentPane().add(tglbtnNewToggleButton);
		
		
		
		
		JToggleButton	tglbtnNewToggleButton_1 = new JToggleButton("TV");
		tglbtnNewToggleButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tglbtnNewToggleButton_1.setBounds(24, 137, 152, 23);
		frame.getContentPane().add(tglbtnNewToggleButton_1);
		
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("DOOR");
		tglbtnNewToggleButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tglbtnNewToggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		tglbtnNewToggleButton_2.setBounds(24, 189, 152, 23);
		frame.getContentPane().add(tglbtnNewToggleButton_2);
		
		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("FAN");
		tglbtnNewToggleButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		tglbtnNewToggleButton_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tglbtnNewToggleButton_3.setBounds(24, 235, 152, 23);
		frame.getContentPane().add(tglbtnNewToggleButton_3);
		
		
		
	
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)  {
				
					try
					{
					
                   int num;
					
					String s1=  " Led On ";
					 
					
					String s2= "LED OFF";
					 
					
					String s3= "TV ON";
					
					String s4= "TV OFF";
					 
					
					String s5= "DOOR OPEN";
					 
					String s6= "DOOR CLOSE";
					 
					
					String s7= "FAN ON";
					 
					String s8= "FAN OFF";
					
					
					num=Integer.parseInt(textField.getText());
					if(num==1) 
					{
						tglbtnNewToggleButton.setText(s1);
						tglbtnNewToggleButton.setBackground(Color.GREEN);
						
						
						URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/post.json ");
						HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
						postConnection.setRequestMethod("POST");
						postConnection.setRequestProperty("userId", "a1bcdefgh");
						postConnection.setRequestProperty("Content-Type", "application/json");
						postConnection.setDoOutput(true);
						OutputStream os = postConnection.getOutputStream();
						os.write(s1.getBytes());
						
						os.flush();
						os.close();
						int responseCode = postConnection.getResponseCode();
						System.out.println("POST Response Code :  " + responseCode);
						System.out.println("POST Response Message : " + postConnection.getResponseMessage());
						if (responseCode == HttpURLConnection.HTTP_CREATED) { // success
							BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
							String inputLine;
							StringBuffer response = new StringBuffer();
							while ((inputLine = in.readLine()) != null) {
								response.append(inputLine);
							}
							in.close();
							// print result

							System.out.println(response.toString());
						} 
					
					}
					
					else if(num==2)
					{
						tglbtnNewToggleButton.setText(s2);
						tglbtnNewToggleButton.setBackground(Color.RED);
					}
					
					if(num==3) 
					{
						tglbtnNewToggleButton_1.setText(s3);
						tglbtnNewToggleButton_1.setBackground(Color.GREEN);
					}
					else if(num==4) 
					{
						tglbtnNewToggleButton_1.setText(s4);
						tglbtnNewToggleButton_1.setBackground(Color.RED);
					}
					if(num==5)
					{
						tglbtnNewToggleButton_2.setText(s5);
						tglbtnNewToggleButton_2.setBackground(Color.GREEN);
					}
					else if(num==6)
					{
						tglbtnNewToggleButton_2.setText(s6);
						tglbtnNewToggleButton_2.setBackground(Color.RED);
					
					
					}
					
					if(num==7)
					{
						tglbtnNewToggleButton_3.setText(s7);
						tglbtnNewToggleButton_3.setBackground(Color.GREEN);
					}
					else if(num==8) 
					{
						tglbtnNewToggleButton_3.setText(s8);
						tglbtnNewToggleButton_3.setBackground(Color.RED);
					}
					
					}
					 
		catch(Exception E)
		
		{
			
		}
				
				
				}
			}
		);
		btnNewButton.setBounds(407, 37, 121, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblTemperature = new JLabel("Temperature ");
		lblTemperature.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTemperature.setBounds(254, 99, 115, 23);
		frame.getContentPane().add(lblTemperature);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textField_1.setBounds(362, 101, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Humidity");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(254, 143, 77, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Humidity");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(254, 143, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_2.setBounds(362, 141, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pressure");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(254, 189, 63, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_3.setBounds(362, 189, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setBounds(511, 101, 77, 20);
		frame.getContentPane().add(comboBox);
		
		
	}
	}
