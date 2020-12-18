package org.mule.extension.aws.lambda.internal.operations;

import com.amazonaws.services.lambda.model.ListFunctionsResult;
import org.mule.connectors.atlantic.commons.builder.lambda.function.BiFunction;
import org.mule.extension.aws.commons.internal.operation.AWSOperations;
import org.mule.extension.aws.lambda.internal.config.AWSLambdaConfiguration;
import org.mule.extension.aws.lambda.internal.connection.AWSLambdaConnection;
import org.mule.extension.aws.lambda.internal.error.provider.AWSLambdaErrorTypeProvider;
import org.mule.extension.aws.lambda.internal.service.AWSLambdaService;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

public class AWSLambdaOperations extends AWSOperations<AWSLambdaConfiguration, AWSLambdaConnection, AWSLambdaService>{

	public AWSLambdaOperations(BiFunction<AWSLambdaConfiguration, AWSLambdaConnection, AWSLambdaService> serviceConstructor) {
		super(serviceConstructor);
	}

	/**
	 * List available Lambda functions processor
	 *
	 * @return ListFunctionsResult of Lambda functions
	 */
	@Throws(AWSLambdaErrorTypeProvider.class)
	@DisplayName("List Lambda Functions")
	public ListFunctionsResult listFunctions(@Config AWSLambdaConfiguration config,
											 @Connection AWSLambdaConnection connection) {
		return newExecutionBuilder(config,connection).execute(AWSLambdaService::listFunctions);
	}
	

	/**
	 * Call Lambda function processor
	 *
	 * @param functionName Name of the function to execute in Lambda.
	 * @param content      Content to pass to lambda function in JSON
	 * @return String of JSON response from AWS Lambda
	 */
	/*
	@DisplayName("Call Lambda Function")
	@MediaType(value = MediaType.APPLICATION_JSON, strict = false)
	public String callFunction(@Connection AWSLambdaConnection awsLambdaConnection, String functionName,
			@Optional(defaultValue = PAYLOAD) InputStream content) {

		InvokeRequest request = new InvokeRequest();
		try {
			//request.putCustomQueryParameter("city", "Seattle");
			//request.withFunctionName(functionName).putCustomRequestHeader("day", "Thursday");
			request.withFunctionName(functionName).withPayload(ByteBuffer.wrap(IOUtils.toByteArray(content)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		InvokeResult invokeResult = null;

		try {
			invokeResult = awsLambdaConnection.getAwsClient().getAWSLambdaClient().invoke(request);
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
	*/
}
