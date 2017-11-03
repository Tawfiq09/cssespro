package com.csse.admin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpMessaheHandler {

	public static void httpService(String serviceType,String payload,final String url) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = null;
		BufferedReader rd = null;
		StringBuffer result = null;
		String line = "";;
		
		switch(serviceType) {
		case "GET":
			
			HttpGet request = new HttpGet(url);
			response = client.execute(request);

			System.out.println("Response Code : " +
	                       response.getStatusLine().getStatusCode());

			rd = new BufferedReader(
	                       new InputStreamReader(response.getEntity().getContent()));

			result = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			System.out.println(result.toString());
			break;
			
		case "POST":
			
			HttpPost post = new HttpPost(url);
			StringEntity requestEntity = new StringEntity(payload.trim(), ContentType.APPLICATION_JSON);
			post.setEntity(requestEntity);
			
			response = client.execute(post);
			//System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + post.getEntity());
			System.out.println("Response Code : " +
	                                    response.getStatusLine().getStatusCode());

			rd = new BufferedReader(
	                        new InputStreamReader(response.getEntity().getContent()));

			result = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			System.out.println(result.toString());
			break;
		}

		

	}
	
}
