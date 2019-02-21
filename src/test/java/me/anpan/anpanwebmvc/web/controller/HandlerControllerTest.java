package me.anpan.anpanwebmvc.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HandlerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getMember() throws Exception {
        mockMvc.perform(get("/member/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value("1"));
    }


    @Test
    public void getMemberByNme() throws Exception {
        mockMvc.perform(post("/member")
                .param("name", "changjun")
                .param("tall", "-10"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void memberForm() throws Exception {
        mockMvc.perform(get("/member/form"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("member/form"))
                .andExpect(model().attributeExists("member"));
    }


}