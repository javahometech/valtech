package com.amazonaws.lambda.schedulelambda;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ScheduledHandler implements RequestHandler<Object, String> {
	private String API_URI = "https://s3-us-west-2.amazonaws.com/valtech.data/schedule.xml";

	@Override
	public String handleRequest(Object input, Context context) {

		context.getLogger().log("Input: " + input);

		try {
			
			URL url = new URL(API_URI);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");
			
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Employee emp = (Employee) unmarshaller.unmarshal(conn.getInputStream());
			context.getLogger().log(emp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Hello from Lambda!";
	}

}
