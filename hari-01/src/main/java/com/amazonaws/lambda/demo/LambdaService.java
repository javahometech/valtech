package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.invoke.LambdaFunction;

public interface LambdaService {

	@LambdaFunction(functionName = "hari-01")
	public String invokeLambda(String input);
}
