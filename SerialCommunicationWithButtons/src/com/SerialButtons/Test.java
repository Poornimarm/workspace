package com.SerialButtons;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void display()
	{  
		Thread n1=new Thread()
				{
			public void run()
			{
				try {
					  for(;;)
					  {
					String url1 = "https://desktop-application-f68b7.firebaseio.com/temperature.json";
					 
				     URL obj = new URL(url1);
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
				        
				        String S1=response.toString();
				       
				        textField.setText(S1);
				       
				        
					    }
				}
					
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
				
	};
	n1.start();
	}
	public void display1()
	{
	
	Thread n2=new Thread()
	{
public void run()
{
	try {
		for(;;)
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
	        
	        String S2=response.toString();

		
	       
	        textField_1.setText(S2);
	        
		    }
	}
	
		
	catch (Exception e) {
		e.printStackTrace();
	}
	
}
	
};
n2.start();
	}
	public void display2()
	{
Thread n3=new Thread()
{
public void run()
{
try {
	for(;;)
	{
	String url3 = "https://desktop-application-f68b7.firebaseio.com/Altitude.json";
	 
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
        
        String S3=response.toString();
       
        textField_2.setText(S3);
       
        
	    }
}
	
catch (Exception e) {
	e.printStackTrace();
}

}

};
n3.start();
	
	
	}			
	
	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
		display();
		display1();
		display2();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 528, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(250, 250, 210));
		textField.setBounds(109, 125, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Temperature");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 127, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pressure");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 182, 70, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Altitude");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 245, 70, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(250, 250, 210));
		textField_1.setBounds(109, 180, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(250, 250, 210));
		textField_2.setBounds(109, 243, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Led1 On");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String url4 = "https://desktop-application-f68b7.firebaseio.com/LEDStatus.json";
					 
				     URL obj = new URL(url4);
				     
				     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				     con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(con.getOutputStream());
				outPut.print(1);
				outPut.flush();
				outPut.close();
				int responseCode = con.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
				
				
				
			
			}
		});
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(246, 88, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Led1 Off");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String url4 = "https://desktop-application-f68b7.firebaseio.com/LEDStatus.json";
					 
				     URL obj = new URL(url4);
				     
				     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				     con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(con.getOutputStream());
				outPut.print(0);
				outPut.flush();
				outPut.close();
				int responseCode = con.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(355, 88, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Led2 On");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String url5 = "https://desktop-application-f68b7.firebaseio.com/LEDStatus0.json";
					 
				     URL obj = new URL(url5);
				     
				     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				     con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(con.getOutputStream());
				outPut.print(1);
				outPut.flush();
				outPut.close();
				int responseCode = con.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
				
			}
		});
		btnNewButton_2.setBackground(new Color(34, 139, 34));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_2.setBounds(246, 135, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Led2 Off");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String url5 = "https://desktop-application-f68b7.firebaseio.com/LEDStatus0.json";
					 
				     URL obj = new URL(url5);
				     
				     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				     con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(con.getOutputStream());
				outPut.print(0);
				outPut.flush();
				outPut.close();
				int responseCode = con.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
				
			}
		});
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_3.setBounds(355, 135, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Led3 On");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String url6 = "https://desktop-application-f68b7.firebaseio.com/LEDStatus1.json";
					 
				     URL obj = new URL(url6);
				     
				     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				     con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(con.getOutputStream());
				outPut.print(1);
				outPut.flush();
				outPut.close();
				int responseCode = con.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
				
			}
		});
		btnNewButton_4.setBackground(new Color(34, 139, 34));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_4.setBounds(246, 196, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Led3 Off");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String url6 = "https://desktop-application-f68b7.firebaseio.com/LEDStatus1.json";
					 
				     URL obj = new URL(url6);
				     
				     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				     con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(con.getOutputStream());
				outPut.print(0);
				outPut.flush();
				outPut.close();
				int responseCode = con.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
				
			}
		});
		btnNewButton_5.setBackground(new Color(255, 0, 0));
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_5.setBounds(355, 196, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Led4 On");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String url7 = "https://desktop-application-f68b7.firebaseio.com/LEDStatus3.json";
					 
				     URL obj = new URL(url7);
				     
				     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				     con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(con.getOutputStream());
				outPut.print(1);
				outPut.flush();
				outPut.close();
				int responseCode = con.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
				
			}
		});
		btnNewButton_6.setBackground(new Color(34, 139, 34));
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_6.setBounds(246, 259, 89, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Led4 Off");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String url7 = "https://desktop-application-f68b7.firebaseio.com/LEDStatus3.json";
					 
				     URL obj = new URL(url7);
				     
				     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				     con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setDoOutput(true);
				PrintWriter outPut = new PrintWriter(con.getOutputStream());
				outPut.print(0);
				outPut.flush();
				outPut.close();
				int responseCode = con.getResponseCode();
				System.out.println("POST Response Code :  " + responseCode);
				}
				
				
				
				catch(Exception E)
				{
					System.out.println("POST not done");
				}
				
			}
		});
		btnNewButton_7.setBackground(new Color(255, 0, 0));
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_7.setBounds(355, 259, 89, 23);
		frame.getContentPane().add(btnNewButton_7);
		
		JLabel lblNewLabel_4 = new JLabel("XoLCANO IOT DASH BOARD");
		lblNewLabel_4.setForeground(new Color(255, 192, 203));
		lblNewLabel_4.setBackground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_4.setBounds(76, 22, 426, 41);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
