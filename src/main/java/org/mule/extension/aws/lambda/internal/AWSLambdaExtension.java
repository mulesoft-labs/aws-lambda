package org.mule.extension.aws.lambda.internal;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.extension.aws.lambda.internal.config.AWSLambdaConfiguration;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;

@Xml(prefix = "aws-lambda")
@Extension(name = "AWS Lambda")
@Configurations(AWSLambdaConfiguration.class)
public class AWSLambdaExtension {

}
