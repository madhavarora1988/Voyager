package com.madhav.voyager.controllers;


import com.google.common.io.Resources;
import com.madhav.voyager.VoyagerApplication;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = VoyagerApplication.class)
public class CrewControllerTest {

    @Autowired
    protected MockMvc mvc;

    @SneakyThrows
    @Test
    void getCustomersWhenValidRequest_mustRespondWith200() {

        String file = "successful";
        String path = "get-crew";
        String url = "/crew";
        this.mvc.perform(MockMvcRequestBuilders
                .get(url, new Object[0])
                .headers(this.getHeaders())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(this.checkJSON(this.getOutputFile(path, file), false));

    }

    private String getOutputFile(String path, String file) {
        return "data/" + path + "/output/" + file + "-response.json";
    }

    protected HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        return httpHeaders;
    }

    private ResultMatcher checkJSON(String fileName, boolean strict) {

        return MockMvcResultMatchers.content().json(this.getJSONAsString(fileName), strict);
    }

    protected String getJSONAsString(String fileName) {
        try {
            URL url = Resources.getResource(fileName);
            return Resources.toString(url, StandardCharsets.UTF_8);
        } catch (IOException e) {

        }
        return null;
    }

}
