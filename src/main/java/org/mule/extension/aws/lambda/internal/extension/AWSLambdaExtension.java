package org.mule.extension.aws.lambda.internal.extension;

import org.mule.extension.aws.lambda.internal.error.AWSLambdaErrorType;
import org.mule.extension.aws.lambda.internal.error.AWSLambdaExceptionHandler;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.extension.aws.lambda.internal.config.AWSLambdaConfiguration;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.OnException;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.runtime.extension.api.annotation.error.ErrorTypes;
import org.mule.runtime.extension.api.annotation.license.RequiresEnterpriseLicense;

import static org.mule.runtime.api.meta.Category.SELECT;

@Extension(name = "AWS Lambda", category = SELECT)
@RequiresEnterpriseLicense(allowEvaluationLicense = true)
@Configurations(AWSLambdaConfiguration.class)
@Xml(prefix = "aws-lambda")
@OnException(AWSLambdaExceptionHandler.class)
@ErrorTypes(AWSLambdaErrorType.class)

public class AWSLambdaExtension {

}
