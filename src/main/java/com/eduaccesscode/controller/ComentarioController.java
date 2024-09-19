package com.eduaccesscode.controller;

import com.eduaccesscode.dto.ComentarioDTO;
import com.eduaccesscode.service.ComentarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/comentarios")
@Validated
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<String> publicarComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) {
        try {
            String respuesta = comentarioService.publicarComentario(comentarioDTO);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
