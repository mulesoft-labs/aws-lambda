package org.mule.extension.aws.lambda.internal.connection.provider;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaAsync;
import com.amazonaws.services.lambda.AWSLambdaAsyncClientBuilder;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import org.mule.extension.aws.commons.internal.connection.AWSConnection;
import org.mule.extension.aws.commons.internal.connection.provider.AssumeRoleConnectionProvider;
import org.mule.runtime.extension.api.annotation.Alias;

import java.util.function.BiFunction;

@Alias("role")
public class ParentAssumeRoleConnectionProvider<CONNECTION extends AWSConnection<AWSLambda, AWSLambdaAsync>> extends AssumeRoleConnectionProvider<AWSLambda, AWSLambdaAsync, AWSLambdaClientBuilder, AWSLambdaAsyncClientBuilder, CONNECTION> {

    public ParentAssumeRoleConnectionProvider(BiFunction<AWSLambda, AWSLambdaAsync, CONNECTION> connectionConstructor) {
        super(connectionConstructor, AWSLambdaClientBuilder.standard(), AWSLambdaAsyncClientBuilder.standard());
    }
}
