package com.Firebase;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.OutputStream;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjrctFirebase extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ProjrctFirebase.MyGETRequest();
		ProjrctFirebase.MyPOSTRequest();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjrctFirebase frame = new ProjrctFirebase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void MyPOSTRequest() {
		
		
		String s1="{\n"  +   " \"LED Status\" : 90 " + " \r\n }";
		
		 
		
		
		
		
		URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/post.json ");
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		
		postConnection.setRequestProperty("Content-Type", "application/json");
		postConnection.setDoOutput(true);
		OutputStream os = (OutputStream) postConnection.getOutputStream();
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

		
}

	private static void MyGETRequest() {
		
		
	}

	/**
	 * Create the frame.
	 */
	public ProjrctFirebase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(187, 56, 144, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
