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
@RequestMapping(path = "student")
class StudentController {
    private final HomeworkModelAssembler homeworkAssembler;
    private final AttemptModelAssembler attemptAssembler;
    private final Manager manager;

    StudentController(HomeworkModelAssembler homeworkAssembler,
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

    @PostMapping("/submit")
    String submit(@RequestBody Submission submission) {
        return "OK";
    }

    @GetMapping("/results")
    CollectionModel<EntityModel<AttemptView>> results() {
        List<EntityModel<AttemptView>> attempts = manager.results().stream()
            .map(attemptAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(attempts, linkTo(methodOn(StudentController.class).results()).withSelfRel());
    }
}