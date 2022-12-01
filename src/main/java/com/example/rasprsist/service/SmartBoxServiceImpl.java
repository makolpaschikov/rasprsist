package com.example.rasprsist.service;

import com.example.rasprsist.controller.SmartBoxControllerImpl;
import com.example.rasprsist.entity.SmartBox;
import com.example.rasprsist.repository.SmartBoxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class SmartBoxServiceImpl implements SmartBoxService {

    @Autowired
    private SmartBoxRepo smartBoxRepo;

    @Autowired
    MessageSource messages;

    @Override
    public List<SmartBox> getAll(Locale locale) {
        return this.smartBoxRepo.findAll().stream().map(box ->
                box.add(
                        linkTo(methodOn(SmartBoxControllerImpl.class)
                                .getAll(null)).withSelfRel().withSelfRel(),
                        linkTo(methodOn(SmartBoxControllerImpl.class)
                                .create(box, null)).withRel(messages.getMessage("box.create.link", null, locale)),
                        linkTo(methodOn(SmartBoxControllerImpl.class)
                                .update(box, null)).withRel(messages.getMessage("box.update.link", null, locale)),
                        linkTo(methodOn(SmartBoxControllerImpl.class)
                                .delete(box.getId(), null)).withRel(messages.getMessage("box.delete.link", null, locale))
                )
        ).collect(Collectors.toList());
    }

    @Override
    public SmartBox getById(String id, Locale locale) {
        var box = this.smartBoxRepo.findById(id).get();

        box.add(
                linkTo(methodOn(SmartBoxControllerImpl.class)
                        .getAll(null)).withSelfRel().withSelfRel(),
                linkTo(methodOn(SmartBoxControllerImpl.class)
                        .create(box, null)).withRel(messages.getMessage("box.create.link", null, locale)),
                linkTo(methodOn(SmartBoxControllerImpl.class)
                        .update(box, null)).withRel(messages.getMessage("box.update.link", null, locale)),
                linkTo(methodOn(SmartBoxControllerImpl.class)
                        .delete(box.getId(), null)).withRel(messages.getMessage("box.delete.link", null, locale))
        );

        return box;
    }

    @Override
    public String create(SmartBox smartBox, Locale locale) {
        var created = this.smartBoxRepo.save(smartBox);
        return String.format(messages.getMessage("box.create.message", null, locale), created);
    }

    @Override
    public String update(SmartBox smartBox, Locale locale) {
        var updated = this.smartBoxRepo.save(smartBox);
        return String.format(messages.getMessage("box.update.message", null, locale), updated);
    }

    @Override
    public String delete(String id, Locale locale) {
        this.smartBoxRepo.deleteById(id);
        return String.format(messages.getMessage("box.delete.message", null, locale), id);
    }

}
