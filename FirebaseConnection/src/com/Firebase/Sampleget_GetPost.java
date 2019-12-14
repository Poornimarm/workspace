package com.Firebase;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;

import java.io.OutputStreamWriter;

public class Sampleget_GetPost {

	public static void main(String[] args) throws IOException {

		Sampleget_GetPost.MyGETRequest();
		Sampleget_GetPost.MyPOSTRequest();

	}

	public static void MyGETRequest() throws IOException {
		URL urlForGetRequest = new URL("https://desktop-application-f68b7.firebaseio.com/.json");
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		//conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
		int responseCode = conection.getResponseCode();
		System.out.println("Get Response Code :  " + responseCode);
		System.out.println(" Response Message : " + conection.getResponseMessage());
	if (responseCode == HttpURLConnection.HTTP_OK) {
	BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
		StringBuffer response = new StringBuffer();
		while ((readLine = in.readLine()) != null) {
			response.append(readLine);
			}
		in.close();
			// print result
			 System.out.println("JSON String Result " + response.toString());
			//System.out.println(response.toString());
			System.out.println("Get process sucess");
		} else {
			System.out.println("GET NOT WORKED");
		}

	}

	public static void MyPOSTRequest()throws IOException {

		
			
			
			  final String POST_PARAMS =  "{\n" + "  \"userid \": 100, \r\n"
			  +	  " \"Door\": \"\",\r\n"
			 +   " \"Company\": \"Xolcano Technology\",\r\n" 
			 +   " \"Name\": \"Poornima\"" +  "\n }";
			 
			
			
			//String POST_PARAMS = "{username}";
			System.out.println(POST_PARAMS);
			URL obj = new URL("https://desktop-application-f68b7.firebaseio.com/post.json ");
			HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
			postConnection.setRequestProperty("userId", "a1bcdefgh");
			postConnection.setRequestProperty("Content-Type", "application/json");
			postConnection.setDoOutput(true);
			OutputStream os = postConnection.getOutputStream();
			os.write(POST_PARAMS.getBytes());
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
