package org.mule.extension.aws.lambda.internal.connection.provider;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaAsync;
import com.amazonaws.services.lambda.AWSLambdaAsyncClientBuilder;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import org.mule.extension.aws.commons.internal.connection.AWSConnection;
import org.mule.extension.aws.commons.internal.connection.provider.BasicConnectionProvider;

import java.util.function.BiFunction;

public class ParentAssumeRoleConnectionProvider<CONNECTION extends AWSConnection<AWSLambda, AWSLambdaAsync>> extends BasicConnectionProvider<AWSLambda, AWSLambdaAsync, AWSLambdaClientBuilder, AWSLambdaAsyncClientBuilder, CONNECTION> {
    public ParentAssumeRoleConnectionProvider(BiFunction<AWSLambda, AWSLambdaAsync, CONNECTION> connectionConstructor) {
        super(connectionConstructor, AWSLambdaClientBuilder.standard(), AWSLambdaAsyncClientBuilder.standard());
    }
}
