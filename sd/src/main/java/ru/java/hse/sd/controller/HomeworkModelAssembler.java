package ru.java.hse.sd.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ru.java.hse.sd.model.view.HomeworkView;

@Component
class HomeworkModelAssembler implements RepresentationModelAssembler<HomeworkView, EntityModel<HomeworkView>> {
    @Override
    public EntityModel<HomeworkView> toModel(HomeworkView homework) {
        return EntityModel.of(homework,
            linkTo(methodOn(StudentController.class).homeworks()).withRel("homeworks"));
    }
}