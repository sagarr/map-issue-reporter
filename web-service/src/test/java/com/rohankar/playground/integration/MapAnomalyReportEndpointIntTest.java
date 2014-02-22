package com.rohankar.playground.integration;

import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import spring.config.TestConfig;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Sagar Rohankar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfig.class})
public class MapAnomalyReportEndpointIntTest {

    @Autowired
    private WebApplicationContext context;

    @BeforeClass
    public static void setup() throws IllegalStateException, NamingException {
        final SimpleNamingContextBuilder context = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
        context.bind("java:comp/env/report/db/driverClass", "org.hsqldb.jdbc.JDBCDriver");
        context.bind("java:comp/env/report/db/url", "jdbc:hsqldb:mem:reportdb;shutdown=false");
        context.bind("java:comp/env/report/db/user", "sa");
        context.bind("java:comp/env/report/db/password", "");
        context.bind("java:comp/env/report/db/schema", "report");
        context.activate();
    }

    @Test
    public void testGetReports() throws Exception {
        MockMvcBuilders.webAppContextSetup(context).build() //
            .perform(get("/reports")) //
            .andDo(print()) //
            .andExpect(status().isOk()) //
            .andExpect(content().contentType("application/json;charset=UTF-8")) //
            .andExpect(jsonPath("$[0].id").value(1)); // TODO assert other values
    }
}
