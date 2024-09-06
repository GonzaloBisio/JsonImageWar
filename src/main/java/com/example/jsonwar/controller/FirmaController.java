package com.example.jsonwar.controller;

import com.example.jsonwar.model.Firma;
import com.example.jsonwar.service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vaadin.crudui.crud.CrudListener;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("/api/data")
public class FirmaController implements CrudListener<Firma> {

    @Autowired
    private FirmaService parseJson;

    @PostMapping("/parse")
    public Firma parseJson(@RequestBody String jsonString) throws IOException {
        return parseJson.parseJson(jsonString);
    }

    @Override
    public Firma add(Firma firma) {
        return null;
    }

    @Override
    public Firma update(Firma firma) {
        return null;
    }

    @Override
    public void delete(Firma firma) {

    }

    @Override
    public Collection<Firma> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
