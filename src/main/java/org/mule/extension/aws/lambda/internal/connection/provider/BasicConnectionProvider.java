package org.mule.extension.aws.lambda.internal.connection.provider;

import org.mule.extension.aws.lambda.internal.connection.AWSLambdaConnection;
import org.mule.runtime.extension.api.annotation.Alias;

@Alias("basic")
public class BasicConnectionProvider extends ParentBasicConnectionProvider<AWSLambdaConnection> {

    public BasicConnectionProvider() {
        super(AWSLambdaConnection::new);
    }
}
