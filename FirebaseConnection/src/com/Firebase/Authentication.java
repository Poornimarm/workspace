package com.Firebase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class Authentication {

	
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentication window = new Authentication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//URL urlForGetRequest = new URL("https://desktop-application-f68b7.firebaseio.com/.json");
	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Authentication()  {
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
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(54, 80, 72, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(54, 129, 72, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(152, 77, 105, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(152, 126, 105, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String uname=textField.getText();
				String pass=passwordField.getText();
				
				if(uname.equals("poornimarm@gmail.com") && pass.equals("poornima"))
					
				{
					JOptionPane.showMessageDialog(frame, "your succefully logined");
				}else
				{
					JOptionPane.showMessageDialog(frame, "your  not succefully logined");
				}
			}
		});
		btnLogin.setBounds(102, 192, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}
