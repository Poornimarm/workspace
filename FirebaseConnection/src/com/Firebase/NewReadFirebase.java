package com.Firebase;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class NewReadFirebase extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		NewReadFirebase.MyGETRequest();
		//NewReadFirebase.MyPOSTRequest();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewReadFirebase frame = new NewReadFirebase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	

	private static void MyGETRequest() {
		try
		{
		URL urlForGetRequest = new URL("https://desktop-application-f68b7.firebaseio.com/desktop-application-f68b7.json");
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		//conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
		int responseCode = conection.getResponseCode();
		System.out.println("Get Response Code :  " + responseCode);
		System.out.println(" Response Message : " + conection.getResponseMessage());
	if (responseCode == HttpURLConnection.HTTP_OK) {
	BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
		StringBuffer response = new StringBuffer();
		while ((readLine = in.readLine()) != null) {
			response.append(readLine);
			}
		in.close();
			// print result
			 System.out.println("JSON String Result " + response.toString());
			//System.out.println(response.toString());
			System.out.println("Get process sucess");
		} 
		}
	catch(Exception E){
			System.out.println("GET NOT WORKED");
		}

	
		
	
	}



	
	public NewReadFirebase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(152, 40, 192, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 107, 192, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
