package com.amazonaws.lambda.invokeemployee.lambda.service;

import com.amazonaws.lambda.invokeemployee.Employee;
import com.amazonaws.lambda.invokeemployee.MyAppResponse;
import com.amazonaws.services.lambda.invoke.LambdaFunction;

public interface InvokeEmployeeService {
	@LambdaFunction(functionName = "CreateEmployee")
	public MyAppResponse invokeCreateEmployee(Employee emp);
	
	@LambdaFunction(functionName="FirstLambdaValtech")
	public String invokeOtherRegionLambda(String input);
}
