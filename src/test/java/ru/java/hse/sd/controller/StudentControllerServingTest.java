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

    @MockBean
    private Manager manager;

//    @Test
//    public void homeworks() throws Exception {
//        var homeworkView = new HomeworkView("test-homework-idddd", null, null, null, null);
//        Mockito.when(manager.homeworks()).thenReturn(List.of(homeworkView));
//        mockMvc.perform(get("/student/homeworks"))
//                .andExpect(content().string(containsString("test-homework-id")));
//    }

    @Test
    public void welcome() throws Exception {
        mockMvc.perform(get("/student/welcome"))
                .andExpect(content().string(containsString("Hello, Student!")));
    }

//    @Test
//    public void results() throws Exception {
//        mockMvc.perform(get("/student/results"))
//                .andExpect(content().string(containsString("look attempt")));
//    }
//
//    @Test
//    public void oneResult() throws Exception {
//        mockMvc.perform(get("/student/results/0"))
//                .andExpect(content().string(containsString("Homework:")));
//    }
}