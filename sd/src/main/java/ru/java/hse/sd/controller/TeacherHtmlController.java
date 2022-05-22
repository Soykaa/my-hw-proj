package ru.java.hse.sd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.java.hse.sd.model.Manager;
import ru.java.hse.sd.model.view.AttemptView;

import java.util.List;

@Controller
@RequestMapping(path = "teacher")
public class TeacherHtmlController {
    private final Manager manager;

    TeacherHtmlController() {
        manager = new Manager();
    }

    @GetMapping("/results")
    public String results(Model model) {
        List<AttemptView> attempts = manager.results();
        model.addAttribute("attempts", attempts);
        return "results";
    }

    @GetMapping("/results/{id}")
    public String results(@PathVariable Integer id, Model model) {
        AttemptView attempt = manager.results().get(id);
        model.addAttribute("attempt", attempt);
        return "result";
    }
}
