package ru.java.hse.sd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.java.hse.sd.model.Manager;
import ru.java.hse.sd.model.view.AttemptView;
import ru.java.hse.sd.model.view.HomeworkView;

import java.util.List;

@Controller
@RequestMapping(path = "student")
public class StudentHtmlController {
    private final Manager manager;

    StudentHtmlController() {
        manager = new Manager();
    }

    @GetMapping("/homeworks")
    public String homeworks(Model model) {
        List<HomeworkView> homeworks = manager.homeworks();
        model.addAttribute("homeworks", homeworks);
        return "homeworks";
    }

    @GetMapping("/welcome")
    public String welcomeAsHTML(@RequestParam(name = "name", required = false, defaultValue = "Student") String name, Model model) {
        model.addAttribute("name", name);
        return "welcome";
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
