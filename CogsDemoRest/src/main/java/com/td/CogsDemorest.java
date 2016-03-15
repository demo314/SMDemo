
package com.td;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class CogsDemorest {

	public static void main(String[] arg){

		try {
			URL url = new URL("http://localhost:8080/business-central/rest/runtime/Cognizant:HumanTask:1.0/process/humanTask.humanTask/start");
			
/*				@SuppressWarnings("unused")
				URL url1 = new URL("http://localhost:8080/business-central/rest/task/query?taskOwner=bpmsAdmin");*/
			
			URL url2 = new URL("http://localhost:8080/business-central/rest/task/5/start");

			String userPassword ="bpmsAdmin:admin123!";
			String encoding = new sun.misc.BASE64Encoder().encode(userPassword.getBytes());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			HttpURLConnection conn1 = (HttpURLConnection) url2.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "Basic " + encoding);
			 
			
			
			
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			
			System.out.println("Process executed successfully..");
			
			System.out.println(conn.getResponseMessage());
			
			System.out.println(conn.getContent().toString());
			System.out.println("hi");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = br.readLine();
			while(line != null){
				System.out.println(line);
				line = br.readLine();
			}
			
			conn.disconnect();
			conn1.disconnect();
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Here you will get JaxbProcessInstanceResponse instance.
	}
}

