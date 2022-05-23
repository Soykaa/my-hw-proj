package ru.java.hse.sd.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.EntityModel;
import ru.java.hse.sd.model.Manager;
import ru.java.hse.sd.model.view.HomeworkView;

import java.util.List;

public class StudentControllerTest {
    private Manager manager = Mockito.mock(Manager.class);

    @Test
    public void homeworks() {
        var homeworkView = new HomeworkView("test-homework-id", null, null, null, null);
        Mockito.when(manager.homeworks()).thenReturn(List.of(homeworkView));
        var controller = new StudentController(manager);
        var result = controller.homeworks();
        Assertions.assertEquals(1, result.getContent().size());
        Assertions.assertEquals("test-homework-id",
                ((HomeworkView)((EntityModel)result.getContent().toArray()[0]).getContent()).name());
    }
}
