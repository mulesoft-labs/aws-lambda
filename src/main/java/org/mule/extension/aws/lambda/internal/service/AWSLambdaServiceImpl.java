package org.mule.extension.aws.lambda.internal.service;

import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ListFunctionsRequest;
import com.amazonaws.services.lambda.model.ListFunctionsResult;
import org.mule.connectors.commons.template.service.DefaultConnectorService;
import org.mule.extension.aws.lambda.internal.config.AWSLambdaConfiguration;
import org.mule.extension.aws.lambda.internal.connection.AWSLambdaConnection;

public class AWSLambdaServiceImpl extends DefaultConnectorService<AWSLambdaConfiguration, AWSLambdaConnection> implements AWSLambdaService {
    public AWSLambdaServiceImpl(AWSLambdaConfiguration config, AWSLambdaConnection connection) {
        super(config, connection);
    }

    @Override
    public ListFunctionsResult listFunctions(ListFunctionsRequest request) {
        return getConnection().listFunctions(request);
    }

    @Override
    public InvokeResult invokeRequest(InvokeRequest request) {
        return getConnection().invokeRequest(request);
    }

}
