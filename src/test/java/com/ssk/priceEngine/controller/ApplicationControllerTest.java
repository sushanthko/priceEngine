package com.ssk.priceEngine.controller;

import com.ssk.priceEngine.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ApplicationController.class)
class ApplicationControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void getHomePage() throws Exception {
        mvc.perform(get("/"))
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }

    @Test
    void calculateTotalPrice() throws Exception {
        mvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"units\": 25, \"unitsPerCarton\": 20, \"cartonPrice\": 175}")
        )
                .andExpect(content().string(Double.toString(231.875)));
    }

    @Test
    void performInvalidPost() throws Exception {
        mvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{units: 25, unitsPerCarton: 20, cartonPrice: 175}")
        )
                .andExpect(status().is(400));
    }

}
