package com.example.rasprsist.controller;

import com.example.rasprsist.entity.SmartBox;
import com.example.rasprsist.service.SmartBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("box")
public class SmartBoxControllerImpl implements SmartBoxController {

    @Autowired
    private SmartBoxService smartBoxService;

    @Override
    public ResponseEntity<List<SmartBox>> getAll(Locale locale) {
        return ResponseEntity.ok(this.smartBoxService.getAll(locale));
    }

    @Override
    public ResponseEntity<SmartBox> getById(String id, Locale locale) {
        return ResponseEntity.ok(this.smartBoxService.getById(id, locale));
    }

    @Override
    public ResponseEntity<String> create(SmartBox smartBox, Locale locale) {
        return ResponseEntity.ok(this.smartBoxService.create(smartBox, locale));
    }

    @Override
    public ResponseEntity<String> update(SmartBox smartBox, Locale locale) {
        return ResponseEntity.ok(this.smartBoxService.update(smartBox, locale));
    }

    @Override
    public ResponseEntity<String> delete(String id, Locale locale) {
        return ResponseEntity.ok(this.smartBoxService.delete(id, locale));
    }

}
