package com.Firebase;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TestFirebase extends JFrame {

	public static JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					TestFirebase frame = new TestFirebase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	


	public TestFirebase() {
		
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
	     	  String S3=response.toString();
	     	  
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
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Led1 On");
		btnNewButton.setBackground(new Color(238, 232, 170));
		btnNewButton.setForeground(new Color(139, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Led On.json");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				
			
				postConnection.setRequestMethod("POST");
				
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
				outPut.print(true);
				outPut.flush();
				outPut.close();
				int responseCode = postConnection.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
			}
		
		});
		btnNewButton.setBounds(10, 109, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewBledutton = new JButton("Led1 Off");
		btnNewBledutton.setBackground(new Color(238, 232, 170));
		btnNewBledutton.setForeground(new Color(139, 0, 0));
		btnNewBledutton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewBledutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Led Off.json ");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				
			
			postConnection.setRequestMethod("POST");
				
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
				outPut.print(false);
				outPut.flush();
				outPut.close();
				int responseCode = postConnection.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
			}
			
			
			
		});
		btnNewBledutton.setBounds(117, 109, 102, 23);
		contentPane.add(btnNewBledutton);
		
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTemperature.setForeground(new Color(245, 245, 245));
		lblTemperature.setBounds(279, 96, 110, 30);
		contentPane.add(lblTemperature);
		
		
		JButton btnNewButton_1 = new JButton("Fan On");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Fan On.json");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				
			
				postConnection.setRequestMethod("POST");
				
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
				outPut.print(true);
				outPut.flush();
				outPut.close();
				int responseCode = postConnection.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
			}
		});
		btnNewButton_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1.setBackground(new Color(238, 232, 170));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(10, 143, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fan Off");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Fan Off.json");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				
			
				postConnection.setRequestMethod("POST");
				
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
				outPut.print(true);
				outPut.flush();
				outPut.close();
				int responseCode = postConnection.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
			}
		});
		btnNewButton_2.setForeground(new Color(139, 0, 0));
		btnNewButton_2.setBackground(new Color(238, 232, 170));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2.setBounds(117, 143, 102, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Tv On");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Tv On.json");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				
			
				postConnection.setRequestMethod("POST");
				
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
				outPut.print(true);
				outPut.flush();
				outPut.close();
				int responseCode = postConnection.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
			}
		});
		btnNewButton_3.setBackground(new Color(238, 232, 170));
		btnNewButton_3.setForeground(new Color(139, 0, 0));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_3.setBounds(10, 177, 100, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Tv Off");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Tv Off.json");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				
			
				postConnection.setRequestMethod("POST");
				
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
				outPut.print(true);
				outPut.flush();
				outPut.close();
				int responseCode = postConnection.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
				
			}
		});
		btnNewButton_4.setBackground(new Color(238, 232, 170));
		btnNewButton_4.setForeground(new Color(139, 0, 0));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_4.setBounds(117, 177, 102, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Fridge On");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Fridge On.json");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				
			
				postConnection.setRequestMethod("POST");
				
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
				outPut.print(true);
				outPut.flush();
				outPut.close();
				int responseCode = postConnection.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
			}
			
		});
		btnNewButton_5.setBackground(new Color(238, 232, 170));
		btnNewButton_5.setForeground(new Color(139, 0, 0));
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_5.setBounds(10, 211, 100, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Fridge Off");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Fridge Off.json");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				
			
				postConnection.setRequestMethod("POST");
				
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
				outPut.print(true);
				outPut.flush();
				outPut.close();
				int responseCode = postConnection.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
			}
		});
		btnNewButton_6.setBackground(new Color(238, 232, 170));
		btnNewButton_6.setForeground(new Color(139, 0, 0));
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_6.setBounds(117, 211, 102, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Bulb On");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Bulb On.json");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				
			
				postConnection.setRequestMethod("POST");
				
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
				outPut.print(true);
				outPut.flush();
				outPut.close();
				int responseCode = postConnection.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
			}
		});
		btnNewButton_7.setForeground(new Color(139, 0, 0));
		btnNewButton_7.setBackground(new Color(238, 232, 170));
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_7.setBounds(10, 245, 100, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Bulb Off");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Bulb Off.json");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				
			
				postConnection.setRequestMethod("POST");
				
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
				outPut.print(true);
				outPut.flush();
				outPut.close();
				int responseCode = postConnection.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
			}
		});
		btnNewButton_8.setBackground(new Color(238, 232, 170));
		btnNewButton_8.setForeground(new Color(139, 0, 0));
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_8.setBounds(119, 245, 100, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Led2 On");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Led2 On.json");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				
			
				postConnection.setRequestMethod("POST");
				
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
				outPut.print(true);
				outPut.flush();
				outPut.close();
				int responseCode = postConnection.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
			}
		});
		btnNewButton_9.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_9.setBackground(new Color(238, 232, 170));
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_9.setForeground(new Color(139, 0, 0));
		btnNewButton_9.setBounds(10, 279, 100, 23);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Led2 Off");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/Led2 Off.json");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				
			
				postConnection.setRequestMethod("POST");
				
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(postConnection.getOutputStream());
				outPut.print(true);
				outPut.flush();
				outPut.close();
				int responseCode = postConnection.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
				
			}
		});
		btnNewButton_10.setBackground(new Color(238, 232, 170));
		btnNewButton_10.setForeground(new Color(139, 0, 0));
		btnNewButton_10.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_10.setBounds(119, 279, 100, 23);
		contentPane.add(btnNewButton_10);
		
		JLabel lblNewLabel = new JLabel("Humudity");
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(279, 155, 100, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pressure");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(230, 230, 250));
		lblNewLabel_1.setBounds(276, 206, 88, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Water Moisture");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(230, 230, 250));
		lblNewLabel_2.setBounds(279, 271, 129, 23);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(452, 103, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(452, 158, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(452, 213, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(452, 281, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
