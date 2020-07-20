package org.mule.extension.aws.lambda.internal.connection;

import org.mule.extension.aws.lambda.internal.service.AWSLambdaClient;

public final class AWSLambdaConnection {

  private AWSLambdaClient awsLambdaClient;

  public AWSLambdaConnection(AWSLambdaClient awsLambdaClient) {
    this.awsLambdaClient = awsLambdaClient;
  }

  public AWSLambdaClient getAWSLambdaClient() {
    return awsLambdaClient;
  }

  public void invalidate() {
	  awsLambdaClient.getAWSLambdaClient().shutdown();
  }
}
