package org.mule.extension.aws.lambda.internal.operations;

import static org.mule.runtime.extension.api.annotation.param.Optional.PAYLOAD;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.apache.commons.io.IOUtils;
import org.mule.extension.aws.lambda.internal.connection.AWSLambdaConnection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ListFunctionsRequest;
import com.amazonaws.services.lambda.model.ListFunctionsResult;

import org.mule.runtime.extension.api.annotation.param.Connection;

public class AWSLambdaOperations {

	/**
	 * List available Lambda functions processor
	 *
	 * @return ListFunctionsResult of Lambda functions
	 */
	@DisplayName("List Lambda Functions")
	public ListFunctionsResult listFunctions(@Connection AWSLambdaConnection awsLambdaConnection) {

		ListFunctionsRequest request = new ListFunctionsRequest();
		ListFunctionsResult response = awsLambdaConnection.getAWSLambdaClient().getAWSLambdaClient()
				.listFunctions(request);

		return response;
	}

	/**
	 * Call Lambda function processor
	 *
	 * @param functionName Name of the function to execute in Lambda.
	 * @param content      Content to pass to lambda function in JSON
	 * @return String of JSON response from AWS Lambda
	 */
	@DisplayName("Call Lambda Function")
	@MediaType(value = MediaType.APPLICATION_JSON, strict = false)
	public String callFunction(@Connection AWSLambdaConnection awsLambdaConnection, String functionName,
			@Optional(defaultValue = PAYLOAD) InputStream content) {

		InvokeRequest request = new InvokeRequest();
		//request.withFunctionName(functionName).withPayload(content.toString());
		try {
			request.withFunctionName(functionName).withPayload(ByteBuffer.wrap(IOUtils.toByteArray(content)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		InvokeResult invokeResult = null;

		try {
			invokeResult = awsLambdaConnection.getAWSLambdaClient().getAWSLambdaClient().invoke(request);
		} catch (Exception e) {
			System.out.println(e);
		}

		String rawJson = null;

		if (invokeResult.getStatusCode() == 200) {
			ByteBuffer byteBuffer = invokeResult.getPayload();

			try {
				rawJson = new String(byteBuffer.array(), "UTF-8");
			} catch (Exception e) {

			}
		} else {
			rawJson = "{ " + " \"Status\": \"Unable to call Lambda\",\n" + " }";
		}

		return rawJson;
	}
}
