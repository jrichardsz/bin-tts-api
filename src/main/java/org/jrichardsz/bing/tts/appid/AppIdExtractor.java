package org.jrichardsz.bing.tts.appid;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class AppIdExtractor{
	
	public String getAppId(String urlAppId) throws Exception{
		//we need something like_
		//http://www.bing.com/translator/dynamic/223578/js/LandingPage.js
		//this number 223578 could be random :)

		String randomNumber = getRandomNumber();
		
		urlAppId = urlAppId.replace("{random_number}",randomNumber);
		
		String javascriptString = getResponseFromHttpRequest(urlAppId);
		//in this string we have something like ......,appId:"TrZXexIsY2yf-Myq4_ftfQZinGsk*"....
		//but we need only de value of appId.
		//regex to our rescue
		Pattern pattern = Pattern.compile("appId:\"[^\"]+\"");
		Matcher matcher = pattern.matcher(javascriptString);
		
		if(matcher.find()){
			return cleanResultRegex(matcher.group());
		}else {
			throw new Exception("Failed to get appId in order to perform the tts request.");
		}
		
	}
	
	public String cleanResultRegex(String resultRegex){
		//input    : appId:"TlY_EyuNwupsI_6g7f_1KBez21xFZHnBWALbYceoAo8s*"
		//expected : TlY_EyuNwupsI_6g7f_1KBez21xFZHnBWALbYceoAo8s*
		return resultRegex.replace("appId:\"","").replace("\"","");
	}

	public String getRandomNumber(){
		
		Random rnd = new Random();
		int min = 1000000;
		int max = 9999999;
		int n = min + rnd.nextInt(max);
		
		return ""+n;
	}
	
	public String getResponseFromHttpRequest(String urlString)
			throws Exception {

		StringBuilder result = new StringBuilder();

		try{
			
			URL url = new URL(urlString);
			URLConnection urlConn = url.openConnection();
			urlConn.addRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
	        Reader reader = new InputStreamReader(urlConn.getInputStream(),"utf-8");
	        BufferedReader br = new BufferedReader(reader);
			int byteRead;
			while ((byteRead = br.read()) != -1){
			         result.append((char) byteRead);
			}
			
		}catch(Exception exception){
			throw new Exception("Failed to get response in order to extract appId.",exception);
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(new AppIdExtractor().getAppId("http://www.bing.com/translator/dynamic/{random_number}/js/LandingPage.js"));
	}
	

}
