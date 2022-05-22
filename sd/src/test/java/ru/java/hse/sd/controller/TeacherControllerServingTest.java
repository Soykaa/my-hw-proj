package ru.java.hse.sd.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = TeacherHtmlController.class)
public class TeacherControllerServingTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void welcome() throws Exception {
        mockMvc.perform(get("/teacher/welcome"))
                .andExpect(content().string(containsString("Hello, Teacher!")));
    }

    @Test
    public void results() throws Exception {
        mockMvc.perform(get("/teacher/results"))
                .andExpect(content().string(containsString("look attempt")));
    }

    @Test
    public void oneResult() throws Exception {
        mockMvc.perform(get("/teacher/results/0"))
                .andExpect(content().string(containsString("Homework:")));
    }
}
