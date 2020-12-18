package org.mule.extension.aws.lambda.internal.error.provider;

import org.mule.extension.aws.lambda.internal.error.AWSLambdaErrorType;
import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AWSLambdaErrorTypeProvider implements ErrorTypeProvider {

    @Override
    public Set<ErrorTypeDefinition> getErrorTypes() {
        return Stream.of(AWSLambdaErrorType.values()).collect(Collectors.toSet());
    }
}
