package ru.java.hse.sd.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.java.hse.sd.model.Manager;
import ru.java.hse.sd.model.view.AttemptView;
import ru.java.hse.sd.model.view.HomeworkView;

/**
 * Controller class that responds to teacher actions (requests). Works with JSON.
 **/
@RestController
@RequestMapping(path = "teacher")
public class TeacherController {
    private final AttemptModelAssembler attemptAssembler;
    private final Manager manager;

    /**
     * Creates new instance of TeacherController object.
     * Initialises attemptAssembler with the given value, creates new Manager instance in it.
     *
     * @param attemptAssembler attempt assembler
     **/
    public TeacherController(AttemptModelAssembler attemptAssembler) {
        this.attemptAssembler = attemptAssembler;
        manager = new Manager();
    }

    /**
     * Adds task.
     *
     * @param task task to add
     * @return result of adding
     **/
    @PostMapping("/homework")
    public String homework(@RequestBody Task task) {
        manager.addHomework(
                new HomeworkView(task.name(), task.publicationDate(), task.taskDescription(),
                        task.deadline(), task.getCheckerId())
        );
        return "OK";
    }

    /**
     * Adds checker.
     *
     * @param checker checker to add
     * @return result of adding
     **/
    @PostMapping("/checker")
    public String submit(@RequestBody Checker checker) {
        manager.addChecker(checker.getId(), checker.getCode());
        return "OK";
    }

    /**
     * Returns list of results, sorted by due date.
     *
     * @return list of results
     **/
    @GetMapping("/results-json")
    public CollectionModel<EntityModel<AttemptView>> results() {
        List<EntityModel<AttemptView>> attempts = manager.results().stream()
                .map(attemptAssembler::toModel) //
                .collect(Collectors.toList());
        return CollectionModel.of(attempts, linkTo(methodOn(StudentController.class).results()).withSelfRel());
    }

    /**
     * Returns result which corresponds passed id.
     *
     * @param id id
     * @return result
     **/
    @GetMapping("/results-json/{id}")
    public EntityModel<AttemptView> results(@PathVariable Integer id) {
        return manager.results().stream()
                .map(attemptAssembler::toModel) //
                .collect(Collectors.toList()).get(id);
    }
}
