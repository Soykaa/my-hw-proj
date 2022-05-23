package ru.java.hse.sd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.java.hse.sd.model.Manager;
import ru.java.hse.sd.model.view.AttemptView;
import ru.java.hse.sd.model.view.HomeworkView;

import java.util.List;

/**
 * Controller class that responds to student actions (requests). Works with HTML.
 **/
@Controller
@RequestMapping(path = "teacher")
public class TeacherHtmlController {
    private final Manager manager;

    /**
     * Creates new instance of TeacherHtmlController object.
     * Creates new Manager instance in it.
     **/
    TeacherHtmlController() {
        manager = new Manager();
    }

    /**
     * Returns list of results, sorted by due date.
     *
     * @param model model
     * @return page with list of results
     **/
    @GetMapping("/results")
    public String results(Model model) {
        List<AttemptView> attempts = manager.results();
        model.addAttribute("attempts", attempts);
        return "teacher_results";
    }

    /**
     * Returns result which corresponds passed id.
     *
     * @param id id
     * @return page with result
     **/
    @GetMapping("/results/{id}")
    public String results(@PathVariable Integer id, Model model) {
        AttemptView attempt = manager.results().get(id);
        model.addAttribute("attempt", attempt);
        return "teacher_result";
    }

    /**
     * Mostly for testing.
     **/
    @GetMapping("/welcome")
    public String welcomeAsHTML(@RequestParam(name = "name", required = false, defaultValue = "Teacher") String name,
                                Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }

    @GetMapping("/homework")
    public String showHomework(Model model) {
        model.addAttribute("task", new Task());
        return "homework";
    }

    @PostMapping("/homework")
    public String submitHomework(@ModelAttribute Task task, Model model) {
        model.addAttribute("task", task);
        manager.addHomework(
                new HomeworkView(task.getName(), task.getPublicationDate(), task.getTaskDescription(),
                        task.getDeadline(), task.getCheckerId())
        );
        return "homework_result";
    }

    @GetMapping("/checker")
    public String showChecker(Model model) {
        model.addAttribute("checker", new Checker());
        return "checker";
    }

    @PostMapping("/checker")
    public String submitChecker(@ModelAttribute Checker checker, Model model) {
        model.addAttribute("checker", checker);
        manager.addChecker(checker.getId(), checker.getCode());
        return "checker_result";
    }

    @GetMapping("/")
    public String showTeacherMenu() {
        return "teacher_menu";
    }
}
