package org.mule.extension.aws.lambda.internal.operations;

import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ListFunctionsRequest;
import com.amazonaws.services.lambda.model.ListFunctionsResult;
import org.apache.commons.io.IOUtils;
import org.mule.extension.aws.lambda.internal.config.AWSLambdaConfiguration;
import org.mule.extension.aws.lambda.internal.connection.AWSLambdaConnection;
import org.mule.extension.aws.lambda.internal.error.provider.AWSLambdaErrorTypeProvider;
import org.mule.extension.aws.lambda.internal.service.AWSLambdaService;
import org.mule.extension.aws.lambda.internal.service.AWSLambdaServiceImpl;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import static org.mule.runtime.extension.api.annotation.param.Optional.PAYLOAD;

public class FunctionsOperations extends AWSLambdaOperations{

    public FunctionsOperations(){
        super(AWSLambdaServiceImpl::new);
    }

    /**
     * List available Lambda functions processor
     *
     * @return ListFunctionsResult of Lambda functions
     */
    @Throws(AWSLambdaErrorTypeProvider.class)
    @DisplayName("List Lambda Functions")
    public ListFunctionsResult listFunctions(@Config AWSLambdaConfiguration config,
                                             @Connection AWSLambdaConnection connection) {
        ListFunctionsRequest request = new ListFunctionsRequest();
        return newExecutionBuilder(config,connection).execute(AWSLambdaService::listFunctions).withParam(request);
    }


    /**
     * Call Lambda function processor
     *
     * @param functionName Name of the function to execute in Lambda.
     * @param content      Content to pass to lambda function in JSON
     * @return String of JSON response from AWS Lambda
     */
    @DisplayName("Call Lambda Function")
    @MediaType(value = MediaType.APPLICATION_JSON, strict = false)
    public String callFunction(@Config AWSLambdaConfiguration config,
                               @Connection AWSLambdaConnection connection,
                               String functionName,
                               @Optional(defaultValue = PAYLOAD) InputStream content) {

        InvokeRequest request = new InvokeRequest();
        try {
            request.withFunctionName(functionName).withPayload(ByteBuffer.wrap(IOUtils.toByteArray(content)));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        InvokeResult invokeResult = newExecutionBuilder(config,connection).execute(AWSLambdaService::invokeRequest).withParam(request);

        String rawJson = null;
        if (invokeResult.getStatusCode() == 200) {
            ByteBuffer byteBuffer = invokeResult.getPayload();

            try {
                rawJson = new String(byteBuffer.array(), "UTF-8");
            } catch (Exception e) {

            }
        } else {
            rawJson = "{ " + " \"Status\": \"Unable to call Lambda\",\n" + " }";
        }
        return rawJson;
    }
}
