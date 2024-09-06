package com.example.jsonwar.controller;

import com.example.jsonwar.model.Firma;
import com.example.jsonwar.service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/data")
public class FirmaController {

    @Autowired
    private FirmaService firmaService;

    @PostMapping("/parse")
    public Firma parseJson(@RequestBody String jsonString) throws IOException {
        return firmaService.parseJson(jsonString);
    }
}
