package ru.java.hse.sd.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import ru.java.hse.sd.model.Manager;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StudentHtmlControllerTest {
    private final Manager manager = Mockito.mock(Manager.class);

    private final Model model = Mockito.mock(Model.class);

    @Test
    public void testHomeworks() {
        var controller = new StudentHtmlController();
        controller.setManager(manager);
        controller.homeworks(model);
        verify(manager, times(1)).homeworks();
    }

    @Test
    public void testResults() {
        var controller = new StudentHtmlController();
        controller.setManager(manager);
        controller.results(model);
        verify(manager, times(1)).results();
    }

    @Test
    public void testSubmit() throws Exception {
        var controller = new StudentHtmlController();
        var submission = new Submission();
        controller.setManager(manager);
        controller.submitSubmission(submission, model);
        verify(manager, times(1)).submit(Mockito.any());
    }
}
