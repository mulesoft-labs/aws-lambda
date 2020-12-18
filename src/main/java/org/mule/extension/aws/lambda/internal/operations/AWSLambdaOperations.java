package org.mule.extension.aws.lambda.internal.operations;

import org.mule.connectors.atlantic.commons.builder.lambda.function.BiFunction;
import org.mule.extension.aws.commons.internal.operation.AWSOperations;
import org.mule.extension.aws.lambda.internal.config.AWSLambdaConfiguration;
import org.mule.extension.aws.lambda.internal.connection.AWSLambdaConnection;
import org.mule.extension.aws.lambda.internal.service.AWSLambdaService;

public class AWSLambdaOperations extends AWSOperations<AWSLambdaConfiguration, AWSLambdaConnection, AWSLambdaService>{

	protected static final String DEFAULT_CANNED_ACL = "PRIVATE";
	protected static final String NOT_ENCODED = "NOT_ENCODED";
	public static final String REGION_DEFAULT = "US_STANDARD";

	public AWSLambdaOperations(BiFunction<AWSLambdaConfiguration, AWSLambdaConnection, AWSLambdaService> serviceConstructor) {
		super(serviceConstructor);
	}
}
