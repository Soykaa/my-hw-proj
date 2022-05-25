package ru.java.hse.sd.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.EntityModel;
import ru.java.hse.sd.model.Manager;
import ru.java.hse.sd.model.view.AttemptView;
import ru.java.hse.sd.model.view.HomeworkView;

import java.util.List;

public class StudentControllerTest {
    private final Manager manager = Mockito.mock(Manager.class);

    @Test
    public void testHomeworks() {
        var homeworkView = new HomeworkView("test-homework-id", null, null, null, null);
        Mockito.when(manager.homeworks()).thenReturn(List.of(homeworkView));
        var controller = new StudentController(new HomeworkModelAssembler(), new AttemptModelAssembler());
        controller.setManager(manager);
        var result = controller.homeworks();
        Assertions.assertEquals(1, result.getContent().size());
        Assertions.assertEquals("test-homework-id",
                ((HomeworkView)((EntityModel)result.getContent().toArray()[0]).getContent()).name());
    }

    @Test
    public void testSubmit() throws Exception {
        var controller = new StudentController(new HomeworkModelAssembler(), new AttemptModelAssembler());
        controller.setManager(manager);
        var result = controller.submit(new Submission());
        Assertions.assertEquals("Ok", result);
    }

    @Test
    public void testResults() {
        var homeworkView = new HomeworkView("test-homework-id", null, null, null, null);
        var attemptView = new AttemptView(homeworkView, null, null, null);
        Mockito.when(manager.results()).thenReturn(List.of(attemptView));
        var controller = new StudentController(new HomeworkModelAssembler(), new AttemptModelAssembler());
        controller.setManager(manager);
        var result = controller.results();
        Assertions.assertEquals(1, result.getContent().size());
        Assertions.assertEquals("test-homework-id",
                ((AttemptView)((EntityModel)result.getContent().toArray()[0]).getContent()).homework().name());
    }
}
