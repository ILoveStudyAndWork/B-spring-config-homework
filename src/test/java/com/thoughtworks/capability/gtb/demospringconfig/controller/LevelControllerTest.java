package com.thoughtworks.capability.gtb.demospringconfig.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private LevelController levelController;


    @Test
    void shouldReturnBasicWhenGetLevelGivenLevelLessThan1() throws Exception {
        levelController.setLevelNumber(0);
        mockMvc.perform(get("/level"))
                .andExpect(jsonPath("$", is("basic")));
    }

    @Test
    void shouldReturnBasicWhenGetLevelGivenLevelEquals1() throws Exception {
        levelController.setLevelNumber(1);
        mockMvc.perform(get("/level"))
                .andExpect(jsonPath("$", is("advanced")));
    }

    @Test
    void shouldReturnAdvancedWhenGetLevelGivenLevelGreaterThan1() throws Exception {
        levelController.setLevelNumber(2);
        mockMvc.perform(get("/level"))
                .andExpect(jsonPath("$", is("advanced")));
    }

}
