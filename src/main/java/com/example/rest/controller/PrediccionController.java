package com.example.rest.controller;

import com.example.rest.dto.PredResDTO;
import com.example.rest.model.PrediccionBody;
import com.example.rest.service.PrediccionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
public class PrediccionController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PrediccionService prediccionService;

    @PostMapping("/predecir")
    public ResponseEntity<?> predecir(@RequestBody PrediccionBody prediccionBody) throws IOException, InterruptedException {
        String response = prediccionService.predecir(prediccionBody).body();
        PredResDTO predResDTO = objectMapper.readValue(response, PredResDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(predResDTO);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar(@RequestBody Object datos) {

        return ResponseEntity.ok(datos);
    }
}
