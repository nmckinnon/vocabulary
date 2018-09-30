package com.nmckinnon.vocabulary.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Tests the {@code VocabularyController} class.
 * 
 * @author neilmckinnon
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = VocabularyController.class, secure = false)
public class VocabularyControllerTest 
{
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testGetSuccess() throws Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vocabulary/v1/random")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        /*JSONObject jsonResponse = new JSONObject(response.getContentAsString());

        assertNotNull(jsonResponse.getString("name"));
        assertNotNull(jsonResponse.getString("meaning"));
        assertNotNull(jsonResponse.getString("pronunciation"));
        assertNotNull(jsonResponse.getString("etymology"));
        assertNotNull(jsonResponse.getString("example"));*/
    }
}
