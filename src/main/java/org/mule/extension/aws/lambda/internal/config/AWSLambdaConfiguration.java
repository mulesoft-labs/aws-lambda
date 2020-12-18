package org.mule.extension.aws.lambda.internal.config;

import org.mule.extension.aws.commons.internal.config.AWSConfig;
import org.mule.extension.aws.lambda.internal.connection.provider.AssumeRoleConnectionProvider;
import org.mule.extension.aws.lambda.internal.connection.provider.BasicConnectionProvider;
import org.mule.extension.aws.lambda.internal.operations.AWSLambdaOperations;
import org.mule.runtime.extension.api.annotation.Configuration;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

@Configuration(name = "config")
@DisplayName("Configuration")
@Operations({
        AWSLambdaOperations.class
})
@ConnectionProviders({
        BasicConnectionProvider.class,
        AssumeRoleConnectionProvider.class
})
public class AWSLambdaConfiguration extends AWSConfig {

}
