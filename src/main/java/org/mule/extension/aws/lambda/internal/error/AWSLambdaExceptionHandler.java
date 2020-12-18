package org.mule.extension.aws.lambda.internal.error;

import org.mule.extension.aws.commons.internal.exception.AWSExceptionHandler;

public class AWSLambdaExceptionHandler extends AWSExceptionHandler<AWSLambdaErrorType> {
    public AWSLambdaExceptionHandler() {
        super(AWSLambdaErrorType.class);
    }
}
