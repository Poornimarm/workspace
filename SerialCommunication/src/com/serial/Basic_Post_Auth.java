package com.serial;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class Basic_Post_Auth {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			   String url = "https://desktop-application-f68b7.firebaseio.com/post.json";
			   URL obj = new URL(url);
			   HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			   con.setRequestMethod("POST");
			 
			   String user_name="";
			   String password="";
			 
			   String userCredentials = user_name+":"+password;
			   String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
			   con.setRequestProperty ("Authorization", basicAuth);
			 //  con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:27.0) Gecko/20100101 Firefox/27.0.2 Waterfox/27.0");
			   con.setRequestProperty("Content-Type", "application/json");
			   String urlParameters = "param1=value1&param2=value2";
			   // Send post request
			   con.setDoOutput(true);
			   DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			   wr.writeBytes(urlParameters);
			   wr.flush();
			   wr.close();
			   int responseCode = con.getResponseCode();
			   System.out.println("\nSending 'POST' request to URL : " + url);
			   System.out.println("Post parameters : " + urlParameters);
			   System.out.println("Response Code : " + responseCode);
			   BufferedReader in = new BufferedReader(
			   new InputStreamReader(con.getInputStream()));
			   String inputLine;
			   StringBuffer response = new StringBuffer();
			   while ((inputLine = in.readLine()) != null) {
			    response.append(inputLine);
			   }
			   in.close();
			   //print result
			   System.out.println(response.toString());


			   // below code converts the json response to json object and reads each values
			   JSONObject jsonObj = new JSONObject(response.toString());
			   String access_token =jsonObj.getString("access_token");
			   System.out.println("access_token : "+access_token);
			   } catch (Exception e) {
			    // TODO: handle exception
			   }
			}
			}