package com.Firebase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.ActionEvent;

public class ReadData extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public  String S1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadData frame = new ReadData();
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
	public ReadData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Read Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					 String url = "https://desktop-application-f68b7.firebaseio.com/temperature.json";
					 
				     URL obj = new URL(url);
				     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				   
				     con.setRequestMethod("GET");
				     con.setRequestProperty("Content-Type", "application/json");
				     con.setDoOutput(true);
					
				  
				     int responseCode = con.getResponseCode();
				    
				    System.out.println(" Get Response Code : " + responseCode);
				     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				     String inputLine;
				     StringBuffer response = new StringBuffer();
				     while ((inputLine = in.readLine()) != null) {
				     	response.append(inputLine);
				}
				     
				       System.out.println(response.toString());
				        
				        String S2=response.toString();
				       
				        textField.setText(S2);
				       
				         
					    }
				catch(Exception E) {
					
				}
				
				try
				{
				
				 String url2 = "https://desktop-application-f68b7.firebaseio.com/pressure.json";
				 
			     URL obj = new URL(url2);
			     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			   
			     con.setRequestMethod("GET");
			     con.setRequestProperty("Content-Type", "application/json");
			     con.setDoOutput(true);
				
			  
			     int responseCode = con.getResponseCode();
			    
			    System.out.println(" Get Response Code : " + responseCode);
			     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			     String inputLine;
			     StringBuffer response = new StringBuffer();
			     while ((inputLine = in.readLine()) != null) {
			     	response.append(inputLine);
			}
			     
			       System.out.println(response.toString());
			        
			        String S3=response.toString();
			       
			        textField_1.setText(S3);
			       
			         
				    }
			catch(Exception E) {
				
			}
			
				try
				{
				
				 String url3 = "https://desktop-application-f68b7.firebaseio.com/humidity.json";
				 
			     URL obj = new URL(url3);
			     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			   
			     con.setRequestMethod("GET");
			     con.setRequestProperty("Content-Type", "application/json");
			     con.setDoOutput(true);
				
			  
			     int responseCode = con.getResponseCode();
			    
			    System.out.println(" Get Response Code : " + responseCode);
			     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			     String inputLine;
			     StringBuffer response = new StringBuffer();
			     while ((inputLine = in.readLine()) != null) {
			     	response.append(inputLine);
			}
			     
			       System.out.println(response.toString());
			        
			        String S4=response.toString();
			       
			        textField_2.setText(S4);
			       
			         
				    }
			catch(Exception E) {
				
			}
				try
				{
				
				 String url4 = "https://desktop-application-f68b7.firebaseio.com/Soil_Moisture.json";
				 
			     URL obj = new URL(url4);
			     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			   
			     con.setRequestMethod("GET");
			     con.setRequestProperty("Content-Type", "application/json");
			     con.setDoOutput(true);
				
			  
			     int responseCode = con.getResponseCode();
			    
			    System.out.println(" Get Response Code : " + responseCode);
			     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			     String inputLine;
			     StringBuffer response = new StringBuffer();
			     while ((inputLine = in.readLine()) != null) {
			     	response.append(inputLine);
			}
			     
			       System.out.println(response.toString());
			        
			        String S5=response.toString();
			       
			        textField_3.setText(S5);
			       
			         
				    }
			catch(Exception E) {
				
			}
			
				
			}
		});
		btnNewButton_1.setBounds(203, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(276, 80, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(276, 120, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(276, 164, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(276, 208, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Temperature");
		lblNewLabel.setBounds(176, 80, 78, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pressure");
		lblNewLabel_1.setBounds(176, 123, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Humudity");
		lblNewLabel_2.setBounds(176, 167, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Soil Moisture");
		lblNewLabel_3.setBounds(176, 211, 78, 14);
		contentPane.add(lblNewLabel_3);
	}
}
