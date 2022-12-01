package com.example.rasprsist.service;

import com.example.rasprsist.entity.SmartBox;

import java.util.List;
import java.util.Locale;

public interface SmartBoxService {

    List<SmartBox> getAll(Locale locale);

    SmartBox getById(String id, Locale locale);

    String create(SmartBox smartBox, Locale locale);

    String update(SmartBox smartBox, Locale locale);

    String delete(String id, Locale locale);

}
