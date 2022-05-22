package ru.java.hse.sd.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
@RequestMapping(path = "student")
public class StudentHtmlController {
    private final HomeworkModelAssembler homeworkAssembler;
    private final AttemptModelAssembler attemptAssembler;
    private final Manager manager;

    StudentHtmlController(HomeworkModelAssembler homeworkAssembler,
                      AttemptModelAssembler attemptAssembler) {
        this.homeworkAssembler = homeworkAssembler;
        this.attemptAssembler = attemptAssembler;
        manager = new Manager();
    }

    @GetMapping("/homeworks")
    CollectionModel<EntityModel<HomeworkView>> homeworks() {
        List<EntityModel<HomeworkView>> homeworks = manager.homeworks().stream()
                .map(homeworkAssembler::toModel) //
                .collect(Collectors.toList());
        return CollectionModel.of(homeworks, linkTo(methodOn(StudentController.class).homeworks()).withSelfRel());
    }


    @GetMapping("/welcome")
    public String welcomeAsHTML(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
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
