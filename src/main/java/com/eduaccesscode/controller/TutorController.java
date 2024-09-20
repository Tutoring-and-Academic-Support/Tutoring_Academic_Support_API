package com.eduaccesscode.controller;

import com.eduaccesscode.model.entity.Tutor;
import com.eduaccesscode.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TutorController {

    @Autowired
    private TutorRepository tutorRepository;

    // Endpoint para registrar una nueva tutora
    @PostMapping("/register")
    public ResponseEntity<String> registerTutor(@RequestBody Tutor tutor) {
        // Guardar la tutora en la base de datos
        tutorRepository.save(tutor);
        return ResponseEntity.ok("Tutora registrada con éxito");
    }
}

