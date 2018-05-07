package com.JoseK.TestSpider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpiderURL {
	
	
	public static String getURLContext(String urlString) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlString);
			InputStream  is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String temp = "";
			while ((temp=br.readLine()) != null) {
				sb.append(temp);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return sb.toString();
	}
	
	public static void main(String[] args) {
	
			
			String str = getURLContext("http://study.163.com/");					
			Pattern pattern = Pattern.compile("href=\"([\\w./:]+)\"");
			Matcher matcher = pattern.matcher(str);
			while (matcher.find()) {
				System.out.println(matcher.group());
			}	
		}
}
