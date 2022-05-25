package ru.java.hse.sd.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.hateoas.EntityModel;
import ru.java.hse.sd.model.Manager;
import ru.java.hse.sd.model.view.AttemptView;
import ru.java.hse.sd.model.view.HomeworkView;

import java.util.List;

public class TeacherControllerTest {
    private final Manager manager = Mockito.mock(Manager.class);

    @Test
    public void testHomework() {
        var controller = new TeacherController(new AttemptModelAssembler());
        controller.setManager(manager);
        var result = controller.homework(new Task());
        Assertions.assertEquals("OK", result);
    }

    @Test
    public void testSubmit() {
        var controller = new TeacherController(new AttemptModelAssembler());
        controller.setManager(manager);
        var result = controller.submit(new Checker());
        Assertions.assertEquals("OK", result);
    }

    @Test
    public void testResults() {
        var homeworkView = new HomeworkView("test-homework-id", null, null, null, null);
        var attemptView = new AttemptView(homeworkView, null, null, null);
        Mockito.when(manager.results()).thenReturn(List.of(attemptView));
        var controller = new TeacherController(new AttemptModelAssembler());
        controller.setManager(manager);
        var result = controller.results();
        Assertions.assertEquals(1, result.getContent().size());
        Assertions.assertEquals("test-homework-id",
                ((AttemptView)((EntityModel)result.getContent().toArray()[0]).getContent()).homework().name());
    }
}
