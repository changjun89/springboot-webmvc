package me.anpan.anpanwebmvc.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PracticeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void events() throws Exception {
        this.mockMvc.perform(get("/events")).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void events2() throws Exception {
        this.mockMvc.perform(get("/events/1")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/events/2")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/events/3")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void events3() throws Exception {
        this.mockMvc.perform(post("/events")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andDo(print());
    }


    @Test
    public void events4() throws Exception {
        this.mockMvc.perform(delete("/events/1")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(delete("/events/2")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(delete("/events/3")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void events5() throws Exception {
        this.mockMvc.perform(put("/events")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andDo(print());
    }

}