package com.amazonaws.lambda.apicalllambda;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LambdaRestAPIFunctionHandler implements RequestHandler<String, Country> {
	private String API_URI = "http://services.groupkt.com/country/get/iso2code/";

	@Override
	public Country handleRequest(String countryCode, Context context) {
		ObjectMapper mapper = new ObjectMapper();
		API_URI = API_URI + countryCode;

		try {
			URL url = new URL(API_URI);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			Country c = mapper.readValue(conn.getInputStream(), Country.class);
				return c;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
