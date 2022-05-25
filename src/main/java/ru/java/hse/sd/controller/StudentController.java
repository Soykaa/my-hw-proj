package ru.java.hse.sd.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import ru.java.hse.sd.model.Manager;
import ru.java.hse.sd.model.view.AttemptView;
import ru.java.hse.sd.model.view.HomeworkView;
import ru.java.hse.sd.model.view.SubmissionView;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Controller class that responds to student actions (requests). Works with JSON.
 **/
@RestController
@RequestMapping(path = "student")
public class StudentController {
    private final HomeworkModelAssembler homeworkAssembler;
    private final AttemptModelAssembler attemptAssembler;
    private Manager manager;

    /**
     * Creates new instance of StudentController object.
     * Initialises homeworkAssembler and attemptAssembler with the given values, creates new Manager instance in it.
     *
     * @param homeworkAssembler homework assembler
     * @param attemptAssembler  attempt assembler
     **/
    public StudentController(HomeworkModelAssembler homeworkAssembler,
                             AttemptModelAssembler attemptAssembler) {
        this.homeworkAssembler = homeworkAssembler;
        this.attemptAssembler = attemptAssembler;
        manager = new Manager();
    }

    /**
     * Setter for manager. It is used only in tests
     * @param manager manager
     */
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    /**
     * Returns list of homeworks in the correct order.
     *
     * @return list of homeworks
     **/
    @GetMapping("/homeworks-json")
    public CollectionModel<EntityModel<HomeworkView>> homeworks() {
        List<EntityModel<HomeworkView>> homeworks = manager.homeworks().stream()
                .map(homeworkAssembler::toModel) //
                .collect(Collectors.toList());
        return CollectionModel.of(homeworks, linkTo(methodOn(StudentController.class).homeworks()).withSelfRel());
    }

    /**
     * Submits solution.
     *
     * @param submission submitted solution
     * @return submission result
     * @throws Exception in case of incorrect submission
     **/
    @PostMapping("/submit-json")
    String submit(@RequestBody Submission submission) throws Exception {
        manager.submit(new SubmissionView(submission.getHomeworkId(), submission.getSolutionUrl()));
        return "Ok";
    }

    /**
     * Returns list of results, sorted by due date.
     *
     * @return list of results
     **/
    @GetMapping("/results-json")
    CollectionModel<EntityModel<AttemptView>> results() {
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
    EntityModel<AttemptView> results(@PathVariable Integer id) {
        return manager.results().stream()
                .map(attemptAssembler::toModel) //
                .collect(Collectors.toList()).get(id);
    }
}