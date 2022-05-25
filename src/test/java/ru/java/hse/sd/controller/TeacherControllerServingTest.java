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
    public void menu() throws Exception {
        mockMvc.perform(get("/teacher/"))
                .andExpect(content().string(containsString("Choose option")))
                .andExpect(content().string(containsString("List of results")))
                .andExpect(content().string(containsString("Add new homework")))
                .andExpect(content().string(containsString("Add new checker")))
                .andExpect(content().string(containsString("Back to main menu")));
    }

    @Test
    public void showChecker() throws Exception {
        mockMvc.perform(get("/teacher/checker"))
                .andExpect(content().string(containsString("Submit checker")));
    }
}
