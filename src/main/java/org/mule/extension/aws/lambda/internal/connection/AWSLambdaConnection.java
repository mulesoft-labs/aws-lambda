package org.mule.extension.aws.lambda.internal.connection;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaAsync;
import com.amazonaws.services.lambda.model.*;

import org.mule.extension.aws.commons.internal.connection.AWSConnection;
import org.mule.extension.aws.commons.internal.exception.AWSConnectionException;

public class AWSLambdaConnection extends AWSConnection<AWSLambda, AWSLambdaAsync>{

	public AWSLambdaConnection(AWSLambda awsClient, AWSLambdaAsync awsAsyncClient) {
		super(awsClient, awsAsyncClient);
	}

	public ListFunctionsResult listFunctions(ListFunctionsRequest request){
		return getAwsClient().listFunctions(request);
	}

	public InvokeResult invokeRequest(InvokeRequest request){
		return getAwsClient().invoke(request);
	}

	@Override
    public void validate() throws AWSConnectionException {
		try{
			getAwsClient().listFunctions();
		} catch (AWSLambdaException e) {
			throw new AWSConnectionException("An error occurred while trying to validate the connection.", e);
		}
    }
}
