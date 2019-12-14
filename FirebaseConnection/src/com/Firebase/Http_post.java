package com.Firebase;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
//import java.net.URLEncoder;
//import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
//import org.json.JSONObject;
public class Http_post {

	public static void main(String[] args) {
		try {
			 Http_post.call_me();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	 public static void call_me() throws Exception {
		
		 URL url = new URL("https://desktop-application-f68b7.firebaseio.com/.json");
		    Map<String,String> params = new LinkedHashMap<>();
		    params.put("name", "Jinu Jawad");
		    params.put("email", "helloworld@gmail.com");
		 
		    params.put("message", "Hello Post Test success");
		    StringBuilder postData = new StringBuilder();
		   for (Map.Entry<String,String> param : params.entrySet()) {
		      if (postData.length() != 0) postData.append('&');
		       postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
		       postData.append('=');
		       postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
		    }
		   byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		    conn.setRequestMethod("POST");
		    conn.setRequestProperty("Content-Type", "application/json");
		  
		    conn.setDoOutput(true);
		    conn.getOutputStream().write(postDataBytes);
		    Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		    
		
		    
		    StringBuilder sb = new StringBuilder();
		    for (int c; (c = in.read()) >= 0;)
		        sb.append((char)c);
		    String response = sb.toString();
		    System.out.println(response.toString());
		    System.out.println(response);
		    JSONObject myResponse = new JSONObject(response.toString());
		    
		    JSONObject form_data = myResponse.getJSONObject("form");
		  //System.out.println("CODE- " +form_data.getString("CODE"));
		   System.out.println("email- " +form_data.getString("email"));
		  System.out.println("message-" +form_data.getString("message"));
		   System.out.println("name-"    +form_data.getString("name"));
	}

}
