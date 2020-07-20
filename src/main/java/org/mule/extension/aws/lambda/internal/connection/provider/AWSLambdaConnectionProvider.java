package org.mule.extension.aws.lambda.internal.connection.provider;

import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.api.connection.PoolingConnectionProvider;
import org.mule.extension.aws.lambda.internal.connection.AWSLambdaConnection;
import org.mule.extension.aws.lambda.internal.service.AWSLambdaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;

public class AWSLambdaConnectionProvider implements PoolingConnectionProvider<AWSLambdaConnection> {

	private final Logger LOGGER = LoggerFactory.getLogger(AWSLambdaConnectionProvider.class);

	@Parameter
	private String accessKey;

	@Parameter
	private String secretKey;

	@Parameter
	private String region;

	public String getAccessKey() {
		return accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public String getRegion() {
		return region;
	}

	@Override
	public AWSLambdaConnection connect() throws ConnectionException {
		
		AWSLambda awsLambdaClient = null;
    	BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
    	awsLambdaClient = AWSLambdaClientBuilder.standard().withRegion(region).withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
    	
		return new AWSLambdaConnection(new AWSLambdaClient(awsLambdaClient));

	}

	@Override
	public void disconnect(AWSLambdaConnection connection) {
		try {
			connection.invalidate();
		} catch (Exception e) {
			LOGGER.error("Error while disconnecting: " + e.getMessage(), e);
		}
	}

	@Override
	public ConnectionValidationResult validate(AWSLambdaConnection connection) {
		return ConnectionValidationResult.success();
	}
}
