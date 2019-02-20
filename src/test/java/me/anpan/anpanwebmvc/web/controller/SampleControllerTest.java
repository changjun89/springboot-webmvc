package me.anpan.anpanwebmvc.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void helloTestPost() throws Exception {
        mockMvc.perform(post("/hello"))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }


    @Test
    public void helloTestPatch() throws Exception {
        mockMvc.perform(patch("/hello"))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }


}