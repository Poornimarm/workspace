package com.SerialButtons;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class F2 extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private static JTextField textField_5;
	private JLabel lblNewLabel_6;
	private static JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F2 frame = new F2();
					frame.setVisible(true);
					

					String s="FF0C203C800000FF";
					String s2=s.substring(2, 4);
					System.out.println(s2);
				   int decimal=Integer.parseInt(s2,16);
					System.out.println(decimal);
					
					
					String s3=s.substring(4, 6);
			        System.out.println(s3);
					int decimal1=Integer.parseInt(s3,16);
					System.out.println(decimal1);
					
					String s4=s.substring(6, 8);
			        System.out.println(s4);
					int decimal2=Integer.parseInt(s4,16);
					System.out.println(decimal2);
					
					String s5=s.substring(8,10);
					  System.out.println(s5);
					int   decimal4=Integer.parseInt(s5,16);
					String binary1=Integer.toBinaryString(decimal4);
					  System.out.println(binary1);
					
						String s6=s.substring(10,12);
						 System.out.println(s6);
					int   decimal5=Integer.parseInt(s6,16);
					String binary2=Integer.toBinaryString(decimal5);
					 System.out.println(binary2);
					
					String s7=s.substring(12,14);
					 System.out.println(s7);
					int decimal6=Integer.parseInt(s7,16);
					String binary3=Integer.toBinaryString(decimal6);
					 System.out.println(binary3);
					
					 textField.setText(Integer.toString(decimal));
					   
						textField_1.setText(Integer.toString(decimal1));
						textField_2.setText(Integer.toString(decimal2));
						
						textField_3.setText(binary1);
						textField_4.setText(binary2);
						textField_5.setText(binary3);
						
						
						
						
				
						textField_6.setText(s);
						
					
					
					
					/*System.out.println(s.substring(4, 6));
					System.out.println(s.substring(6, 8));
					System.out.println(s);*/
					
				   //int d1=Integer.parseInt( textField.getText());
				 //  textField.setText(Integer.toString(decimal));
				   
				//	textField_1.setText(Integer.toString(decimal1));
					/*textField_2.setText(s.substring(4, 6));
					textField_3.setText(s.substring(6, 8));
					textField_4.setText(s);*/
					
				} catch (Exception e) {
					e.printStackTrace();
					
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public F2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(234, 35, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(234, 92, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Bttery Value");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(52, 37, 80, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Temperature");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(52, 98, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Humidity");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(52, 149, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("10 GPIO Status");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(52, 206, 112, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(234, 147, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(234, 204, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(234, 248, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Unused byte");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(52, 251, 112, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Unused byte");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(52, 289, 93, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(234, 287, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Incoming data");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_6.setBounds(52, 348, 133, 28);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(234, 354, 185, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
	}
}
