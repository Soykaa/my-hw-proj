package ru.java.hse.sd.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.java.hse.sd.model.view.AttemptView;
import ru.java.hse.sd.model.view.HomeworkView;
import ru.java.hse.sd.model.view.MarkView;
import ru.java.hse.sd.model.view.StudentView;

@RestController
@RequestMapping(path = "student")
class StudentController {
    private final HomeworkModelAssembler homeworkAssembler;
    private final AttemptModelAssembler attemptAssembler;

    StudentController(HomeworkModelAssembler homeworkAssembler,
                      AttemptModelAssembler attemptAssembler) {
        this.homeworkAssembler = homeworkAssembler;
        this.attemptAssembler = attemptAssembler;
    }

    @GetMapping("/homeworks")
    CollectionModel<EntityModel<HomeworkView>> homeworks() {
        List<EntityModel<HomeworkView>> homeworks = Stream.of(new HomeworkView("id", "name", LocalDateTime.now(), "task description", LocalDateTime.now()))
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
        List<EntityModel<AttemptView>> attempts = Stream.of(new AttemptView(
            new HomeworkView("id", "name", LocalDateTime.now(), "task description", LocalDateTime.now()),
            new StudentView("name", "lastName"),
            new MarkView("mark"),
            "comment",
            LocalDateTime.now()
        )).map(attemptAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(attempts, linkTo(methodOn(StudentController.class).results()).withSelfRel());
    }
}