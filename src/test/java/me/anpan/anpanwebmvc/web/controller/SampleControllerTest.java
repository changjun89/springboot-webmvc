package me.anpan.anpanwebmvc.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTestGet() throws Exception {
        mockMvc.perform(get("/hello/changjun"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello changjun"));
    }

    @Test
    public void hiTest() throws Exception {
        mockMvc.perform(get("/hi.json"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


}