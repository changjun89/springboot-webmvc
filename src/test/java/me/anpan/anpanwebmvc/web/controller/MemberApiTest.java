package me.anpan.anpanwebmvc.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.anpan.anpanwebmvc.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MemberApiTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void memberTest() throws  Exception{
        Member member = new Member();
        member.setName("leechangjun1");
        member.setTall(-1);
        String json = objectMapper.writeValueAsString(member);
        mockMvc.perform(post("/api/member")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("leechangjun1"))
                .andExpect(jsonPath("$.tall").value(-1));
    }

}