package com.example.projetoFinal.controller;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RequestMapping
public class Controller {
    @GetMapping("/ajuda")
    public ResponseEntity<Map<String, Object>> getAjuda(){
        Map<String, Object> ajuda = new HashMap<>();
        ajuda.put("estudantes", Arrays.asList("Ana Julia Santinoni", "Laura Silveira", "Janaina Joao"));
        ajuda.put("projeto", "Agrotec");
        ajuda.put("tema", "Agricultura e Segurança Alimentar");
        return ResponseEntity.ok(ajuda);
    }

}
