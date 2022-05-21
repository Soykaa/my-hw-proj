package ru.java.hse.sd.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.java.hse.sd.model.Manager;
import ru.java.hse.sd.model.view.AttemptView;
import ru.java.hse.sd.model.view.HomeworkView;

@RestController
@RequestMapping(path = "teacher")
class TeacherController {
    private final AttemptModelAssembler attemptAssembler;
    private final Manager manager;

    TeacherController(AttemptModelAssembler attemptAssembler) {
        this.attemptAssembler = attemptAssembler;
        manager = new Manager();
    }

    @PostMapping("/homework")
    String homework(@RequestBody Task task) {
        manager.addHomework(
            new HomeworkView(task.id(), task.name(), task.publicationDate(), task.taskDescription(),
                task.deadline(), task.getCheckerId())
        );
        return "OK";
    }

    @PostMapping("/checker")
    String submit(@RequestBody Checker checker) {
        manager.addChecker(checker.getId(), checker.getCode());
        return "OK";
    }

    @GetMapping("/results")
    CollectionModel<EntityModel<AttemptView>> results() {
        List<EntityModel<AttemptView>> attempts = manager.results().stream()
            .map(attemptAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(attempts, linkTo(methodOn(StudentController.class).results()).withSelfRel());
    }
}
