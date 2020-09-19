package com.thoughtworks.capability.gtb.demospringconfig.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class LevelControllerTest {

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        mockMvc.perform(get("/level/"+0))
                .andExpect(jsonPath("$", is(0)));
    }


    @Test
    void shouldReturnBasicWhenGetLevelGivenLevelLessThan1() throws Exception {
        mockMvc.perform(get("/level"))
                .andExpect(jsonPath("$", is("basic")));
    }

    @Test
    void shouldReturnBasicWhenGetLevelGivenLevelEquals1() throws Exception {
        mockMvc.perform(get("/level/"+1))
                .andExpect(jsonPath("$", is(1)));

        mockMvc.perform(get("/level"))
                .andExpect(jsonPath("$", is("advanced")));
    }

    @Test
    void shouldReturnAdvancedWhenGetLevelGivenLevelGreaterThan1() throws Exception {

        mockMvc.perform(get("/level/"+2))
                .andExpect(jsonPath("$", is(2)));

        mockMvc.perform(get("/level"))
                .andExpect(jsonPath("$", is("advanced")));
    }

}
