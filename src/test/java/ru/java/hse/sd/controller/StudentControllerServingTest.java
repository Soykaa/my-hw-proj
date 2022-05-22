package ru.java.hse.sd.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = StudentHtmlController.class)
public class StudentControllerServingTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homeworks() throws Exception {
        mockMvc.perform(get("/student/homeworks"))
                .andExpect(content().string(containsString("test-homework-id")));
    }

    @Test
    public void welcome() throws Exception {
        mockMvc.perform(get("/student/welcome"))
                .andExpect(content().string(containsString("Hello, Student!")));
    }

    @Test
    public void results() throws Exception {
        mockMvc.perform(get("/student/results"))
                .andExpect(content().string(containsString("look attempt")));
    }

    @Test
    public void oneResult() throws Exception {
        mockMvc.perform(get("/student/results/0"))
                .andExpect(content().string(containsString("Homework:")));
    }
}