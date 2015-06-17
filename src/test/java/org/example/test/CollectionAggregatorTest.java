package org.example.test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

public class CollectionAggregatorTest extends FunctionalTestCase {

	@Override
	protected String getConfigResources() {
		return "mule-collection-aggregator-example.xml";
	}

	// this is an example of how to crate junit tests in mule and use the mule
	// client to send and receive messages from a flow and perofm assertions
	@Test
	public void testFoo() throws Exception {
		
		MuleClient client = new MuleClient(muleContext);
		
		String payload = "foo";
		Map<String, Object> properties = null;
		
		for (int i = 0; i < 3; i++) {
			client.dispatch("vm://in", payload, properties);
		}

		MuleMessage result = client.request("vm://out", 5000);
		assertNotNull(result);
		//assertEquals("foo Received", result.getPayloadAsString());

	}

}
