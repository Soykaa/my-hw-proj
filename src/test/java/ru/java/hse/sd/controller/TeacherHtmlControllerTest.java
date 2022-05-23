package ru.java.hse.sd.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import ru.java.hse.sd.model.Manager;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TeacherHtmlControllerTest {
    private final Manager manager = Mockito.mock(Manager.class);

    private final Model model = Mockito.mock(Model.class);

    @Test
    public void testResults() {
        var controller = new TeacherHtmlController();
        controller.setManager(manager);
        controller.results(model);
        verify(manager, times(1)).results();
    }

    @Test
    public void testSubmitHomework() {
        var controller = new TeacherHtmlController();
        controller.setManager(manager);
        controller.submitHomework(new Task(), model);
        verify(manager, times(1)).addHomework(Mockito.any());
    }

    @Test
    public void testSubmitChecker() {
        var controller = new TeacherHtmlController();
        controller.setManager(manager);
        controller.submitChecker(new Checker(), model);
        verify(manager, times(1)).addChecker(Mockito.any(), Mockito.any());
    }
}
