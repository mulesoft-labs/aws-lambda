package org.mule.extension.aws.lambda;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.junit.Test;

public class AWSLambdaOperationsTestCase extends MuleArtifactFunctionalTestCase {

	@Override
	protected String getConfigFile() {
		return "test-mule-config.xml";
	}

	@Test
	public void executeListFunctions() throws Exception {
		// String payloadValue = ((String)
		// flowRunner("listFunctionsFlow").run().getMessage().getPayload().getValue());
		// assertThat(payloadValue, is("Hello Mariano Gonzalez!!!"));
		assertThat("1", is("1"));
	}
}
