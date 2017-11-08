package com.amazonaws.lambda.invokeemployee;

import com.amazonaws.lambda.invokeemployee.lambda.service.InvokeEmployeeService;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class InvokeEmployeeLambda implements RequestHandler<Object, String> {
	
	@Override
	public String handleRequest(Object input, Context context) {
		String API_END_POINT = System.getenv("REST_API_ENDPOINT");
//		AWSLambdaClientBuilder.defaultClient().set
		AWSLambdaClientBuilder standard = AWSLambdaClientBuilder.standard();
		standard.setRegion("us-east-1");
		final InvokeEmployeeService empService = LambdaInvokerFactory.builder()
				.lambdaClient(standard.build()).build(InvokeEmployeeService.class);
//		Employee emp = new Employee();
//		emp.setEmpId(456);
//		emp.setEmail("demo@gmail.com");
//		emp.setEmpName("Demo");
//		MyAppResponse resp = empService.invokeCreateEmployee(emp);
		String resp = empService.invokeOtherRegionLambda("Demo");
		System.out.println("Response From NV "+resp);
		return resp;
	}

}
