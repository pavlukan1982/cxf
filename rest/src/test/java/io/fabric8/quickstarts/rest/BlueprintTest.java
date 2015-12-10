package io.fabric8.quickstarts.rest;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * Created by pavlyukevich on 09.12.2015.
 */
public class BlueprintTest extends CamelBlueprintTestSupport {

    private static final String ENDPOINT_ADRESS = "http://localhost:8181/cxf/crm";
    public static final String CUSTOMER_TEST_PATH = "/customerservice/customers/123";

    @Override
    protected String getBlueprintDescriptor() {
        return "/OSGI-INF/blueprint/blueprint.xml";
    }

    @Test
    public void endpontTest(){

        WebClient client = WebClient.create(ENDPOINT_ADRESS);
        client.accept("media/jpeg");
        client.path(CUSTOMER_TEST_PATH);
//        Response response = client.get();
    }

}
