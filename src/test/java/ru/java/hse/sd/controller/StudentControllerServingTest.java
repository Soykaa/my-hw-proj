package ru.java.hse.sd.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.java.hse.sd.model.Manager;
import ru.java.hse.sd.model.view.HomeworkView;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = StudentHtmlController.class)
public class StudentControllerServingTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void welcome() throws Exception {
        mockMvc.perform(get("/student/welcome"))
                .andExpect(content().string(containsString("Hello, Student!")));
    }

    @Test
    public void menu() throws Exception {
        mockMvc.perform(get("/student/"))
                .andExpect(content().string(containsString("Choose option")))
                .andExpect(content().string(containsString("List of results")))
                .andExpect(content().string(containsString("List of homeworks")))
                .andExpect(content().string(containsString("Back to main menu")));
    }
}