package com.example.rasprsist.controller;

import com.example.rasprsist.entity.SmartBox;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

public interface SmartBoxController {

    @GetMapping
    ResponseEntity<List<SmartBox>> getAll(@RequestHeader(value = "Accept-Language", required = false) Locale locale);

    @GetMapping(path = "{id}")
    ResponseEntity<SmartBox> getById(
            @PathVariable String id,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale
    );

    @PutMapping
    ResponseEntity<String> create(
            @RequestBody SmartBox smartBox,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale
    );

    @PostMapping
    ResponseEntity<String> update(
            @RequestBody SmartBox smartBox,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale
    );

    @DeleteMapping("{id}")
    ResponseEntity<String> delete(
            @PathVariable String id,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale
    );

}
