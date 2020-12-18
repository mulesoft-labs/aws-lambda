package org.mule.extension.aws.lambda.internal.error;

import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

public enum AWSLambdaErrorType implements ErrorTypeDefinition<AWSLambdaErrorType> {
    UNKNOWN,
    VALIDATION_EXCEPTION
}
