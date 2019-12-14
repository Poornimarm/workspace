package com.serial;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestButtons {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestButtons window = new TestButtons();
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
	public TestButtons() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JToggleButton tglbtnOn = new JToggleButton("LED");
		tglbtnOn.setBackground(Color.WHITE);
		tglbtnOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				//post cde
				try
				{
				
					//String 	POST_PARAMS=tglbtnOn.getText().toString();

				 	//String s1="{\n"  +   " \"tglbtnOn\"" + "\n }";
						
					String s1	="{\n" + "  \"userid :\""  +  "\r\n }";
				if(tglbtnOn.isSelected()) {
					
				
			     tglbtnOn.setText("LED ON");
					tglbtnOn.setBackground(Color.GREEN);
				}else {
					tglbtnOn.setBackground(Color.RED);
					tglbtnOn.setText("LED OFF");
				}
				
				System.out.println(tglbtnOn);
				URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/post.json ");
				HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
				postConnection.setRequestMethod("POST");
				postConnection.setRequestProperty("userId", "a1bcdefgh");
				postConnection.setRequestProperty("Content-Type", "application/json");
				postConnection.setDoOutput(true);
			//	POST_PARAMS=tglbtnOn.getText().toString();
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
				catch(Exception E)
				{
					System.out.println("POST NOT WORKED");
			}
				
			}
		});
		tglbtnOn.setBounds(145, 71, 121, 23);
		frame.getContentPane().add(tglbtnOn);
	}
}
