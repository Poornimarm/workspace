package com.Firebase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;




import org.json.JSONObject;
public class Http_Get {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Http_Get.call_me();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		}

	private static void call_me()throws Exception {
		 String url = "https://desktop-application-f68b7.firebaseio.com/.json";
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    // // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     
	     //con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	    // System.out.println("\nSending 'GET' request to URL : " + url);
	    System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	}
	     //print in String
	       System.out.println(response.toString());
	        
	        //Read JSON response and print
	       // JSONObject myResponse = new JSONObject(response.toString());
	        //System.out.println("result after Reading JSON Response");
	        
	        
	        
	        
	  
	         
		    }
	     
}

