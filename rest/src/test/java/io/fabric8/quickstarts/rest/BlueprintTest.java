package io.fabric8.quickstarts.rest;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Test;

/**
 * Created by pavlyukevich on 09.12.2015.
 */
public class BlueprintTest extends CamelBlueprintTestSupport {

    @Override
    protected String getBlueprintDescriptor() {
        return "/OSGI-INF/blueprint/blueprint.xml";
    }

    @Test
    public void endpontTest(){
        String n = "1";
    }
}
