package com.example.connectedcities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class ConnectedCitiesTest extends ConnectedcitiesApplicationTests{

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void connectedCitiesTest() throws Exception {
    String origin="Boston",destination = "Newark";
    String origin1="Philadelphia",destination1 = "Albany";
    Path path1 = new Path(origin,destination);
    Path path2 = new Path(origin1,destination1);

    MvcResult response = mockMvc.perform(get("/connected")
                            .param("origin","Boston").param("destination","Newark"))
                                .andReturn();

    Assert.assertEquals(HttpStatus.OK.value(),response.getResponse().getStatus());
    Assert.assertEquals("yes",path1.getPath(origin,destination));
    Assert.assertEquals("no",path2.getPath(origin1,destination1));
    }
}
