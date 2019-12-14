package com.Firebase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

import org.omg.CORBA.portable.InputStream;

public class Http_Authentication {
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		Http_Authentication.MyGAUTHRequest();
		
	}

	
	public static void MyGAUTHRequest() throws IOException {
	
		  try {
	        URL url = new URL ("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyCbW1dYtRBGUAbwpZogmW47m6MTewHjfCw");
	            
	            String encoding = Base64.getEncoder().encodeToString(( "{\n" + "  \"Email \": \"\"\r\n " + " \"Password\" :\"\" r\n" ).getBytes());

	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("POST");
	            connection.setDoOutput(true);
	           connection.setRequestProperty  ("Authorization", "Basic " + encoding);
	            InputStream content = (InputStream)connection.getInputStream();
	            BufferedReader in   = new BufferedReader (new InputStreamReader (content));
	            String line;
	            while ((line = in.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	}
	
}
