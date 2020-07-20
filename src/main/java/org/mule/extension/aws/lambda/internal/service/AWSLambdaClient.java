package org.mule.extension.aws.lambda.internal.service;

import com.amazonaws.services.lambda.AWSLambda;

public class AWSLambdaClient {
	
	private AWSLambda lambda;
	
	public AWSLambdaClient(AWSLambda lambda) {
		super();
		this.lambda = lambda;
	}

	public AWSLambda getAWSLambdaClient() {
		return lambda;
	}

}
