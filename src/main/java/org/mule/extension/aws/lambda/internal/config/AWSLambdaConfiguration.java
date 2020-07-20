package org.mule.extension.aws.lambda.internal.config;

import org.mule.extension.aws.lambda.internal.connection.provider.AWSLambdaConnectionProvider;
import org.mule.extension.aws.lambda.internal.operations.AWSLambdaOperations;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;

@Operations(AWSLambdaOperations.class)
@ConnectionProviders(AWSLambdaConnectionProvider.class)
public class AWSLambdaConfiguration {

}
