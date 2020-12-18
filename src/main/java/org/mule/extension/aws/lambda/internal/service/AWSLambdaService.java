package org.mule.extension.aws.lambda.internal.service;

import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ListFunctionsRequest;
import com.amazonaws.services.lambda.model.ListFunctionsResult;
import org.mule.connectors.commons.template.service.ConnectorService;

public interface AWSLambdaService extends ConnectorService{

    ListFunctionsResult listFunctions(ListFunctionsRequest request);

    InvokeResult invokeRequest(InvokeRequest request);

}
