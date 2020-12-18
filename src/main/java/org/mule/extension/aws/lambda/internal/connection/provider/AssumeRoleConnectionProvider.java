package org.mule.extension.aws.lambda.internal.connection.provider;

import org.mule.extension.aws.lambda.internal.connection.AWSLambdaConnection;
import org.mule.runtime.extension.api.annotation.Alias;

@Alias("role")
public class AssumeRoleConnectionProvider extends ParentAssumeRoleConnectionProvider<AWSLambdaConnection> {

    public AssumeRoleConnectionProvider() {
        super(AWSLambdaConnection::new);
    }
}
