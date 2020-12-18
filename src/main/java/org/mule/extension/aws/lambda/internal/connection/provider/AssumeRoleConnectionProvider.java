package org.mule.extension.aws.lambda.internal.connection.provider;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaAsync;
import com.amazonaws.services.lambda.AWSLambdaAsyncClientBuilder;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import org.mule.extension.aws.lambda.internal.connection.AWSLambdaConnection;
import org.mule.runtime.extension.api.annotation.Alias;

import java.util.function.BiFunction;

@Alias("role")
public class AssumeRoleConnectionProvider extends ParentAssumeRoleConnectionProvider<AWSLambdaConnection> {
    public AssumeRoleConnectionProvider(BiFunction<AWSLambda, AWSLambdaAsync, AWSLambdaConnection> connectionConstructor, AWSLambdaClientBuilder clientBuilder, AWSLambdaAsyncClientBuilder asyncClientBuilder) {
        super(AWSLambdaConnection::new);
    }
}
