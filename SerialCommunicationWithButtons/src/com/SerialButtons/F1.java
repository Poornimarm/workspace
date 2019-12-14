package com.SerialButtons;

public class F1 {
	public static void main (String args[])
	{
		String s="0c";
		System.out.println(s.substring(0, 2));
	//	System.out.println(s.substring(2, 4));
		int decimal=Integer.parseInt(s, 16);
		System.out.println(decimal);
		
		
	}

}
