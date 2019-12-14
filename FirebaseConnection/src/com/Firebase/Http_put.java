package com.Firebase;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http_put {
	public static void main(String args[])
	{
	
	
	try {
		Http_put.call_me();
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	}

	private static void call_me()throws Exception
	{	
	URL url = new URL("https://desktop-application-f68b7.firebaseio.com/.json");
	HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
	httpCon.setDoOutput(true);
	httpCon.setRequestMethod("PUT");
	OutputStreamWriter out = new OutputStreamWriter( httpCon.getOutputStream());
	out.write("Resource content");
	out.close();
	httpCon.getInputStream();
	}
}
