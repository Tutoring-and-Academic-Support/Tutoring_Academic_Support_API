package com.eduaccesscode.controller;

import com.eduaccesscode.model.entity.Estudiante;
import com.eduaccesscode.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Estudiante estudiante) {
            Estudiante estudianteExistente = estudianteService.sesionEstudiante(estudiante);
            return ResponseEntity.ok("Inicio de sesion exitoso");
    }

    @GetMapping("/{id}")
    public Estudiante getEstudianteById(@PathVariable int id ) {
        return estudianteService.findById(id);
    }

}
