package io.fabric8.quickstarts.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * Created by pavlyukevich on 09.12.2015.
 */
public class CXFTest extends Assert{

    private static final String ENDPOINT_ADRESS = "http://localhost:8181/cxf/crm";
    private static Server server;
    public static final String CUSTOMER_TEST_PATH = "/customerservice/customers/123";
    public static final String PRODUCT_ORDER_TEST_PATH = "/customerservice/orders/223/products/323";
    public static final String CUSTOMER_SERVICE_PATH = "/customerservice/customers";
    private static final Logger LOG = LoggerFactory.getLogger(CrmTest.class);

    @Test
    public void getCustomerTest(){

        WebClient client = WebClient.create(ENDPOINT_ADRESS);
        client.accept("media/jpeg");
        client.path(CUSTOMER_TEST_PATH);
        Response response = client.get();
    }

    @Before
    public void startServer() throws Exception{
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(io.fabric8.quickstarts.rest.CustomerService.class);
        sf.setProviders(Arrays.asList(new JacksonJsonProvider(), new JpegProvider()));
        sf.setAddress(ENDPOINT_ADRESS);
        server = sf.create();
    }

    @After
    public void stopServer() throws Exception{
        server.stop();
        server.destroy();
    }
}
