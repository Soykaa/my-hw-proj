package ru.java.hse.sd.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ru.java.hse.sd.model.view.AttemptView;

@Component
class AttemptModelAssembler implements RepresentationModelAssembler<AttemptView, EntityModel<AttemptView>> {
    @Override
    public EntityModel<AttemptView> toModel(AttemptView attempt) {
        return EntityModel.of(attempt,
            linkTo(methodOn(StudentController.class).results()).withRel("attempts"));
    }
}
