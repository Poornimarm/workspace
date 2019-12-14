package com.Firebase;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http_Delete {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Http_Delete.call_me();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		}
	private static void call_me()throws Exception {
		
		
		
		URL url = new URL(" https://desktop-application-f68b7.firebaseio.com/ .json");
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestProperty(
		                "Content-Type", "application/json");
		httpCon.setRequestMethod("DELETE");
		OutputStreamWriter out = new OutputStreamWriter(
		                httpCon.getOutputStream());
		Object objectMapper = new Object();
		//out.write(objectMapper.writeValueAsString(new Greeting("foo")));
		out.close();
		httpCon.connect();
	}
	}
	
	

