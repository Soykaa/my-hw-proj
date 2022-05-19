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
@RequestMapping(path = "teacher")
class TeacherController {
    private final AttemptModelAssembler attemptAssembler;

    TeacherController(AttemptModelAssembler attemptAssembler) {
        this.attemptAssembler = attemptAssembler;
    }

    @PostMapping("/homework")
    String homework(@RequestBody Task task) {
        return "OK";
    }

    @PostMapping("/checker")
    String submit(@RequestBody Checker checker) {
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
